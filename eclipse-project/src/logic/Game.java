package logic;

import java.util.ArrayList;
import gui.MainScreen;

public class Game {
	
	private int actionPoints;
	private int carbonFootPrint;
	private int money;
	private int dailyExpenses;
	private int income;
	//ArrayList<Ongoing> onGoingActions = new ArrayList<OnGoing>();
	//ArrayList<Buyable> inventory = new ArrayList<Buyable>();
	

	public static void main(String[] args) {
		Game game = new Game();
		game.launchMainScreen();
		System.out.println("Working");
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
	
	public void setDailyExpenses(int dailyExpenses) {
		this.dailyExpenses = dailyExpenses;
	}
	
	public void setIncome(int income) {
		this.income = income;
	}
	
	public void setMoney(int money) {
		this.money = money;
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
	
}
