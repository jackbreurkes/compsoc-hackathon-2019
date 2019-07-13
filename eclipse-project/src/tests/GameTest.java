package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Game;

class GameTest {

	@Test
	void testChanges() {
		Game game = new Game(30, 40, 5);
		
		game.changeDailyExpenses(-10);
		assertEquals(20, game.getDailyExpenses());
		game.changeDailyCO2(20);
		assertEquals(60, game.getDailyCO2());
		game.changeDailyActionPoints(5);
		assertEquals(10, game.getDailyActionPoints());
	}

}
