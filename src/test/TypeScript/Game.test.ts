import {Game} from "../../main/TypeScript/Game";
import {Throw} from "../../main/TypeScript/Throw";
import {GameResult} from "../../main/TypeScript/GameResult";
import {describe, expect, it} from "vitest";

describe('test', () => {
    it("player1がグー(ROCK)でplayer2がチョキ(SCISSORS)のときplayer1が勝つ", () => {
        const player1 = Throw.ROCK
        const player2 = Throw.SCISSORS
        const game = new Game()
        const result = game.play(player1, player2)

        expect(result).toEqual(GameResult.P1_WINS)
    })
});
