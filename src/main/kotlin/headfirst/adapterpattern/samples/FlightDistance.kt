package headfirst.adapterpattern.samples

@JvmInline
value class FlightDistance(private val value: UInt) : Comparable<FlightDistance> {
    override fun compareTo(other: FlightDistance): Int = value.compareTo(other.value)
    override fun toString(): String = "$value"
    operator fun div(another: FlightDistance): FlightDistance = FlightDistance(value / another.value)
    operator fun times(another: FlightDistance): FlightDistance = FlightDistance(value * another.value)
    operator fun plus(another: FlightDistance): FlightDistance = FlightDistance(value + another.value)

}