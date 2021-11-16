import EntityUtils.Companion.Health
import EntityUtils.Companion.Level
import EntityUtils.Companion.Bases

//TODO Implement Base as an Object
// - Short Desc, base will contain information for how to create Entity attributes
class Entity(name: String, base: Bases) {
    private var name: String? = null
    //TODO Implement Level as an Object
    // - Short Desc, Level will contain a storage location alongside methods for leveling up
    // -- an entity, along with the logic to store and calculate the exp needed to level up
    private val level : Level = Level()
    //TODO Implement Health as an Object
    // - Short Desc, Health will contain information for how the Entity is doing health and
    // -- status effect wise, along with whether the entity is dead or not
    private val health : Health = Health(base, level)

    init {
        this.name = name
    }
}