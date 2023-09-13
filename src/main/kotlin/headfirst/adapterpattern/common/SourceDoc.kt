package headfirst.adapterpattern.common

import java.net.URL

data class SourceDoc(
    val title: String,
    val resource: String,
    val resourceUrl: URL?,
) {
    companion object {
        inline fun <reified T> of(title: String, resource: String = "${T::class.java.simpleName}.kt") = SourceDoc(
            title = title,
            resource = resource,
            resourceUrl = T::class.java.getResource(resource)
        )
    }
}
