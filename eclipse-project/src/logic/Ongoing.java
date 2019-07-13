package logic;


public class Ongoing {
	private String name;
	private Upgrade prerequisite;
	private int dailyExpense;
	private float dailyCO2;
	private int dailyActionPoints;
	private String fact = "";
	
	public Ongoing(String name, Upgrade prerequisite, int dailyExpense, float dailyCO2, int dailyActionPoints) {
		this.name = name;
		this.prerequisite = prerequisite;
		this.dailyExpense = dailyExpense;
		this.dailyCO2 = dailyCO2;
		this.dailyActionPoints = dailyActionPoints;
	}
	
	public Ongoing(String name, Upgrade prerequisite, int dailyExpense, float dailyCO2, int dailyActionPoints, String fact) {
		this(name, prerequisite, dailyExpense, dailyCO2, dailyActionPoints);
		this.fact = fact;
	}
	
	public Upgrade getPrerequisite() {
		return prerequisite;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFact() {
		return fact;
	}
	
	public boolean ApplyEffects(Game gameManager) {
		if (prerequisite != null && !gameManager.getOngoingActions().contains(prerequisite)) {
			return false;
		}
		
		gameManager.changeDailyExpenses(dailyExpense);
		gameManager.changeDailyCO2(dailyCO2);
		gameManager.changeDailyActionPoints(dailyActionPoints);
		gameManager.addOngoingAction(this);
		return true;
	}
	
	public void RemoveEffects(Game gameManager) {
		gameManager.changeDailyExpenses(-dailyExpense);
		gameManager.changeDailyCO2(-dailyCO2);
		gameManager.changeDailyActionPoints(-dailyActionPoints);
		gameManager.removeOngoingAction(this);
	}
}
