import entity.BaseNote
import entity.Note
import functions.getDigit
import functions.updateNote

class Reader<T : BaseNote>(
    genFirstCommand: String,
    private val list: MutableList<T>
) {
    private val generator = CommandGenerator<T>()
    private var commandList = generator.getCommands(genFirstCommand, list)
    private var command: Int? = null

    fun start(
        addCallback: () -> T,
        transitCallback: (T) -> Unit,
        viewType: ViewType,
        greeting: String = ""

    ) {
        if (viewType == ViewType.NOTE) {
            generator.updateList("Просмотреть заметку", 1)
        }

        while (command != commandList.lastIndex) {

            viewType.printEntering(greeting)
            commandList = generator.getCommands()
            commandList.forEachIndexed { id, str ->
                println("$id. $str")
            }
            command = getDigit(0..commandList.size - 1)

            if (command == null) {
                continue
            }

            when (command) {
                0 -> {

                    if (viewType == ViewType.NOTE) {
                        updateNote(list[0] as Note)
                    } else {
                        list.add(addCallback.invoke().also { listener(it) })
                    }
                }

                commandList.lastIndex -> {
                    viewType.printExit()
                    break
                }

                else -> {
                    if (viewType == ViewType.NOTE) {
                        val note = list[0] as Note
                        println("Содержание: ${note.content}")
                    } else {
                        transitCallback(list[command!! - 1])
                    }
                }
            }
        }
    }

    private fun listener(element: T) {

        generator.updateList(element)
    }
}