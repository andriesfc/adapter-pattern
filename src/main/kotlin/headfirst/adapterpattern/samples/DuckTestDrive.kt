package headfirst.adapterpattern.samples

fun main() {

    fun testDuck(duck: Duck) {
        duck.apply {
            quack()
            fly()
        }
    }

    fun testTurkey(turkey: Turkey) {
        turkey.apply {
            gobble()
            fly()
        }
    }

    val duck = MallardDuck()
    val turkey = WildTurkey()
    val turkeyAsDuck : Duck = TurkeyAdapter(turkey)

    println("The turkey says...")
    testTurkey(turkey)
    println()

    println("The duck says....")
    testDuck(duck)
    println()

    println("The turkey which looks like a duck says...")
    testDuck(turkeyAsDuck)
    println()

    println("A duck which look like turkey")
    testTurkey(DuckAdapter(duck))
}

