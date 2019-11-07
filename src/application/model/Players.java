package application.model;

import javafx.scene.image.Image;

public class Players {
	private static Image player1Image;
	private static Image player2Image;
	
	private static String player1Name;
	private static String player2Name;
	
	//Get Character Image
	public Image getPlayer1Image(){
		return player1Image;
	}
	
	public Image getPlayer2Image(){
		return player2Image;
	}
	
	//Set Character	Index
	public void setPlayer1Image(Image player1Image){
		this.player1Image = player1Image;
	}
	
	public void setPlayer2Image(Image player2Image){
		this.player2Image = player2Image;
	}
}
