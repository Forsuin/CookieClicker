package itec220.cookieClicker;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    
    private static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage stage) throws IOException {
    	
    	stage.setTitle("Cookie Clicker");
    	scene = new Scene(loadFXML("primary"), 630, 480);
    	stage.setScene(scene);
    	stage.show();
    	
    	//make sure threads are cleaned up before closing
    	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
				System.exit(0);
			}
    		
    	});
    }
    
    public static void startGame() {
    	GameController controller = (GameController) fxmlLoader.getController();
    	controller.runGame();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
    	fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));

        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}