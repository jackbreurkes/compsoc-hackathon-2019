package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Game;
import logic.Upgrade;

class UpgradeTest {

	@Test
	void testUpgrade() {
		Game game = new Game();
		Upgrade upgrade = new Upgrade(10, null, 10, 10, 10, game);
		
		game.setMoney(100);
		upgrade.ApplyEffects();
		assertEquals(90, game.getMoney());
	}
	
	@Test
	void testPrerequisite() {
		Game game = new Game();
		Upgrade upgrade1 = new Upgrade(10, null, 10, 10, 10, game);
		Upgrade upgrade2 = new Upgrade(10, upgrade1, 10, 10, 10, game);
		
		game.setMoney(100);
		upgrade2.ApplyEffects();
		assertEquals(100, game.getMoney());
		
		upgrade1.ApplyEffects();
		upgrade2.ApplyEffects();
		assertEquals(80, game.getMoney());
	}

}
