package application.controller;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import application.model.Players;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

/*
 *The players are shapes capable of moving around the grid. 
 *An image related to the player profile is attached to the shape .
 * 
 * 
 * */

public class Player extends Circle
{

	private int x;
	private int y;
	
	
	public Player ()
	{
		x = 15;
		y = 15;
		
		this.setRadius(15);
		this.x =10; 
		this.y =10; 
		
		Players p = new Players();

		ImagePattern imageView = new ImagePattern(p.getPlayer1Image());   
        this.setFill(imageView);
        
        
	}


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
