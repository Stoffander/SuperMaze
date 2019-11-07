package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Players;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MazeScreenController implements Initializable {
	
	//initialise fxml components
	@FXML ImageView imgViewP2;
	
	@FXML ImageView imgViewP1;
	
	@FXML
	private void Player1KeyCmd(KeyEvent event) throws IOException
	{

		switch(event.getCode()) { 
		case RIGHT:
			imgViewP1.setTranslateX( imgViewP1.getTranslateX() + 10);
			break;
		case LEFT:
			imgViewP1.setTranslateX( imgViewP1.getTranslateX() - 10);
			break;	
		case UP:
			imgViewP1.setTranslateY( imgViewP1.getTranslateY() - 10);
			break;	
		case DOWN:
			imgViewP1.setTranslateY( imgViewP1.getTranslateY() + 10);
			break;	
		case D:
			imgViewP2.setTranslateX( imgViewP2.getTranslateX() + 10);
			break;
		case A:
			imgViewP2.setTranslateX( imgViewP2.getTranslateX() - 10);
			break;	
		case W:
			imgViewP2.setTranslateY( imgViewP2.getTranslateY() - 10);
			break;	
		case S:
			imgViewP2.setTranslateY( imgViewP2.getTranslateY() + 10);
			break;	
	}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Players p = new Players();
		p.getPlayer1Image();
		p.getPlayer2Image();
		
		imgViewP1.setImage(p.getPlayer1Image());
		imgViewP2.setImage(p.getPlayer1Image());
	}
}
