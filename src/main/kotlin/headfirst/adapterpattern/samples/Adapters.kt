package headfirst.adapterpattern.samples

class TurkeyAdapter(private val turkey: Turkey) : Duck {
    override fun quack() = turkey.gobble()

    override fun fly() {
        var turkeyDistance = Turkey.AverageTurkeyFlightDistance
        var hops = 0
        do {
            hops += 1
            println("${turkey.javaClass.simpleName}: Taking short flight number $hops")
            turkey.fly()
            turkeyDistance += turkeyDistance
        } while (turkeyDistance < Duck.AverageDuckFlightDistance)
    }
}

class DuckAdapter(private val duck: Duck) : Turkey {
    override fun gobble() = duck.quack()

    override fun fly() {
        duck.fly()
    }

}