package itec220.cookieClicker;

public enum BuildingType {
	CURSOR("Cursor", 15, 0.1),
	GRANDMA("Grandma", 100, 1),
	FARM("Farm", 1100, 8),
	MINE("Mine", 12_000, 47),
	FACTORY("Factory", 130_000, 260),
	BANK("Bank", 1_400_000, 1400),
	TEMPLE("Temple", 20_000_000, 7800),
	WIZARD_TOWER("Wizard Tower", 330_000_000, 44_000),
	SHIPMENT("Shipment", 5_100_000_000.0, 260_000),
	ALCHEMY_LAB("Alchemy Lab", 75_000_000_000.0, 1_600_000),
	PORTAL("Portal", 1_000_000_000_000.0, 10_000_000),
	TIME_MACHINE("Time Machine", 14_000_000_000_000.0, 65_000_000),
	ANTIMATTER_CONDENSER("Antimatter Condenser", 170_000_000_000_000.0, 430_000_000);
	
	private String name;
	private double baseCost;
	private double baseCPS;
	
	
	BuildingType(String name, double baseCost, double baseCPS){
		this.name = name;
		this.baseCost = baseCost;
		this.baseCPS = baseCPS;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getBaseCost() {
		return this.baseCost;
	}
	
	public double getBaseCPS() {
		return this.baseCPS;
	}
	
	@Override
	public String toString() {
		return String.format("{%s, Base Cost: %f, CPS: %f}\n", this.name, this.baseCost, this.baseCPS);
	}
}
