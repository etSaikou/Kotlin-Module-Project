package functions

import java.util.Scanner


val scanner = Scanner(System.`in`)

fun getLine(firstMsg: String, secMsg: String, condition: Boolean = false): String {
    var str: String? = null

    while (str.isNullOrBlank()) {
        println(firstMsg)
        str = scanner.nextLine().lowercase()

        if (condition && str != "да" && str != "нет") {
            str = null
        }
        if (str.isNullOrBlank()) {
            println(secMsg)
        }
    }
    return str
}

fun getDigit(range: IntRange): Int? {

    var result: Int? = null
    var line = scanner.nextLine()
    line.runCatching {

        this?.toInt()
    }.onSuccess {
        result =
            if (it in range) it else null.also { println("Ошибка ввода. Некорректный номер команды") }
    }.onFailure {
        println("Ошибка ввода. Введите номер команды")
        null
    }

    return result
}
