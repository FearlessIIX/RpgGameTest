import EntityUtils.Companion.Bases

fun main(args: Array<String>) {
    val player = Entity("Katsuro", Bases.Base)
    println(player)
    player.gainXp(14)
    println("\nAfter gaining 14 xp\n")
    println(player)
    player.gainXp(14235)
    println("\nAfter gaining 14235 xp\n")
    println(player)
}
