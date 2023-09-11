package headfirst.adapterpattern.samples

interface Duck  {
    fun quack()
    fun fly()

    companion object {
        val AverageDuckFlightDistance = FlightDistance(10u)
    }

}

class MallardDuck : Duck {

    override fun quack() {
        println("${javaClass.simpleName}: Quack")
    }

    override fun fly() {
        println("${javaClass.simpleName}: I'm flying ${Duck.AverageDuckFlightDistance}")
    }
}

