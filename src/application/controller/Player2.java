package application.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class Player2 extends Circle
{

	private int x;
	private int y;
	
	
	public Player2 ()
	{
		x = 15;
		y = 15;
		
		this.setRadius(15);
		//this.setCenterX(15);
		//this.setCenterY(15);
		//this.setFill(Color.RED);
		this.x =5; 
		this.y =5; 
		
		String path = "./img/batman.png"; // relative path
	    Image image = null;
		try {
			image = new Image(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ImagePattern imageView = new ImagePattern(image);   
        
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

