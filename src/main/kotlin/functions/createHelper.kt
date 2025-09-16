package functions

import entity.Archive
import entity.Note

fun createArchive(): Archive {
    var title = getLine("Введите название архива", "Название не может быть пустым")
    val notes = mutableListOf<Note>()

    var needNote = true

    while (needNote) {
        notes.add(createNote())
        needNote =
            getLine("Добавить ещё одну заметку?(Да/Нет)", "Повторите ввод команды", true).equals(
                "ДА",
                true
            )
    }
    return Archive(title).apply {
        this.notes.addAll(notes)
    }

}

fun updateNote(note: Note): Note {
    note.addContent(getLine("Допишите содержание заметки", "Содержание не может быть пустым"))
    return note
}

fun createNote(): Note {
    var noteTitle = getLine("Введите название заметки", "Название не может быть пустым")
    var noteContent = getLine("Напишите содержание заметки", "Содержание не может быть пустым")
    return Note(noteTitle, noteContent)
}