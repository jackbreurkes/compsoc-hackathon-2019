package logic;

public class Booster {

	private String name = "Booster";
	private int cost;
	private int actionPointCost;
	private float CO2Change;
	private int APChange;
	private String fact;
	
	public Booster(String name, int cost, int actionPointCost, float CO2Change, int APChange) {
		this.name = name;
		this.cost = cost;
		this.actionPointCost = actionPointCost;
		this.CO2Change = CO2Change;
		this.APChange = APChange;
	}
	
	public Booster(String name, int cost, int actionPointCost, float CO2Change, int APChange, String fact) {
		this(name, cost, actionPointCost, CO2Change, APChange);
		this.fact = fact;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFact() {
		return fact;
	}
	
	public int getCost() {
		return cost;
	}
	
	public int getAPCost() {
		return actionPointCost;
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
