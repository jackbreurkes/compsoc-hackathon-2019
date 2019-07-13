package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Game;
import logic.Ongoing;
import logic.Upgrade;

class OngoingTest {
	
	@Test
	void testOngoing() {
		Game game = new Game();
		Ongoing ongoing = new Ongoing("", null, 10, 10, 10);
		ongoing.ApplyEffects(game);
		
		assertEquals(10, game.getDailyExpenses());
		assertEquals(10, game.getDailyCO2());
		assertEquals(10, game.getDailyActionPoints());
		assertTrue(game.getOngoingActions().contains(ongoing));
	}
	
	@Test
	void testPrerequisite() {
		Game game = new Game();
		
		Upgrade upgrade = new Upgrade("", 10, null, 10, 10, 10);
		Ongoing ongoing = new Ongoing("", upgrade, 10, 10, 10);

		ongoing.ApplyEffects(game);
		assertFalse(game.getOngoingActions().contains(ongoing));
		
		upgrade.ApplyEffects(game);
		ongoing.ApplyEffects(game);
		assertTrue(game.getOngoingActions().contains(upgrade));
		assertTrue(game.getOngoingActions().contains(ongoing));
	}

}
