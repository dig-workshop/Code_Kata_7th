import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import kotlin.test.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GameTest {

    @Test
    fun rockVersusScissorsResultsInPlayer1Win() {
        val result = Game().play(Throw.ROCK, Throw.SCISSORS)
        assertEquals(GameResult.P1_WINS, result)
    }

    //上のテストと同様
    @Nested
    inner class WinP1 {

        @Test
        fun `P1_ROCK VS P2_SCISSORS Win_P1`() {
            val result = Game().play(Throw.ROCK, Throw.SCISSORS)
            assertEquals(GameResult.P1_WINS, result)
        }

        @Test
        fun `P1_SCISSORS VS P2_PAPER Win_P1`() {
            val result = Game().play(Throw.SCISSORS, Throw.PAPER)
            assertEquals(GameResult.P1_WINS, result)
        }

        @Test
        fun `P1_PAPER VS P2_ROCK Win_P1`() {
            val result = Game().play(Throw.PAPER, Throw.ROCK)
            assertEquals(GameResult.P1_WINS, result)
        }
    }

    @Nested
    inner class WinP2 {

        @Test
        fun `P1_ROCK VS P2_PAPER Win_P2`() {
            val result = Game().play(Throw.ROCK, Throw.PAPER)
            assertEquals(GameResult.P2_WINS, result)
        }

        @Test
        fun `P1_SCISSORS VS P2_ROCK Win_P2`() {
            val result = Game().play(Throw.SCISSORS, Throw.ROCK)
            assertEquals(GameResult.P2_WINS, result)
        }

        @Test
        fun `P1_PAPER VS P2_SCISSORS Win_P2`() {
            val result = Game().play(Throw.PAPER, Throw.SCISSORS)
            assertEquals(GameResult.P2_WINS, result)
        }
    }

    @Nested
    inner class TieCases {
        @ParameterizedTest
        @CsvSource(
            "ROCK, ROCK, TIE",
            "SCISSORS, SCISSORS, TIE",
            "PAPER, PAPER, TIE",
        )
        fun `Tie cases test ver1`(p1Throw: String, p2Throw: String, expected: String) {
            val result = Game().play(Throw.valueOf(p1Throw), Throw.valueOf(p2Throw))
            assertEquals(GameResult.TIE, result)
        }

        @ParameterizedTest
        @ValueSource(strings = ["ROCK", "SCISSORS", "PAPER"])
        fun `Tie cases test ver2`(throwType: String) {
            val result = Game().play(Throw.valueOf(throwType), Throw.valueOf(throwType))
            assertEquals(GameResult.TIE, result)
        }
    }

}


