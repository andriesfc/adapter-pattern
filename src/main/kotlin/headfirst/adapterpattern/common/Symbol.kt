package headfirst.adapterpattern.common

enum class Symbol(private val value: String) {

    THUMBS_UP("\uD83D\uDC4D"),
    VERT_LINE_THIN("|"),
    VERT_LINE_DOTTED("⋮")
    ;
    override fun toString(): String = value
}