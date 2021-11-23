import EntityUtils.Companion.Health
import EntityUtils.Companion.Level
import EntityUtils.Companion.Bases

class Entity(name: String, private val base: Bases) {
    private var name: String? = null
    private val level : Level = Level()
    private val health : Health = Health(base)

    init {
        this.name = name
    }
    //Health functions---->
    fun takeDamage(damageAmt: Int) {
        if (health.takeDamage(damageAmt)) {
            //Player has died!!
        }
    }
    fun gainHealth(gainAmt: Int) {
        health.gainHealth(gainAmt)
    }
    private fun calcMaxHealth(base: Bases) {
        health.calcMaxHealth(base)
    }
        // Getters ---->
        fun getHealth() : Int {return health.getHealth()}
        fun isDead() : Boolean {return health.isDead()}
        fun getMaxHealth() : Int {return health.getMaxHealth()}
        // ---->
    //---->
    //Level functions---->
    fun gainXp(gainAmt: Int) {
        for (i in 0..level.gainExp(gainAmt)) calcMaxHealth(base)
    }
        // Getters ---->
            fun getLevel() : Int {return level.getLevel()}
            fun getXp() : Int {return level.getXp()}
            fun getMaxXp() : Int {return level.getMaxXp()}
        // ---->
    // ---->
    override fun toString(): String {
        return "${this.name}\nlevel: ${getLevel()}\nExp: ${getXp()} - ${getMaxXp()}\n" +
                "health: ${getHealth()} of ${getMaxHealth()}"
    }
}