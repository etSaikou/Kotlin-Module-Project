package views

import Reader
import ViewType
import entity.Note


class NoteView{

    fun start(note: Note) {

        val reader = Reader<Note>(
            "Дополнить заметку",
            mutableListOf<Note>(note)
        )

        reader.start(
            addCallback = { note },
            transitCallback = {},
            viewType = ViewType.NOTE,
            greeting = note.title
        )
    }
}