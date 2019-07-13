package logic;

public class Upgrade extends Ongoing {

	private int cost;
	
	public Upgrade(String name, int cost, Upgrade prerequisite, int dailyExpense, float dailyCO2, int dailyActionPoints) {
		super(name, prerequisite, dailyExpense, dailyCO2, dailyActionPoints);
		this.cost = cost;
	}
	
	public Upgrade(String name, int cost, Upgrade prerequisite, int dailyExpense, float dailyCO2, int dailyActionPoints, String fact) {
		super(name, prerequisite, dailyExpense, dailyCO2, dailyActionPoints, fact);
		this.cost = cost;
	}
	
	@Override
	public boolean ApplyEffects(Game gameManager) {
		if (gameManager.getMoney() < cost) {
			return false;
		}
		if (!super.ApplyEffects(gameManager)) return false;
		gameManager.changeMoney(-cost);
		cost *= 1.3;
		return true;
	}
}
