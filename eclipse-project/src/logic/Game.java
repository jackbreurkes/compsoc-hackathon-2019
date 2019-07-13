package logic;

import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import gui.MainScreen;

public class Game extends TimerTask {
	
	public final int DAILY_EARNINGS = 130;

	int totalAP;
	float totalCO2;
	int totalMoney;
	int dailyExpenses;
	float dailyCO2;
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
	
	public void setCarbonFootPrint(float carbonFootPrint) {
		this.totalCO2 = carbonFootPrint;
	}
	
	public void changeDailyExpenses(int change) {
		this.dailyExpenses += change;
	}
	
	public void setMoney(int money) {
		this.totalMoney = money;
	}
	
	public void changeDailyCO2(float change) {
		this.dailyCO2 += change;
	}
	
	public void changeDailyActionPoints(int change) {
		this.dailyAP += change;
	}
	
	public void changeCO2(float change) {
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
	
	public float getCarbonFootPrint() {
		return totalCO2;
	}
	
	public int getDailyExpenses() {
		return dailyExpenses;
	}
	
	public int getMoney() {
		return totalMoney;
	}
	
	public float getDailyCO2() {
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
	
	public List<Choice> getChoices() {
		return choices;
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
		
		game.changeDailyCO2((float) 28.9); //Powering home

		
		
		
		//upgrade
		Upgrade vegeGarden = new Upgrade("Vege Garden", 1000, null, 0, -5, 0, "By growing your own food, you are helping to reduce the high amounts of burning fossil fuels that fill our environment as a direct result of importing foods from commercial farmers!");
		Upgrade solarPanel = new Upgrade("Solar Panel", 3000, null, 0, (float) -3.6, 0, "Solar power is a clean energy, this means that it does not produce any carbon dioxide into the atmosphere!");
		Upgrade electricCar = new Upgrade("Electric Car", 30000, null, 0, (float) 0, 0, "Not only do Electric Vehicles reuce your cabron footprint, they can save you money!");
		
		
		//ongoing
		Ongoing meatEating = new Ongoing("Meat Eating", null, 0, (float) 3.65, 0, "The global average of water required to produce 1kg of beef is 15,400 litres!");
		Ongoing vegetarian = new Ongoing("Vegetarianism", vegeGarden, 0, (float) 0.01, 0, "vegetarianism");
		Ongoing driveElectricCar = new Ongoing("Electric Car", electricCar, 0, (float) 2.6, 0, "You are producing 46% less C02 by driving an electric car. If you walked or biked you would produce no C02!");
		Ongoing driveNormalCar = new Ongoing("Petrol Car", null, 0, (float) 4.14, 0, "Fosisl fuels are expected to run out in the next 54 years at this rate. You might need to start walking if you don't get an electric vehicle!");
		Ongoing lineDryer = new Ongoing("Clothes Line", null, 0, (float) 0, 0, "Drying your clothes on a line is a free way to take advantage of the suns own renuable energy");
		Ongoing dryer = new Ongoing("Dryer", null, 0, (float) 0.85, 0, "Drying your clothes on a line is a free way to take advantage of the suns own renuable energy");
		
		//choice
		Choice diet = new Choice(meatEating, vegetarian);
		Choice transport = new Choice(driveNormalCar, driveElectricCar);
		Choice dryingMethod = new Choice(dryer, lineDryer);
		
		Collections.addAll(game.getUpgrades(), vegeGarden, solarPanel, electricCar);
		
		Collections.addAll(game.getChoices(), diet, transport, dryingMethod);
		
		Collections.addAll(game.getOngoingActions(), meatEating, vegetarian, driveElectricCar, driveNormalCar);
		
		for (int i = 0; i < game.getUpgrades().size(); i++) {
			game.getUpgradeCounts().put(game.getUpgrades().get(i).getName(), 0);
		}
		
		game.launchMainScreen();
		
//		diet.setOption(game, vegetarian);
	}
}
