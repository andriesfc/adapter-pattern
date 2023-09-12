package headfirst.adapterpattern.commandline

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import headfirst.adapterpattern.common.Symbol

object RootCommand : CliktCommand(
    name = "hf-adapter-pattern",
    help = """
        |Head First Design Patterns: The Adapter Pattern
        |
        |Runs some examples and exercises from the book.
    """.trimMargin(),
    printHelpOnEmptyArgs = true,
    epilog = "Try me\n${Symbol.THUMBS_UP}"
) {
    override fun run() = Unit

    init {
        subcommands(
            ExerciseDucks,
            DemoEnumerationAdapter
        )
    }

}


