package itec220.cookieClicker;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.*;


public class GameController {

	private Game game;
	
	@FXML private Text cookieAmtUI;
	
	@FXML private ToggleGroup buyAmountGroup;
	
	@FXML private Button buttonBuyClicker;
	@FXML private Button buttonBuyGrandma;
	@FXML private Button buttonBuyFarm;
	@FXML private Button buttonBuyMine;
	@FXML private Button buttonBuyFactory;
	@FXML private Button buttonBuyBank;
	@FXML private Button buttonBuyTemple;
	@FXML private Button buttonBuyWizard;
	@FXML private Button buttonBuyShipment;
	@FXML private Button buttonBuyAlchemy;
	@FXML private Button buttonBuyPortal;
	@FXML private Button buttonBuyTimeMachine;
	@FXML private Button buttonBuyAntimatter;
	
	public GameController(){
		game = new Game();
	}
	
	
	public void runGame() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					game.update();
					draw(); 
				});
			}
		}, 0, 33, TimeUnit.MILLISECONDS);
	}
	
	private void draw() {
		this.cookieAmtUI.setText(String.format("%.0f cookies", this.game.getCookiesAmt()));
	}
	
	private void buyBuilding(BuildingType type) {
		int amount = (int) buyAmountGroup.getSelectedToggle().getUserData();
		
		game.buyBuildings(type, amount);
	}
	
	@FXML
	public void clickCookie() {
		game.clickCookie();
	}
	
	@FXML
	private void handleBuyClicker() {
		buyBuilding(BuildingType.CURSOR);
	}
	
	@FXML
	private void handleBuyGrandma() {		buyBuilding(BuildingType.GRANDMA);}
	
	@FXML
	private void handleBuyFarm() {		buyBuilding(BuildingType.FARM);}	
	
	@FXML
	private void handleBuyMine() {		buyBuilding(BuildingType.MINE);}
	
	@FXML
	private void handleBuyFactory() {		buyBuilding(BuildingType.FACTORY);}
	
	@FXML
	private void handleBuyBank() { 		buyBuilding(BuildingType.BANK);}	
	
	@FXML
	private void handleBuyTemple() {		buyBuilding(BuildingType.TEMPLE);}
	
	@FXML
	private void handleBuyWizardTower() {		buyBuilding(BuildingType.WIZARD_TOWER);}
	
	@FXML
	private void handleBuyShipment() {		buyBuilding(BuildingType.SHIPMENT);}
	
	@FXML
	private void handleBuyAlchemyLab() {		buyBuilding(BuildingType.ALCHEMY_LAB);}
	
	@FXML
	private void handleBuyPortal() {		buyBuilding(BuildingType.PORTAL);}
	
	@FXML
	private void handleBuyTimeMachine() {		buyBuilding(BuildingType.TIME_MACHINE);}
	
	@FXML
	private void handleBuyAntimatterCondenser() {		buyBuilding(BuildingType.ANITMATTER_CONDENSER);}
}