package headfirst.adapterpattern.common

import java.net.URL

data class SourceDoc(
    val title: String,
    val path: String,
    val resolved: URL?,
) {
    companion object {

        inline fun <reified T> of(title: String, path: String = "${T::class.java.simpleName}.kt") = SourceDoc(
            title = title,
            path = path,
            resolved = T::class.java.getResource(path)
        )
    }
}
