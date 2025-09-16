package views

import Reader
import ViewType
import entity.Archive
import functions.createArchive

class LibraryView {
    private val archives = mutableListOf<Archive>()
    private val archiveView = ArchiveView()
    private val reader = Reader<Archive>("Создать архив", archives)


    fun start() {
        reader.start(
            addCallback = ::createArchive,
            transitCallback = archiveView::start,
            viewType = ViewType.LIBRARY
        )
    }

}