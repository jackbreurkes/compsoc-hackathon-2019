package logic;

public class Upgrade extends Ongoing {

	private int cost;
	
	public Upgrade(int cost, Upgrade prerequisite, int dailyExpense, int dailyCO2, int dailyActionPoints) {
		super(prerequisite, dailyExpense, dailyCO2, dailyActionPoints);
		this.cost = cost;
	}
	
	public Upgrade(int cost, Upgrade prerequisite, int dailyExpense, int dailyCO2, int dailyActionPoints, String fact) {
		super(prerequisite, dailyExpense, dailyCO2, dailyActionPoints, fact);
		this.cost = cost;
	}
	
	@Override
	public boolean ApplyEffects(Game gameManager) {
		if (!super.ApplyEffects(gameManager)) return false;
		
		if (gameManager.getMoney() < cost) {
			return false;
		}
		gameManager.changeMoney(-cost);
		return true;
	}
}
