package itec220.cookieClicker;

import java.util.HashMap;

//this will be the model layer
public class Game {
	private double cookies;
	private double totalCookiesMade;
	
	private HashMap<BuildingType, Integer> buildingInventory;
	
	
	public Game() {
		buildingInventory = new HashMap<>();
		
		for(BuildingType type : BuildingType.values()) {
			buildingInventory.put(type, 0);
		}
	}
	
	public void calculateCookiesGenerated() {
		for(BuildingType type : BuildingType.values()) {
			this.cookies += (type.getBaseCPS() * buildingInventory.get(type)) / 30.0;
		}
	}
	
	public boolean canBuy(BuildingType type, int buyAmount) {
		return (this.cookies >= calculateNextPrice(type, buyAmount));
	}
	
	public double calculateNextPrice(BuildingType type, int amount) {
		/*
		 * Price of building number N
		 * 	
		 * 		Price = BaseCost * 1.15 ^ M 
		 * 
		 * where M is the number of building of that type already owned
		 * 
		 * Price of buying B number of buildings with A number already owned
		 * 
		 * 		Sigma(start = b = a + 1, end = b, (BaseCost * 1.15^b) / 1.15)
		 * 
		 */
	
		double price = 0;
		
		int currentAmount = buildingInventory.get(type);
		
		for(int i = 0; i < amount; i++) {
			price += Math.ceil(type.getBaseCost() * Math.pow(1.15, currentAmount));
			currentAmount++;
		}
		
		return price;
		
	}
	
	public void update() {
		calculateCookiesGenerated();
	}
	
	
	public void clickCookie() {
		addCookies(1);
	}
	
	public void removeCookies(double amount) {
		addCookies(-amount);
	}
	
	public void addCookies(double amount) {
		this.cookies += amount;
		this.totalCookiesMade += amount;
	}
	
	public void buyBuildings(BuildingType type, int amount) {
		if(canBuy(type, amount)) {
			double price = calculateNextPrice(type, amount);
			cookies -= price;
			addBuildings(type, amount);
		}
	}
	
	private void addBuildings(BuildingType type, int amount) {
		buildingInventory.put(type, (buildingInventory.get(type) + amount));
	}
	
	
	
	public double getCookiesAmt() {
		return this.cookies;
	}
	
	public double getTotalCookiesMade() {
		return this.totalCookiesMade;
	}
	
	public int getBuildingAmt(BuildingType type) {
		return buildingInventory.get(type);
	}
}
