package entity

data class Archive(override val title: String, val notes: MutableList<Note> = mutableListOf<Note>()): BaseNote(title) {
}


