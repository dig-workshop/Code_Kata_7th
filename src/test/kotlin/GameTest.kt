import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GameTest {

    @Test
    fun rockVersusScissorsResultsInPlayer1Win() {
        val result = Game().play(Throw.ROCK, Throw.SCISSORS)
        assertEquals(GameResult.P1_WINS, result)
    }
}


