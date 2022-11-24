package itec220.cookieClicker;

import java.util.HashMap;

//this will be the model layer
public class Game {
	private double cookies;
	private double totalCookiesMade;
	
	private HashMap<BuildingType, Integer> buildingInventory;
	
	
	public void calculateCookiesGenerated() {
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
		/*
		 * Price of building number N
		 * 	
		 * 		Price = BaseCost * 1.15^M
		 * 
		 * where M is the number of building of that type already owned
		 * 
		 * Price of buying B number of buildings with A number already owned
		 * 
		 * 		Sigma(start = b = a + 1, end = b, (BaseCost * 1.15^b) / 1.15)
		 * 
		 */
		
		
		
	}
	
	private void addBuilding(BuildingType type) {
		buildingInventory.put(type, (buildingInventory.get(type) + 1));
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
