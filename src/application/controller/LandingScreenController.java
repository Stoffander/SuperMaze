package application.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class LandingScreenController {
	
	@FXML
	Label lbPlayGame;
	
	@FXML
	Label lbCreateMaze;
	
	@FXML
	private void playGame() throws Exception
	{
		Parent newParent = FXMLLoader.load(getClass().getResource("/application/view/SelectPlayerScreen.fxml"));
		Stage stage = (Stage) lbPlayGame.getScene().getWindow();
		Scene scene = new Scene(newParent);
		stage.setScene(scene);		
	}
	
	@FXML
	private void createMaze() throws Exception
	{
		Parent newParent = FXMLLoader.load(getClass().getResource("/application/view/CreateMaze.fxml"));
		Stage stage = (Stage) lbPlayGame.getScene().getWindow();
		Scene scene = new Scene(newParent);
		stage.setScene(scene);		
	}
	
	
}
