package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class deleteController {
	
	Scene mainPage;
	Stage window;
	
	public void initialize(Scene mainPage, Stage window) {
		this.mainPage = mainPage;
		this.window = window;
	}
	
	public void cancel_open_mainPage() {
		window.setScene(mainPage);
	}
	
	public void confirm_open_mainPage() {
		window.setScene(mainPage);
	}
}
