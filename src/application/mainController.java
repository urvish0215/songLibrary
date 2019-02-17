package application;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainController {
	Scene mainPage, editPage, addPage, deletePage;
	Stage window;
	
	
	public void initialize(Scene mainPage, Scene editPage, Scene addPage, Scene deletePage, Stage window) {
		this.mainPage = mainPage;
		this.editPage = editPage;
		this.addPage = addPage;
		this.deletePage = deletePage;
		this.window = window;
	}
	
	public void open_addPage() {
		window.setScene(addPage);
	}
	
	public void open_editPage() {
		window.setScene(editPage);
	}
	
	public void open_deletePage() {
		window.setScene(deletePage);
	}
	
	public void exit_program() {
		window.close();
	}
}
