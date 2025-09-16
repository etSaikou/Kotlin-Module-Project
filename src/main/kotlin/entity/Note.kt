package entity

data class Note(override val title: String, var content: String) : BaseNote(title) {


    fun addContent(content: String) {
        this.content += " $content"
    }

}
