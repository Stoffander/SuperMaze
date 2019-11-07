package application.controller;

import java.io.IOException;
import java.util.ArrayList;

import application.model.Player1;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SelectPlayerScreenController {
	
	//initialise fxml components
	@FXML ImageView imgViewP2;
	
	@FXML ImageView imgViewP1;
	
	@FXML Label player1Ready;
	
	@FXML Label player2Ready;
	
	@FXML VBox scene;
	
	@FXML Label namePlayer1;
	
	@FXML Label namePlayer2;

	Image img1 = new Image("file:img/CatWoman.png");
	Image img2 = new Image("file:img/Superman.png");
	Image img3 = new Image("file:img/batman.png");
	
	//counter for the image list for each player
    private int a = 1;
    private int b = 0;
    
    boolean p1Ready = false;
    boolean p2Ready = false;
	
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
		    	
		    	if (p2Ready == true)
		    	{
		    		
		    		Maze root = new Maze();
		    		root.setupMaze();
		    		
//		    		Parent newParent = FXMLLoader.load(getClass().getResource("/application/view/MazeScreen.fxml"));
//		    	
//		    		
//		    		Stage stage = (Stage) scene.getScene().getWindow();
		    		//Scene scene = new Scene();
//		    		stage.setScene(scene);		
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
		    	
		    	if (p1Ready == true)
		    	{
		    		Maze root = new Maze();
		    		root.setupMaze();
		    		
		    		
//		    		Scene scene = new Scene(root);
		    		

		    		
		    		
//		    		Parent newParent = FXMLLoader.load(getClass().getResource("/application/view/MazeScreen.fxml"));
//		    		Stage stage = (Stage) scene.getScene().getWindow();
//		    		Scene scene = new Scene(newParent);
//		    		stage.setScene(scene);		
		    	}
		    }
	}
	

	

}
