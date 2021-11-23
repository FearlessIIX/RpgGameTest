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
    player.takeDamage(15)
    println("\nAfter losing 15 health\n")
    println(player)
    player.gainHealth(53)
    println("\nAfter gaining 53 health\n")
    println(player)
}
