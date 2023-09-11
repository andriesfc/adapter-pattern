package headfirst.adapterpattern.commandline

import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.default
import com.github.ajalt.clikt.parameters.types.double
import headfirst.adapterpattern.common.DemoRunner
import headfirst.adapterpattern.common.SourceDoc
import headfirst.adapterpattern.excerise.EnumerationIterator
import headfirst.adapterpattern.excerise.demoUseOfVector

internal object DemoEnumerationAdapter : DemoRunner<DemoEnumerationAdapter>(
    demoCommand = "demo-enumeration-adapter",
    demoCommandDescription = "Demonstrates how enum adapter is used to access old style enums as iterators",
    demoSourceDocs = setOf(
        SourceDoc.of<EnumerationIterator<*>>("Adapter for old style enumerator"),
        SourceDoc.of<EnumerationIterator<*>>("Demo Usage", "Demos.kt")
    ),
) {

    private val x by argument(name = "x").double().default(10.0)
    private val y by argument(name = "y").double().default(20.0)
    private val z by argument(name = "z").double().default(-13.0)

    override fun runDemo() {
        demoUseOfVector(x, y, z)
    }
}