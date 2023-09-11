package headfirst.adapterpattern.common

import java.io.PrintWriter
import java.io.Reader

sealed class SupportedPrinting : DocumentPrinter {

    data object SimpleLinByLine : DocumentPrinter {
        override fun printDocument(source: Reader, dest: PrintWriter) {
            source.forEachLine(dest::println)
        }

    }

}