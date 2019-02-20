package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class editController {
	private Song selectedSong;
	@FXML private TextField title;
	@FXML private TextField artist;
	@FXML private TextField album;
	@FXML private TextField year;
	@FXML private Label error_message;
	private ArrayList<Song> songList = new ArrayList<>();
	
	public void passSelectedSong(Song selectedSong, ArrayList<Song> songList) {
		this.selectedSong = selectedSong;
		this.songList = songList;
		
		title.setText(selectedSong.getTitle());
		artist.setText(selectedSong.getArtist());
		album.setText(selectedSong.getAlbum());
		year.setText(selectedSong.getYear());
	}
	
	public void cancel_open_mainPage(ActionEvent event) throws IOException {
		FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = mainFXMLLoader.load();
		Scene mainPage = new Scene(root);
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Song Library");
		window.setScene(mainPage);
	}
	
	public void confirm_open_mainPage(ActionEvent event) throws Exception {
		boolean exists = checkIfSongExists();
		if(exists == false && title.getText().length()>0 && artist.getText().length()>0){
			Song newSong = new Song(title.getText(),artist.getText(),album.getText(),year.getText());
			songList.remove(selectedSong);
			songList.add(newSong);
			
			FXMLLoader mainFXMLLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
	        Parent root = mainFXMLLoader.load();
			Scene mainPage = new Scene(root);
			
			mainController mainControl = mainFXMLLoader.getController();
			mainControl.updateList(songList);
			mainControl.update_selection_after_edit_add(newSong);
			
	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setTitle("Song Library");
		    window.setScene(mainPage);
		}else if(exists == true){
			error_message.setText("Error. Song already Exist.");
		}else {
			error_message.setText("Both Song title and artist required");
		}
	}
	
	public boolean checkIfSongExists() {
		for(Song s : songList) {
			if(s.isDuplicate(title.getText(), artist.getText()) == true) {
				return true;
			}
		}
		return false;
	}

}
