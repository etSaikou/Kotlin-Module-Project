package views

import Reader
import ViewType
import entity.Archive
import entity.Note
import functions.createNote

class ArchiveView {
    private val noteView = NoteView()

    fun start(archive: Archive) {
        val reader = Reader<Note>("Создать заметку", archive.notes)
        reader.start(
            addCallback = ::createNote,
            viewType = ViewType.ARCHIVE,
            transitCallback = noteView::start,
            greeting = archive.title
        )
    }

}