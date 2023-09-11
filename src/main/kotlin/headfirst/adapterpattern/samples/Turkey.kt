package headfirst.adapterpattern.samples

interface Turkey {
    fun gobble()
    fun fly()

    companion object {
        val AverageTurkeyFlightDistance = FlightDistance(3u)
    }
}

class WildTurkey : Turkey {

    override fun gobble() {
        println("${javaClass.simpleName}: Gobble gobble")
    }

    override fun fly() {
        println("${javaClass.simpleName}: I'm flying short distance of ${Turkey.AverageTurkeyFlightDistance}")
    }

}