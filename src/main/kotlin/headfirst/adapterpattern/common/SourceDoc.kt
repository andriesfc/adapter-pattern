package headfirst.adapterpattern.common

import java.net.URL

data class SourceDoc(
    val title: String,
    val document: String,
    val resourceUrl: URL?,
) {
    companion object {
        inline fun <reified T> of(title: String, location: String = "${T::class.java.simpleName}.kt") = SourceDoc(
            title = title,
            document = location,
            resourceUrl = T::class.java.getResource(location)
        )
    }
}
