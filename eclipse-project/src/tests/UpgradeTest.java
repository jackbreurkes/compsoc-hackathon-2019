package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Game;
import logic.Upgrade;

class UpgradeTest {

	@Test
	void testUpgrade() {
		Game game = new Game();
		Upgrade upgrade = new Upgrade(10, null, 10, 10, 10);
		
		game.setMoney(100);
		upgrade.ApplyEffects(game);
		assertEquals(90, game.getMoney());
	}
	
	@Test
	void testPrerequisite() {
		Game game = new Game();
		Upgrade upgrade1 = new Upgrade(10, null, 10, 10, 10);
		Upgrade upgrade2 = new Upgrade(10, upgrade1, 10, 10, 10);
		
		game.setMoney(100);
		upgrade2.ApplyEffects(game);
		assertEquals(100, game.getMoney());
		
		upgrade1.ApplyEffects(game);
		upgrade2.ApplyEffects(game);
		assertEquals(80, game.getMoney());
		assertTrue(game.getOngoingActions().contains(upgrade1));
		assertTrue(game.getOngoingActions().contains(upgrade2));
	}

}
