package logic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.List;

import gui.MainScreen;

public class Game extends TimerTask {
	
	private final int DAILY_EARNINGS = 130;
	

	int actionPoints;
	int carbonFootPrint;
	int money;
	int dailyExpenses;
	int dailyCO2;
	int dailyActionPoints;
	int income;
	ArrayList<Ongoing> onGoingActions = new ArrayList<Ongoing>();

	
	public Game() { }

	public Game(int initialExpenses, int initialDailyCO2, int initialDailyAP) {
		dailyExpenses = initialExpenses;
		dailyCO2 = initialDailyCO2;
		dailyActionPoints = initialDailyAP;
	}
	
	/* create GUI */
	
	public void launchMainScreen() {
		MainScreen mainWindow = new MainScreen(this);
	}
	
	/* Setters */
	public void setActionPoints(int actionPoints) {
		this.actionPoints = actionPoints;
	}
	
	public void setCarbonFootPrint(int carbonFootPrint) {
		this.carbonFootPrint = carbonFootPrint;
	}
	
	public void changeDailyExpenses(int change) {
		this.dailyExpenses += change;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void changeDailyCO2(int change) {
		this.dailyCO2 += change;
	}
	
	public void changeDailyActionPoints(int change) {
		this.dailyActionPoints += change;
	}
	
	public void changeCO2(int change) {
		carbonFootPrint += change;
	}
	
	public void changeAP(int change) {
		actionPoints += change;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
	
	public void changeMoney(int money) {
		this.money += money;
	}
	
	/* getters */
	public int getActionPoints() {
		return actionPoints;
	}
	
	public int getCarbonFootPrint() {
		return carbonFootPrint;
	}
	
	public int getDailyExpenses() {
		return dailyExpenses;
	}
	
	public int getIncome() {
		return income;
	}
	
	public int getMoney() {
		return money;
	}
	
	public int getDailyCO2() {
		return dailyCO2;
	}
	
	public int getDailyActionPoints() {
		return dailyActionPoints;
	}
	
	public void run() {
		money += DAILY_EARNINGS - dailyExpenses;
		carbonFootPrint += dailyCO2;
		actionPoints += dailyActionPoints;
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
		Timer timer = new Timer();
		timer.schedule(game, 0, 1000);
		game.launchMainScreen();
	}
}
