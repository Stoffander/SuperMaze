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
	
	//Get Character Name
	public String getPlayer1Name(){
		return player1Name;
	}
	
	public String getPlayer2Name(){
		return player2Name;
	}
	
	//Set Character	Index
	public void setPlayer1Name(String player1Name){
		this.player1Name = player1Name;
	}
	
	public void setPlayer2Name(String player2Name){
		this.player2Name = player2Name;
	}
}
