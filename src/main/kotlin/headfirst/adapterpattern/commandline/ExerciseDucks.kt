package headfirst.adapterpattern.commandline

import headfirst.adapterpattern.common.DemoRunner
import headfirst.adapterpattern.common.SourceDoc
import headfirst.adapterpattern.samples.Duck
import headfirst.adapterpattern.samples.FlightDistance
import headfirst.adapterpattern.samples.Turkey

internal object ExerciseDucks : DemoRunner<ExerciseDucks>(
    demoCommand = "exercise-ducks",
    demoCommandDescription = "Exercise some ducks with some undercover Turkeys in the mix",
    demoSourceDocs = setOf(
        SourceDoc.of<Duck>(
            "Test driver", "DuckTestDrive.kt"
        ),
        SourceDoc.of<Duck>(
            "Duck interfaces as well as the concrete MallardDuck class"
        ),
        SourceDoc.of<FlightDistance>(
            "Flight distance measurement value class (ADT)"
        ),
        SourceDoc.of<Turkey>(
            "Turkey interface and concrete turkey"
        ),
        SourceDoc.of<Duck>(
            "Various adapters as suggested by the exercises",
            "Adapters.kt"
        )
    ),
) {
    override fun runDemo() = headfirst.adapterpattern.samples.main()
}