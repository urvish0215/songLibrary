package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		
		//Main Page
		FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Scene mainPage = new Scene(mainFXMLLoader.load());
	    window.setScene(mainPage);
	    window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
