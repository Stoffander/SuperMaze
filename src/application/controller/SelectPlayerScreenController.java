package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Players;
import application.controller.Maze;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;

import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SelectPlayerScreenController implements Initializable {
	


	
	//initialise fxml components
	@FXML ImageView imgViewP2;
	
	@FXML ImageView imgViewP1;
	
	@FXML Label player1Ready;
	
	@FXML Label player2Ready;
	
	@FXML VBox scene;
	
	@FXML Label namePlayer1;
	
	@FXML Label namePlayer2;
	
	// initialise model
	
	Players p = new Players();
	   
	//initialise images
	Image img1 = new Image("file:img/CatWoman.png");
	Image img2 = new Image("file:img/Superman.png");
	Image img3 = new Image("file:img/batman.png");
	
	//counter for the image list for each player
    private int a = 0;
    private int b = 1;
    
    boolean p1Ready = false;
    boolean p2Ready = false;
    


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
    
	@FXML
	private void Player1KeyCmd(KeyEvent event) throws IOException
	{
		
		//add images to a list
		ArrayList<Image> imgList = new ArrayList<Image>();
		imgList.add(img1);
		imgList.add(img2);	
		imgList.add(img3);

		ArrayList<String> namesList = new ArrayList<String>();
		namesList.add("Cat Woman");
		namesList.add("Superman");	
		namesList.add("Batman");
		
			//Player1 commands
		    if (event.getCode().equals(KeyCode.A)) {
		    	System.out.println("A pressed");
		    	a++;
		    	if (a >= imgList.size()) 
		    		{a=0;}   	
		    	imgViewP1.setImage(imgList.get(a));
		    	namePlayer1.setText(namesList.get(a));
		    	
		    		    	
		    }
		    else if (event.getCode().equals(KeyCode.D)) {
		    	System.out.println("D pressed");
		    	if (a == 0) 
	    			{a=imgList.size() -1;}
		    	else
			    	{a--;}

		    	imgViewP1.setImage(imgList.get(a));	  
		    	namePlayer1.setText(namesList.get(a));
		    }
		    else if (event.getCode().equals(KeyCode.SPACE)) {
		    	System.out.println("Space pressed");
		    	player1Ready.setOpacity(1);
		    	imgViewP1.setOpacity(0.6);
		    	p1Ready = true;
		    	
		    	//both players ready, call new scene
		    	if (p2Ready == true)


		    	{
		    		//update model
		    		p.setPlayer1Image(imgViewP1.getImage());
		    		p.setPlayer2Image(imgViewP2.getImage());
		    		
		    		p.setPlayer1Name(namePlayer1.getText());
		    		p.setPlayer2Name(namePlayer2.getText());
		    		
		    		Maze root = new Maze();
		    		root.setupMaze();
		    	}
		    }
		    
		    //Player2 commands
		    else if (event.getCode().equals(KeyCode.LEFT)) {
		    	System.out.println("Left arrow pressed");
		    	b++;
		    	if (b >= imgList.size()) 
		    		{b=0;}   	
		    	imgViewP2.setImage(imgList.get(b));
		    	namePlayer2.setText(namesList.get(b));
		    }
		    else if (event.getCode().equals(KeyCode.RIGHT)) {
		    	System.out.println("Rightarrow presser");

		    	if (b == 0) 
	    			{b=imgList.size() -1;}
		    	else
			    	{b--;}

		    	imgViewP2.setImage(imgList.get(b));
		    	namePlayer2.setText(namesList.get(b));
		    	
		    }
		    else if (event.getCode().equals(KeyCode.ENTER)) {
		    	System.out.println("Enter pressed");
		    	player2Ready.setOpacity(1);
		    	imgViewP2.setOpacity(0.6);
		    	p2Ready = true;
		    	
		    	
		    	//Both players ready, change screen
		    	if (p1Ready == true)
		    	{
		    		//update model
		    		p.setPlayer1Image(imgViewP1.getImage());
		    		p.setPlayer2Image(imgViewP2.getImage());
		    		

		    		p.setPlayer1Name(namePlayer1.getText());
		    		p.setPlayer2Name(namePlayer2.getText());

		    		Maze root = new Maze();
		    		root.setupMaze();
		    	}
		    }
	}
	

}
