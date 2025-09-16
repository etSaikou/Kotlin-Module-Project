import entity.BaseNote

class CommandGenerator<T> where T : BaseNote {
    private val commandList: MutableList<String> = mutableListOf()
    fun getCommands() = commandList


    fun getCommands(type: String, list: List<T>): List<String> {
        commandList.clear()
        commandList.add(type)
        list.forEach {
            commandList.add(it.title)
        }
        commandList.add("Выход")
        return commandList
    }

    fun updateList(command: T) {
        commandList.removeLast()
        commandList.add(command.title)
        commandList.add("Выход")
    }

    fun updateList(command: String, index: Int) {
        commandList.removeAt(index)
        commandList.add(index,command)

    }
}