package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.Choice;
import logic.Game;
import logic.Ongoing;
import logic.Upgrade;

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
	
	@Test
	void testChoices() {
		Game game = new Game(30, 40, 5);
		
		Ongoing meatEating = new Ongoing("", null, 10, 10, 10, "meat eating");
		Upgrade vegeGarden = new Upgrade("", 100, null, 0, 0, 0, "vege garden");
		Ongoing vegetarian = new Ongoing("", vegeGarden, 0, 0, 0, "vegetarianism");
		Choice diet = new Choice(meatEating, vegetarian);
		
		diet.setOption(game, vegetarian);
		assertEquals(meatEating, diet.getCurrentOption());
		vegeGarden.ApplyEffects(game);
		diet.setOption(game, vegetarian);
		assertEquals(vegetarian, diet.getCurrentOption());
	}

}
