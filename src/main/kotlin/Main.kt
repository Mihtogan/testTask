fun main() {

    println("начало")
    val dice6 = Dice(6)
    val minimumForSuccess: Int = 5

    val monsters = listOf(Monster(), Monster())
    val player = Player(15, 10, 100, 2, 4)

    var monsterCounter = monsters.size
    while (player.getXP() > 0 && monsterCounter > 0) {
        monsters.forEach {
            if (player.getXP() > 0 && it.getXP() > 0) {
                println("игрок напал на монстра")
                battle(player, it, dice6, minimumForSuccess)
                println("у монстра осталось ${it.getXP()}/${it.getMaxXP()} XP")

                if (it.getXP() > 0) {
                    println("монстр напал на игрока")
                    battle(it, player, dice6, minimumForSuccess)
                    println("у игрока осталось ${player.getXP()}XP")
                } else monsterCounter--

                println("")
            }
        }

        if (player.getXP() < player.getMaxXP() / 2)
            if (player.healing())
                println("у игрока осталось ${player.getXP()}XP")

    }

    println("конец")
    if (player.getXP() > 0)
        println("победил игрок")
    else println("победили монстры")
}

private fun battle(striker: Being, purpose: Being, dice: Dice, minimumForSuccess: Int) {

    val attackModifier = (striker.get_Attack() - purpose.get_Protection() + 1)
    val numberOfDiceRolls = if (attackModifier > 0) attackModifier else 1

    for (i in 0..<numberOfDiceRolls)
        if (dice.rollDice() >= minimumForSuccess) {
            purpose.setDamage(striker.getDamage())
            return
        }
}
