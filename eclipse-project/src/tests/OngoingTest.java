package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Game;
import logic.Ongoing;

class OngoingTest {
	
	private Game game;

	@Test
	void beforeEach() {
		game = new Game();
	}
	
	@Test
	void testOngoing() {
		Ongoing ongoing = new Ongoing(null, 10, 10, 10, game);
		//System.out.println(game.toString());
	}

}
