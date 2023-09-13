package headfirst.adapterpattern.common

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.types.enum
import kotlin.math.max

abstract class DemoRunner<T : DemoRunner<T>>(
    val demoCommand: String,
    val demoCommandDescription: String,
    val demoSourceDocs: Set<SourceDoc>,
) : CliktCommand(
    name = demoCommand,
    help = demoCommandDescription
) {

    private val sourceListing = demoSourceDocs.filter { doc -> doc.resourceUrl != null }.sortedBy { it.resource }

    private val sourceAction: SourceAction? by option(
        names = arrayOf("--source"),
        help = """
            Instead of running demos, rather look at the sources.
        """.trimIndent(),
        helpTags = mapOf(
            SourceAction.View.arg to "View source file",
            SourceAction.List.arg to "List all sources"
        ),
    ).enum<SourceAction>(key = SourceAction::arg)

    private enum class SourceAction(val arg: String) {
        View("view"),
        List("list"),
    }

    protected abstract fun runDemo()
    override fun run() {
        when (sourceAction) {
            SourceAction.View -> printSources()
            SourceAction.List -> listSources()
            null -> runDemo()
        }
    }

    private fun printSources() {
        listSources()
        if (sourceListing.isEmpty()) {
            currentContext.console.print("Sorry no sources to view", true)
        } else {
            val choice =
                currentContext.console.promptForLine(
                    "Choose a number between 1 and ${sourceListing.size}: ",
                    hideInput = false
                )

            val docNo = choice
                ?.toIntOrNull()
                ?.takeUnless { it < 1 || it > sourceListing.size }
                ?: currentContext.fail("Not a valid choice : $choice")

            val doc = sourceListing[docNo - 1]
            println()
            println(doc.title)
            println()
            doc.resourceUrl!!.openStream().bufferedReader().forEachLine { println(it) }
        }
    }

    private fun listSources() {

        val listing: List<Array<String>> = sourceListing
            .withIndex()
            .map { (i, doc) ->
                arrayOf(
                    (i + 1).toString(),
                    doc.resource,
                    doc.title
                )
            }

        val headings = arrayOf("Doc Index #", "Document", "Title")
        val dimensions = listing.fold(headings.map { it.length }.toTypedArray()) { acc, r ->
            acc[0] = max(acc[0], r[0].length)
            acc[1] = max(acc[1], r[1].length)
            acc[2] = max(acc[2], r[2].length)
            acc
        }

        headings.onEachIndexed { i, s -> headings[i] = s.fixedWith(dimensions[i], Alignment.Left) }

        val heading = headings.joinToString(" | ")

        println(heading)
        repeat(heading.length) { print('-') }; println()

        listing
            .onEach { row ->
                row.forEachIndexed { i, s ->
                    row[i] = s.fixedWith(dimensions[i], if (i == 0) Alignment.Right else Alignment.Left)
                }
            }
            .forEach { row -> println(row.joinToString(" | ")) }

    }

}