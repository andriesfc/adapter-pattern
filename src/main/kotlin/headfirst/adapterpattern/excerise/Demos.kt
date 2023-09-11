package headfirst.adapterpattern.excerise

import java.util.*


private val componentNames = listOf("X", "Y", "Z")

fun demoUseOfVector(x: Double, y: Double, z: Double) {

    val vector = Vector<Double>().apply { add(x); add(y); add(z) }

    println(
        "Got vector of: ${
            vector.withIndex().joinToString { (index, v) -> "${componentNames[index]}: $v" }
        }\n"
    )

    println("Doing a for each loop using adapter with parts:")

    EnumerationIterator(vector.elements()).withIndex().forEach { (index, value) ->
        println("${componentNames[index]} := $value")
    }
}
