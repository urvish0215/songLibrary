//Urvish Patel uyp2
//Mohammed Rupani mrr184

package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class SongLib extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		window.setOnCloseRequest(e -> Platform.exit());
		
		//Main Page
		FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Scene mainPage = new Scene(mainFXMLLoader.load());
        window.setTitle("Song Library");
	    window.setScene(mainPage);
	    window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
