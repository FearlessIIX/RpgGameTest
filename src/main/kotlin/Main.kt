fun main(args: Array<String>) {
    var xp  : Int = 25
    var rate : Double = 0.75

    for (i in 1..100) {
        rate = when (i) {
            in 5..10 -> 0.50
            in 10..15 -> 0.35
            in 15..24 -> 0.25
            in 24..49 -> 0.185
            in 50..59 -> 0.15
            in 60..74 -> 0.075
            in 75..101 -> 0.010
            else -> rate
        }

        xp += (xp * rate).toInt()
        println("level $i: $xp")
    }
}
