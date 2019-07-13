package logic;

public class Booster {

	private int cost;
	private int actionPointCost;
	private int CO2Change;
	private int APChange;
	
	public Booster(int cost, int actionPointCost, int CO2Change, int APChange) {
		this.cost = cost;
		this.actionPointCost = actionPointCost;
		this.CO2Change = CO2Change;
		this.APChange = APChange;
	}
	
	public void applyEffects(Game game) {
		if (game.getMoney() < cost || game.getActionPoints() < actionPointCost) {
			return;
		}
		
		game.changeMoney(-cost);
		game.changeAP(-actionPointCost);
		game.changeCO2(CO2Change);
		game.changeAP(APChange);
	}
	
}
