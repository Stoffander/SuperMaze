package application.controller;

import javafx.scene.layout.BorderPane;

public class Cell extends BorderPane
{
	boolean wall = false;

	public Cell(boolean wall)
	{
		this.wall = wall;
		
		if(wall)
		{
			this.getStyleClass().add("game-border-color"); 
		}
		else
		{
			this.getStyleClass().add("game-grid-cell");		
		}
	}
	
	public Cell()
	{
		this.wall = false;

		if(wall)
		{
			this.getStyleClass().add("game-border-color"); 
		}
		else
		{
			this.getStyleClass().add("game-grid-cell");		
		}
	}
	
	public boolean isWall()
	{
		return wall;
	}
	
	public void setWall(boolean wall)
	{
		this.wall = wall;
		
		if(wall)
		{
			this.getStyleClass().add("game-border-color"); 
		}
		else
		{
			this.getStyleClass().add("game-grid-cell");		
		}
	}
	//

}
