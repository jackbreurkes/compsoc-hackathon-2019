
public class Ongoing {
	private Upgrade prerequisite;
	private int dailyExpense;
	private int dailyCO2;
	private int dailyActionPoints;
	private Game gameManager;
	private String fact = "";
	
	public Ongoing(Upgrade prerequisite, int dailyExpense, int dailyCO2, int dailyActionPoints, Game gameManager) {
		this.prerequisite = prerequisite;
		this.dailyExpense = dailyExpense;
		this.dailyCO2 = dailyCO2;
		this.dailyActionPoints = dailyActionPoints;
		this.gameManager = gameManager;
	}
	
	public Ongoing(Upgrade prerequisite, int dailyExpense, int dailyCO2, int dailyActionPoints, Game gameManager, String fact) {
		this(prerequisite, dailyExpense, dailyCO2, dailyActionPoints, gameManager);
		this.fact = fact;
	}
	
	public void ApplyEffects() {
		
	}
	
	public void RemoveEffects() {
		
	}
}
