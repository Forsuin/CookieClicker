package itec220.cookieClicker;

import java.text.DecimalFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

public class GameController {

	private Game game;

	@FXML
	private Text cookieAmtUI;

	@FXML
	private ToggleGroup buyAmountGroup;

	@FXML
	private Button buttonBuyClicker;
	@FXML
	private Button buttonBuyGrandma;
	@FXML
	private Button buttonBuyFarm;
	@FXML
	private Button buttonBuyMine;
	@FXML
	private Button buttonBuyFactory;
	@FXML
	private Button buttonBuyBank;
	@FXML
	private Button buttonBuyTemple;
	@FXML
	private Button buttonBuyWizard;
	@FXML
	private Button buttonBuyShipment;
	@FXML
	private Button buttonBuyAlchemy;
	@FXML
	private Button buttonBuyPortal;
	@FXML
	private Button buttonBuyTimeMachine;
	@FXML
	private Button buttonBuyAntimatter;

	@FXML
	private Text cursorPrice;
	@FXML
	private Text cursorAmt;
	@FXML
	private Text grandmaPrice;
	@FXML
	private Text grandmaAmt;
	@FXML
	private Text farmPrice;
	@FXML
	private Text farmAmt;
	@FXML
	private Text minePrice;
	@FXML
	private Text mineAmt;
	@FXML
	private Text factoryPrice;
	@FXML
	private Text factoryAmt;
	@FXML
	private Text bankPrice;
	@FXML
	private Text bankAmt;
	@FXML
	private Text templePrice;
	@FXML
	private Text templeAmt;
	@FXML
	private Text wizardTowerPrice;
	@FXML
	private Text wizardTowerAmt;
	@FXML
	private Text shipmentPrice;
	@FXML
	private Text shipmentAmt;
	@FXML
	private Text alchemyLabPrice;
	@FXML
	private Text alchemyLabAmt;
	@FXML
	private Text portalPrice;
	@FXML
	private Text portalAmt;
	@FXML
	private Text timeMachinePrice;
	@FXML
	private Text timeMachineAmt;
	@FXML
	private Text antimatterPrice;
	@FXML
	private Text antimatterAmt;

	
	private DecimalFormat decFormat;
	
	
	public GameController() {
		game = new Game();
		
		decFormat = new DecimalFormat("###,###");
	}

