package headfirst.adapterpattern.common


enum class Alignment {
    Left,
    Right,
}


fun String.fixedWith(width: Int, align: Alignment): String = buildString(width) {
    val source = this@fixedWith
    if (source.length >= width)
        append(source, 0, width)
    else when (align) {

        Alignment.Left -> {
            append(source)
            repeat(width - source.length) { append(' ') }
        }

        Alignment.Right -> {
            repeat(width - source.length) {  append(' ')  }
            append(source)
        }
    }
}