package application;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class mainController {
	
	@FXML ListView<Song> lView;
	@FXML private ListCell<String> Song_titles;
	private ArrayList<Song> songArray = new ArrayList<>();
	
	@FXML private Label title;
	@FXML private Label artist;
	@FXML private Label album;
	@FXML private Label year;
	
	public void initialize() throws IOException {
		File file;
		String path = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\application\\Songfile.txt";
		file = new File(path);
		file.createNewFile();
		
		Scanner t = new Scanner(file); 
		 
	    while (t.hasNextLine()) {
	    	Song newSong = new Song(t.nextLine());
	    	songArray.add(newSong);
		}
	    Collections.sort(songArray, Song.songTitleComparator);
	    lView.getItems().addAll(songArray);
	    
	    if(lView.getItems().isEmpty() == false) {
	    
		    lView.getSelectionModel().select(0);
		    Song s = (Song) lView.getSelectionModel().getSelectedItem();
		    title.setText(s.getTitle());
		    artist.setText(s.getArtist());
		    album.setText(s.getAlbum());
		    year.setText(s.getYear());
	    }
	    t.close();
		
	}
	public void update_selection_after_clicks() {
		Song s = (Song) lView.getSelectionModel().getSelectedItem();
	    title.setText(s.getTitle());
	    artist.setText(s.getArtist());
	    album.setText(s.getAlbum());
	    year.setText(s.getYear());
	}
	
	public void open_addPage(ActionEvent event) throws Exception {
		FXMLLoader addFXMLLoader = new FXMLLoader(getClass().getResource("addWindow.fxml"));
        Scene addPage = new Scene(addFXMLLoader.load());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		addController addControl = addFXMLLoader.getController();
		addControl.initList(songArray);
		window.setTitle("Add a Song to Library");
		window.setScene(addPage);
	}
	
	public void open_editPage(ActionEvent event) throws Exception {
		Song selectedSong = (Song) lView.getSelectionModel().getSelectedItem();
		
		FXMLLoader editFXMLLoader = new FXMLLoader(getClass().getResource("editWindow.fxml"));
        Scene editPage = new Scene(editFXMLLoader.load()); 
        
        editController editControl = editFXMLLoader.getController();
        editControl.passSelectedSong(selectedSong, songArray);
        
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Edit Song");
		window.setScene(editPage);
	}
	
	public void open_deletePage(ActionEvent event) throws Exception {
		Song selectedSong = (Song) lView.getSelectionModel().getSelectedItem();
		
		FXMLLoader deleteFXMLLoader = new FXMLLoader(getClass().getResource("deleteWindow.fxml"));
        Scene editPage = new Scene(deleteFXMLLoader.load()); 
        
        deleteController deleteControl = deleteFXMLLoader.getController();
        deleteControl.passSelectedSong(selectedSong, songArray);
        
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setTitle("Delete Song");
		window.setScene(editPage);
	}
	
	public void exit_program(ActionEvent event) throws Exception {
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
	public void updateList(ArrayList<Song> songArray) throws IOException {
		this.songArray = songArray;
		Collections.sort(songArray, Song.songTitleComparator);
		String path = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\application\\Songfile.txt";
		Writer fileWriter = new FileWriter(path);

		for (Song s : songArray) {
			fileWriter.write(s.printToFileString());
		}
		lView.getItems().clear();
		lView.getItems().addAll(songArray);
		
	    lView.refresh();
	    
	    if(lView.getItems().isEmpty() == false) {
		    
		    lView.getSelectionModel().select(0);
		    Song s = (Song) lView.getSelectionModel().getSelectedItem();
		    title.setText(s.getTitle());
		    artist.setText(s.getArtist());
		    album.setText(s.getAlbum());
		    year.setText(s.getYear());
	    }else {
	    	title.setText("");
		    artist.setText("");
		    album.setText("");
		    year.setText("");
	    }
		fileWriter.close();
	}
	
	public void update_selection_after_edit_add(Song selectedSong) {
		int newSelection = songArray.indexOf(selectedSong);
		
		lView.getSelectionModel().select(newSelection);
	    Song s = (Song) lView.getSelectionModel().getSelectedItem();
	    title.setText(s.getTitle());
	    artist.setText(s.getArtist());
	    album.setText(s.getAlbum());
	    year.setText(s.getYear());
	}
	
	public void update_selection_after_delete(int selectedPosition) {
		if(selectedPosition >= 0) {
			lView.getSelectionModel().select(selectedPosition);
		    Song s = (Song) lView.getSelectionModel().getSelectedItem();
		    title.setText(s.getTitle());
		    artist.setText(s.getArtist());
		    album.setText(s.getAlbum());
		    year.setText(s.getYear());
		}
	}
}
