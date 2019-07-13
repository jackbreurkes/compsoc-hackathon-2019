package logic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import gui.MainScreen;

public class Game extends TimerTask {
	
	public final int DAILY_EARNINGS = 130;

	int totalAP;
	int totalCO2;
	int totalMoney;
	int dailyExpenses;
	int dailyCO2;
	int dailyAP;
	ArrayList<Ongoing> onGoingActions = new ArrayList<Ongoing>();
	List<Choice> choices = new ArrayList<Choice>();
	List<Upgrade> upgrades = new ArrayList<Upgrade>();
	Map<String, Integer> upgradeCounters = new HashMap<String, Integer>();

	
	public Game() { }

	public Game(int initialExpenses, int initialDailyCO2, int initialDailyAP) {
		dailyExpenses = initialExpenses;
		dailyCO2 = initialDailyCO2;
		dailyAP = initialDailyAP;
	}
	
	/* create GUI */
	
	public void launchMainScreen() {
		MainScreen mainWindow = new MainScreen(this);
	}
	
	/* Setters */
	public void setActionPoints(int actionPoints) {
		this.totalAP = actionPoints;
	}
	
	public void setCarbonFootPrint(int carbonFootPrint) {
		this.totalCO2 = carbonFootPrint;
	}
	
	public void changeDailyExpenses(int change) {
		this.dailyExpenses += change;
	}
	
	public void setMoney(int money) {
		this.totalMoney = money;
	}
	
	public void changeDailyCO2(int change) {
		this.dailyCO2 += change;
	}
	
	public void changeDailyActionPoints(int change) {
		this.dailyAP += change;
	}
	
	public void changeCO2(int change) {
		totalCO2 += change;
	}
	
	public void changeAP(int change) {
		totalAP += change;
	}
	
	public void changeMoney(int money) {
		this.totalMoney += money;
	}
	
	/* getters */
	public int getActionPoints() {
		return totalAP;
	}
	
	public int getCarbonFootPrint() {
		return totalCO2;
	}
	
	public int getDailyExpenses() {
		return dailyExpenses;
	}
	
	public int getMoney() {
		return totalMoney;
	}
	
	public int getDailyCO2() {
		return dailyCO2;
	}
	
	public int getDailyActionPoints() {
		return dailyAP;
	}
	
	public List<Upgrade> getUpgrades() {
		return upgrades;
	}
	
	public Map<String, Integer> getUpgradeCounts() {
		return upgradeCounters;
	}
	
	public void run() {
		totalMoney += DAILY_EARNINGS - dailyExpenses;
		totalCO2 += dailyCO2;
		totalAP += dailyAP;
		System.out.println(toString());
	}
	
	public void addOngoingAction(Ongoing action) {
		onGoingActions.add(action);
	}
	
	public void removeOngoingAction(Ongoing action) {
		onGoingActions.remove(action);
	}
	
	public List<Ongoing> getOngoingActions() {
		return onGoingActions;
	}
	
	@Override
	public String toString() {
		String output = "daily income: 130 - " + getDailyExpenses() + " daily CO2: " + getDailyCO2() + " daily AP: " + getDailyActionPoints();
		output += "\ntotal money:  " + getMoney() + "        total CO2: " + getCarbonFootPrint() + "  total AP: " + getActionPoints();
		output += "\n";
		return output;
	}
	
	

	public static void main(String[] args) {
		Game game = new Game();
//		Timer timer = new Timer();
//		timer.schedule(game, 0, 1000);
		
		Ongoing meatEating = new Ongoing("Meat Eating", null, 0, 0, 0, "meat eating");
		Upgrade vegeGarden = new Upgrade("Vege Garden", 1000, null, 0, -10, 0, "vege garden");
		Ongoing vegetarian = new Ongoing("Vegetarianism", vegeGarden, 0, 0, 0, "vegetarianism");
		Choice diet = new Choice(meatEating, vegetarian);
		
		game.getUpgrades().add(vegeGarden);
		
		for (int i = 0; i < game.getUpgrades().size(); i++) {
			game.getUpgradeCounts().put(game.getUpgrades().get(i).getName(), 0);
		}
		
		game.launchMainScreen();
		
//		diet.setOption(game, vegetarian);
	}
}