	public void runGame() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		executor.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					update();
					draw();
				});
			}
		}, 0, 33, TimeUnit.MILLISECONDS);
	}

	private void update() {
		game.update();
		
		
		int amount = Integer.parseInt(buyAmountGroup.getSelectedToggle().getUserData().toString());
		
		double price = this.game.calculateNextPrice(BuildingType.CURSOR, amount);
		this.cursorPrice.setText(decFormat.format(price));
		this.cursorPrice.setFill(((this.game.canBuy(BuildingType.CURSOR, amount) ? Color.GREEN : Color.RED)));
		price = this.game.calculateNextPrice(BuildingType.GRANDMA, amount);
		this.grandmaPrice.setText(decFormat.format(price));
		this.grandmaPrice.setFill((this.game.canBuy(BuildingType.GRANDMA, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.FARM, amount);
		this.farmPrice.setText(decFormat.format(price));
		this.farmPrice.setFill((this.game.canBuy(BuildingType.FARM, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.MINE, amount);
		this.minePrice.setText(decFormat.format(price));
		this.minePrice.setFill((this.game.canBuy(BuildingType.MINE, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.FACTORY, amount);
		this.factoryPrice.setText(decFormat.format(price));
		this.factoryPrice.setFill((this.game.canBuy(BuildingType.FACTORY, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.BANK, amount);
		this.bankPrice.setText(decFormat.format(price));
		this.bankPrice.setFill((this.game.canBuy(BuildingType.BANK, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.TEMPLE, amount);
		this.templePrice.setText(decFormat.format(price));
		this.templePrice.setFill((this.game.canBuy(BuildingType.TEMPLE, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.WIZARD_TOWER, amount);
		this.wizardTowerPrice.setText(decFormat.format(price));
		this.wizardTowerPrice.setFill((this.game.canBuy(BuildingType.WIZARD_TOWER, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.SHIPMENT, amount);
		this.shipmentPrice.setText(decFormat.format(price));
		this.shipmentPrice.setFill((this.game.canBuy(BuildingType.SHIPMENT, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.ALCHEMY_LAB, amount);
		this.alchemyLabPrice.setText(decFormat.format(price));
		this.alchemyLabPrice.setFill((this.game.canBuy(BuildingType.ALCHEMY_LAB, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.PORTAL, amount);
		this.portalPrice.setText(decFormat.format(price));
		this.portalPrice.setFill((this.game.canBuy(BuildingType.PORTAL, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.TIME_MACHINE, amount);
		this.timeMachinePrice.setText(decFormat.format(price));
		this.timeMachinePrice.setFill((this.game.canBuy(BuildingType.TIME_MACHINE, amount) ? Color.GREEN : Color.RED));
		price = this.game.calculateNextPrice(BuildingType.ANTIMATTER_CONDENSER, amount);
		this.antimatterPrice.setText(decFormat.format(price));
		this.antimatterPrice
				.setFill((this.game.canBuy(BuildingType.ANTIMATTER_CONDENSER, amount) ? Color.GREEN : Color.RED));
	}

	private void draw() {
		
		
		
		this.cookieAmtUI.setText(decFormat.format(this.game.getCookiesAmt()));

		this.cursorAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.CURSOR)));
		this.grandmaAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.GRANDMA)));
		this.farmAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.FARM)));
		this.mineAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.MINE)));
		this.factoryAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.FACTORY)));
		this.bankAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.BANK)));
		this.templeAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.TEMPLE)));
		this.wizardTowerAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.WIZARD_TOWER)));
		this.shipmentAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.SHIPMENT)));
		this.alchemyLabAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.ALCHEMY_LAB)));
		this.portalAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.PORTAL)));
		this.timeMachineAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.TIME_MACHINE)));
		this.antimatterAmt.setText(String.valueOf(this.game.getBuildingAmt(BuildingType.ANTIMATTER_CONDENSER)));
	}

	private void buyBuilding(BuildingType type) {
		int amount = Integer.parseInt(buyAmountGroup.getSelectedToggle().getUserData().toString());

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
	private void handleBuyGrandma() {
		buyBuilding(BuildingType.GRANDMA);
	}

	@FXML
	private void handleBuyFarm() {
		buyBuilding(BuildingType.FARM);
	}

	@FXML
	private void handleBuyMine() {
		buyBuilding(BuildingType.MINE);
	}

	@FXML
	private void handleBuyFactory() {
		buyBuilding(BuildingType.FACTORY);
	}

	@FXML
	private void handleBuyBank() {
		buyBuilding(BuildingType.BANK);
	}

	@FXML
	private void handleBuyTemple() {
		buyBuilding(BuildingType.TEMPLE);
	}

	@FXML
	private void handleBuyWizardTower() {
		buyBuilding(BuildingType.WIZARD_TOWER);
	}

	@FXML
	private void handleBuyShipment() {
		buyBuilding(BuildingType.SHIPMENT);
	}

	@FXML
	private void handleBuyAlchemyLab() {
		buyBuilding(BuildingType.ALCHEMY_LAB);
	}

	@FXML
	private void handleBuyPortal() {
		buyBuilding(BuildingType.PORTAL);
	}

	@FXML
	private void handleBuyTimeMachine() {
		buyBuilding(BuildingType.TIME_MACHINE);
	}

	@FXML
	private void handleBuyAntimatterCondenser() {
		buyBuilding(BuildingType.ANTIMATTER_CONDENSER);
	}
}