package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class deleteController {
	private Song selectedSong;
	private ArrayList<Song> songList = new ArrayList<>();
	
	public void cancel_open_mainPage(ActionEvent event) throws IOException {
		FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = mainFXMLLoader.load();
		Scene mainPage = new Scene(root);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(mainPage);
	}
	
	public void confirm_open_mainPage(ActionEvent event) throws IOException {
		int position = songList.indexOf(selectedSong);
		
		songList.remove(selectedSong);
		
		FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = mainFXMLLoader.load();
		Scene mainPage = new Scene(root);
		
		mainController mainControl = mainFXMLLoader.getController();
		mainControl.updateList(songList);
		
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    window.setScene(mainPage);
		
	}

	public void passSelectedSong(Song selectedSong, ArrayList<Song> songList) {
		this.selectedSong = selectedSong;
		this.songList = songList;
		
	}
}
