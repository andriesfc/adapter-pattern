package headfirst.adapterpattern.common

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.enum


abstract class DemoRunner<T : DemoRunner<T>>(
    val demoCommand: String,
    val demoCommandDescription: String,
    val demoSourceDocs: Set<SourceDoc>,
) : CliktCommand(
    name = demoCommand,
    help = demoCommandDescription
) {

    private val sourceAction: SourceAction? by option(
        names = arrayOf("--source"),
        help = """
            Instead of running demos, rather look at the sources.
        """.trimIndent(),
        helpTags = mapOf(
            SourceAction.Print.arg to "Prints out sources to the console",
            SourceAction.List.arg to "List all sources"
        ),
    ).enum<SourceAction>(key = SourceAction::arg)

    private enum class SourceAction(val arg: String) {
        Print("print"),
        List("list"),
    }

    protected abstract fun runDemo()
    override fun run() {
        when (sourceAction) {
            SourceAction.Print -> printSource(SupportedPrinting.SimpleLinByLine)
            SourceAction.List -> listSources()
            null -> runDemo()
        }
    }

    private fun printSource(printer: DocumentPrinter) {
    }

    private fun listSources() {
        demoSourceDocs.sortedBy(SourceDoc::title).forEachIndexed { index, (title, path, url) ->
            println("${index + 1}: $title")
            println("\t/$path")
        }
    }

}