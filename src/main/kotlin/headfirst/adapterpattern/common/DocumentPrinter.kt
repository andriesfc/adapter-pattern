package headfirst.adapterpattern.common

import java.io.PrintWriter
import java.io.Reader

interface DocumentPrinter {
    fun printDocument(
        source: Reader,
        dest: PrintWriter,
    )
}

