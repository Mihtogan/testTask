
abstract class Being() {

    protected var attack = (1..30).random()
    protected var protection = (1..30).random()
    protected var max_XP: Int = (50..100).random()
    protected var damageMin: Int = 1
    protected var damageMax: Int = 6
    protected var xp = max_XP

    constructor(
        _attack: Int,
        _protection: Int,
        _max_XP: Int,
        _damageMin: Int,
        _damageMax: Int,
    ) : this() {
        attack = when (_attack) {
            !in 1..30 -> if (_attack < 1) 1 else 30
            else -> _attack
        }
        protection = when (_protection) {
            !in 1..30 -> if (_protection < 1) 1 else 30
            else -> _protection
        }
        max_XP = _max_XP
        xp = _max_XP
        damageMax = _damageMax
        damageMin = if (_damageMin in 1 until _damageMax) _damageMin else 1
    }

    fun getXP(): Int = xp
    fun getMaxXP(): Int = max_XP
    fun get_Attack(): Int = attack
    fun get_Protection(): Int = protection
    fun getDamage(): Int = if (xp > 0) (damageMin..damageMax).random() else 0
    fun setDamage(damage: Int):Boolean {
        if (damage !in 1..100) return false
        xp -= damage
        if (xp < 0) xp = 0
        return true
    }

}