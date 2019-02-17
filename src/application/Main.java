package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		
		//Main Page
		FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("mainWindow.fxml"));
        Scene mainPage = new Scene(mainFXMLLoader.load());
		
		//Add Page
		FXMLLoader addFXMLLoader = new FXMLLoader(getClass().getResource("addWindow.fxml"));
        Scene addPage = new Scene(addFXMLLoader.load());
		
		//Delete Page
        FXMLLoader deleteFXMLLoader = new FXMLLoader(getClass().getResource("deleteWindow.fxml"));
        Scene deletePage = new Scene(deleteFXMLLoader.load());
		
		//Edit Page
        FXMLLoader editFXMLLoader = new FXMLLoader(getClass().getResource("editWindow.fxml"));
        Scene editPage = new Scene(editFXMLLoader.load());
		
		//linking main page to add,edit,delete pages. Also linking to window/stage
		mainController mainControl = (mainController) mainFXMLLoader.getController();
		mainControl.initialize(mainPage, editPage, addPage, deletePage, window);
		
		//linking add page to main page
		addController addControl = (addController) addFXMLLoader.getController();
		addControl.initialize(mainPage, window);
		
		//linking delete page to main page
		deleteController deleteControl = (deleteController) deleteFXMLLoader.getController();
		deleteControl.initialize(mainPage, window);
		
		//linking edit page to main page
		editController editControl = (editController) editFXMLLoader.getController();
		editControl.initialize(mainPage, window);
		
	    window.setScene(mainPage);
	    window.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
