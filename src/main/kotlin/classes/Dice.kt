
class Dice(private val numberFaces: Int) {
    fun rollDice(): Int {
        return (0..numberFaces).random()
    }
}