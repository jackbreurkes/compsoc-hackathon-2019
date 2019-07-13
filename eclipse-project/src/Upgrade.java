
public class Upgrade extends Ongoing {

	private int cost;
	
	public Upgrade(int cost, Upgrade prerequisite, int dailyExpense, int dailyCO2, int dailyActionPoints, Game gameManager) {
		super(prerequisite, dailyExpense, dailyCO2, dailyActionPoints, gameManager);
		this.cost = cost;
	}
	
	public Upgrade(int cost, Upgrade prerequisite, int dailyExpense, int dailyCO2, int dailyActionPoints, Game gameManager, String fact) {
		super(prerequisite, dailyExpense, dailyCO2, dailyActionPoints, gameManager, fact);
		this.cost = cost;
	}
	
	@Override
	public void ApplyEffects() {
		
	}
}
