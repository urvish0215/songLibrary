package application;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class addController {
	
	@FXML private TextField title;
	@FXML private TextField artist;
	@FXML private TextField album;
	@FXML private TextField year;
	private ArrayList<Song> songList = new ArrayList<>();
	
	public void initList(ArrayList<Song> songList) {
		this.songList = songList;
	}
	
	public void cancel_open_mainPage(ActionEvent event) throws Exception {
		FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = mainFXMLLoader.load();
		Scene mainPage = new Scene(root);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(mainPage);
	}
	
	public void confirm_open_mainPage(ActionEvent event) throws Exception {
		Song newSong = new Song(title.getText(),artist.getText(),album.getText(),year.getText());
		
		//Add check if exists. to be created.
		/*
		boolean exists = checkIfSongExists(newSong);
		if(exists == true){
		create error page and return to addPage.
		need to figure out how to hide and how hidden message
		}
		*/
		
		songList.add(newSong);
		
		FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = mainFXMLLoader.load();
		Scene mainPage = new Scene(root);
		
		mainController mainControl = mainFXMLLoader.getController();
		mainControl.updateList(songList);
		
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    window.setScene(mainPage);
	}
	
	public boolean checkIfSongExists(Song newSong) {
		for(Song s : songList) {
			if(s.getTitle().compareTo(newSong.getTitle()) != 0)
				return false;
			else if(s.getArtist().compareTo(newSong.getArtist()) != 0)
				return false;
			else if(s.getAlbum().compareTo(newSong.getAlbum()) != 0)
				return false;
			else if(s.getYear().compareTo(newSong.getYear()) != 0)
				return false;
			else
				return true;
		}
		return false;
	}
}
