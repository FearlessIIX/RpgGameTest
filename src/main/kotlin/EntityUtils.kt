class EntityUtils {
    companion object {
        class Health(base : Bases, level : Level) {
            var health: Int? = null
            var maxHealth : Int? = null
            var dead: Boolean = false
            //TODO implement StatusEffect Object
            // - Short Desc, StatusEffect will store the means to create statuses with custom tick values
            // -- that can be stored in a common list, this will allow for the Entity to be under multiple
            // -- status effects without losing track of any of them
            init {
                this.maxHealth = calcMaxHealth(base, level)
                this.health = this.maxHealth
            }

            private fun calcMaxHealth(base : Bases, level : Level) : Int {
                return 1
            }

            fun takeDamage(damage : Int) : Boolean {
                this.health = this.health!! - damage
                if (this.health!! <= 0) {
                    this.health = 0; this.dead = true
                }
                return this.dead
            }
            fun gainHealth(gain: Int) {
                //TODO some status effects in the future may effect effectiveness
                this.health = this.health!! + gain
                if (this.health!! >= this.maxHealth!!)
                    this.health = this.maxHealth
            }
        }
        class Level() {
            private var level : Int? = null
            private var xp : Int? = null
            private var xpMax : Int? = null
            init {

            }
            // Getters ----
            fun getLevel() : Int {
                return this.level!!
            }
            fun getXp() : Int {
                return this.xp!!
            }
            fun getMaxXp() : Int {
                return this.xpMax!!
            }
            // ----
            fun gainExp(gainAmt: Int) {
                this.xp = this.xp!! + gainAmt
                if (this.xp!! > this.xpMax!!) {
                    levelUp()
                }
            }

            private fun levelUp() {
                this.xp = this.xpMax!! - this.xp!!
            }
        }
        //To be used with Non-Player affiliated Entities
        enum class Bases {
            Wizard {
                override fun health(): Int { return 20 }
                override fun healthStep(): Int { return 0 }
                override fun defense(): Int { return 15 }
                override fun defenseStep(): Int { return 1 }
                override fun speed(): Int { TODO("Not yet implemented") }
                override fun speedStep(): Int { TODO("Not yet implemented") }
                override fun magicka(): Int { TODO("Not yet implemented") }
                override fun magickaStep(): Int { TODO("Not yet implemented") }
                override fun damageModifier(): Int { TODO("Not yet implemented") }
                override fun favoriteWeaponType(): String { TODO("Not yet implemented") }
            },
            Barbarian {
                override fun health(): Int { return 20 }
                override fun healthStep(): Int { return 2 }
                override fun defense(): Int { return 17 }
                override fun defenseStep(): Int { return 2 }
                override fun speed(): Int { return 8 }
                override fun speedStep(): Int { return 0 }
                override fun magicka(): Int { return 0 }
                override fun magickaStep(): Int { return 0 }
                override fun damageModifier(): Int { TODO("Not yet implemented") }
                override fun favoriteWeaponType(): String { return "melee" }
            },
            Archer {
                override fun health(): Int { return 20 }
                override fun healthStep(): Int { return 0 }
                override fun defense(): Int { return 12 }
                override fun defenseStep(): Int { return 0 }
                override fun speed(): Int { TODO("Not yet implemented") }
                override fun speedStep(): Int { TODO("Not yet implemented") }
                override fun magicka(): Int { TODO("Not yet implemented") }
                override fun magickaStep(): Int { TODO("Not yet implemented") }
                override fun damageModifier(): Int { TODO("Not yet implemented") }
                override fun favoriteWeaponType(): String { return "bow" }
            },
            Rogue {

                override fun health(): Int { return 20 }
                override fun healthStep(): Int { return 1 }
                override fun defense(): Int { return 12 }
                override fun defenseStep(): Int { return 1 }
                override fun speed(): Int { return 15 }
                override fun speedStep(): Int { return 2 }
                override fun magicka(): Int { return 0 }
                override fun magickaStep(): Int { return 0 }
                override fun damageModifier(): Int { TODO("Not yet implemented") }
                override fun favoriteWeaponType(): String { return "melee,bow" }
            };
            abstract fun health() : Int
            abstract fun healthStep() : Int
            abstract fun defense() : Int
            abstract fun defenseStep() : Int
            abstract fun speed() : Int
            abstract fun speedStep() : Int
            abstract fun magicka() : Int
            abstract fun magickaStep() : Int
            abstract fun damageModifier() : Int
            abstract fun favoriteWeaponType() : String
        }
    }
}