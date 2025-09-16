enum class ViewType {
    LIBRARY,
    ARCHIVE,
    NOTE;

    fun printExit(){
        when(this){
            ViewType.LIBRARY -> println("Завершение работы...")
            ViewType.ARCHIVE -> println("Возвращаемся к архивам...")
            ViewType.NOTE -> println("Возвращаемся к архиву...")
        }
    }

    fun printEntering(str: String){
        when (this) {
            ViewType.LIBRARY -> println("Добро пожаловать в Архивы")
            ViewType.ARCHIVE -> println("Архив: $str")
            ViewType.NOTE -> println("Заметка: $str")
        }
    }
}