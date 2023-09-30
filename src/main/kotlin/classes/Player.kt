
class Player(
    attack: Int,
    protection: Int,
    max_XP: Int,
    damageMin: Int,
    damageMax: Int,
) : Being(
    _attack = attack,
    _protection = protection,
    _max_XP = max_XP,
    _damageMin = damageMin,
    _damageMax = damageMax,
) {
    private var numberHeal: Int = 4

    fun healing():Boolean {
        if (xp <= 0 || numberHeal <= 0) return false

        xp += max_XP * 3 / 10
        if (xp > max_XP) xp = max_XP
        numberHeal--
        return true
    }
}