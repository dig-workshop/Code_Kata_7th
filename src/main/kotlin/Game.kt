class Game {
    fun play(p1:Throw, p2:Throw):GameResult {
        return if (p1 == p2) {
            GameResult.TIE
        } else if (p1 == Throw.ROCK && p2 == Throw.SCISSORS) {
            GameResult.P1_WINS
        } else if (p1 == Throw.SCISSORS && p2 == Throw.PAPER) {
            GameResult.P1_WINS
        } else if (p1 == Throw.PAPER && p2 == Throw.ROCK) {
            GameResult.P1_WINS
        } else {
            GameResult.P2_WINS
        }
    }
}