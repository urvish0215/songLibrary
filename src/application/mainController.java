package application;

import java.io.*;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class mainController {
	
	@FXML ListView L;
	@FXML private ListCell<String> Song_titles;
	private ArrayList<Song> songArray = new ArrayList<>();
	
	
	public void initialize() throws IOException {
		File file;
		String path = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\application\\Songfile.txt";
		file = new File(path);
		file.createNewFile();
		
		Scanner t = new Scanner(file); 
		 
	    while (t.hasNextLine()) {
	    	Song newSong = new Song(t.nextLine());
	    	songArray.add(newSong);
	    	L.getItems().add(newSong);
		}
	    L.setEditable(true);    
	    t.close();
		
	}
	
	public void open_addPage(ActionEvent event) throws Exception {
		FXMLLoader addFXMLLoader = new FXMLLoader(getClass().getResource("addWindow.fxml"));
        Scene addPage = new Scene(addFXMLLoader.load());
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		addController addControl = addFXMLLoader.getController();
		addControl.initList(songArray);
		window.setScene(addPage);
	}
	
	public void open_editPage(ActionEvent event) throws Exception {
		Song selectedSong = (Song) L.getSelectionModel().getSelectedItem();
		
		FXMLLoader editFXMLLoader = new FXMLLoader(getClass().getResource("editWindow.fxml"));
        Scene editPage = new Scene(editFXMLLoader.load()); 
        
        editController editControl = editFXMLLoader.getController();
        editControl.passSelectedSong(selectedSong, songArray);
        
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(editPage);
	}
	
	public void open_deletePage(ActionEvent event) throws Exception {
		Song selectedSong = (Song) L.getSelectionModel().getSelectedItem();
		
		FXMLLoader deleteFXMLLoader = new FXMLLoader(getClass().getResource("deleteWindow.fxml"));
        Scene editPage = new Scene(deleteFXMLLoader.load()); 
        
        deleteController deleteControl = deleteFXMLLoader.getController();
        deleteControl.passSelectedSong(selectedSong, songArray);
        
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(editPage);
	}
	
	public void exit_program(ActionEvent event) throws Exception {
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.close();
	}
	
	public void updateList(ArrayList<Song> songArray) throws IOException {
		this.songArray = songArray;
		String path = Paths.get(".").toAbsolutePath().normalize().toString() + "\\src\\application\\Songfile.txt";
		Writer fileWriter = new FileWriter(path);

		for (Song s : songArray) {
			fileWriter.write(s.printToFileString());
		}
		this.L.getItems().clear();
		this.L.getItems().addAll(songArray);
		
	    this.L.refresh();
		

		fileWriter.close();
	}
}
