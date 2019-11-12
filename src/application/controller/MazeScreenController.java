package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import application.controller.Cell;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;

import application.model.Players;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.geometry.Insets;

import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public abstract class MazeScreenController implements Initializable {
	


	
	
	  BorderPane mainPane = new BorderPane();
	    
		 
		 //create circle/movement properties
		//create circle/movement properties
	    double increment = 25.0;
	    //create Rectangle properties
	    double Rwidth = 80;
	    double Rheight = 20;
	    //create player and objects
	    Player player = new Player();
	    Player2 player2 = new Player2();
	    //Rectangle r1 = new Rectangle(0, 100, Rwidth, Rheight);//Rectangle(int x, int y, int width, int height)
	    private Cell[][] mazegrid = new Cell[21][21];
	    
	  
	    

	    
	    public void start(final Stage stage) throws Exception {
	        int rows = 21;
	        int columns = 21;
	   
//	        String path = "../Game/Image/Superman.png"; // relative path
//	        Image image = new Image(new FileInputStream(path)); 
//	        ImageView imageView = new ImageView(image);   
//	        FlowPane img = new FlowPane();
//	        img.getChildren().add(imageView); 
	      //Creating a layout
	        
	       //	r1.setTranslateY(155);
	        stage.setTitle("Enjoy your game");
	        
	        
	        GridPane grid = new GridPane();
	        grid.getStyleClass().add("game-grid");
	   
	        
	       
	        for(int i = 0; i < columns; i++) {
	            ColumnConstraints column = new ColumnConstraints(37);
	            grid.getColumnConstraints().add(column);
	        }

	        for(int i = 0; i < rows; i++) {
	            RowConstraints row = new RowConstraints(37);
	            grid.getRowConstraints().add(row);
	        }
	        
	        Cell cell;

	        for (int i = 0; i < columns; i++) {
	            for (int j = 0; j < rows; j++) {
	                
	                if (i == 0) {
	                	cell = new Cell(true, false);
	                	grid.add(cell, i, j);
	                	mazegrid[i][j] = cell;
	                }
	                
	                else if (j == 0) {
	                	cell = new Cell(true, false);
	                	grid.add(cell, i, j);
	                	mazegrid[i][j] = cell;
	                }
	                
	                else if (j == 20) {
	                	cell = new Cell(true, false);
	                	grid.add(cell, i, j);
	                	mazegrid[i][j] = cell;
	                }
	                
	                else if (i == 20) {
	                	cell = new Cell(true, false);
	                	grid.add(cell, i, j);
	                	mazegrid[i][j] = cell;
	                }
	                else {
	                	cell = new Cell();
	                	grid.add(cell, i, j);
	                	mazegrid[i][j] = cell;
	                }
	            }
	        }
	        
	        mazegrid[3][3].setWall(true);
	        mazegrid[5][3].setWall(true);
	        mazegrid[7][3].setWall(true);
	        mazegrid[9][3].setWall(true);
	        mazegrid[11][3].setWall(true);
	        mazegrid[13][3].setWall(true);
	        mazegrid[15][3].setWall(true);
	        mazegrid[17][3].setWall(true);
	        
	        mazegrid[3][5].setWall(true);
	        mazegrid[3][7].setWall(true);
	        mazegrid[3][9].setWall(true);
	        mazegrid[3][11].setWall(true);
	        mazegrid[3][13].setWall(true);
	        mazegrid[3][15].setWall(true);
	        mazegrid[3][17].setWall(true);
	        
	        mazegrid[5][17].setWall(true);
	        mazegrid[7][17].setWall(true);
	        mazegrid[9][17].setWall(true);
	        mazegrid[11][17].setWall(true);
	        mazegrid[13][17].setWall(true);
	        mazegrid[15][17].setWall(true);
	        mazegrid[17][17].setWall(true);
	        
	        mazegrid[17][5].setWall(true);
	        mazegrid[17][7].setWall(true);
	        mazegrid[17][9].setWall(true);
	        mazegrid[17][11].setWall(true);
	        mazegrid[17][13].setWall(true);
	        mazegrid[17][15].setWall(true);
	        
	        mazegrid[10][9].setWall(true);
	        mazegrid[10][11].setWall(true);
	        mazegrid[10][13].setWall(true);
	        mazegrid[11][12].setWall(true);
	        mazegrid[11][10].setWall(true);
	        mazegrid[11][11].setWall(true);
	        mazegrid[11][12].setWall(true);
	        mazegrid[12][9].setWall(true);
	        mazegrid[12][11].setWall(true);
	        mazegrid[12][13].setWall(true);
	    
	        
	       
	       
	        
	        
	        
	        mazegrid[player.getX()][player.getY()].setCenter(player);
	        mazegrid[player2.getX()][player2.getY()].setCenter(player2);
	               
	       
	        mainPane.setCenter(grid);//place the main game inside the center
	        mainPane.setPadding(new Insets(10, 10, 10, 10));
	        mainPane.setStyle("-fx-border-color: red");
	     //   mainPane.setLeft(img);
	       // Scene scene = new Scene(grid, (columns * 40) + 100, (rows * 40) + 100, Color.WHITE);
	        Scene scene = new Scene(mainPane, Color.WHITE);
	        
	        //grid.getChildren().add(player);
	        moveCircleOnKeyPress(scene);
	        
	        //r1.setFill(Color.GREEN);

	        scene.getStylesheets().add(getClass().getResource("game.css").toExternalForm());
	        stage.setScene(scene);
	        stage.show();
	    }

	private void moveCircleOnKeyPress(Scene scene) {
		 {//player movement
		        scene.setOnKeyPressed((KeyEvent event) ->
		        {
		        	
		        	 switch (event.getCode())
		             {
		                 case UP:
		                	 //player.setTranslateY( player.getTranslateY() - 40);
		                     //if (player.getBoundsInLocal().intersects(r1.getBoundsInLocal()))
//		                     if (Shape.intersect(player, r1).getBoundsInLocal().getWidth() != -1)
//		                     {
//		                         player.setCenterY(player.getCenterY() + increment);
//		                     }
		                	 
		                	 if(player.getY()-1 >= 0)
		                	 {
		                		 if(!mazegrid[player.getX()][player.getY()-1].isWall())
			                	 {
		                			 mazegrid[player.getX()][player.getY()].setCenter(null);
		                			 player.setY(player.getY() - 1);
		                			 mazegrid[player.getX()][player.getY()].setCenter(player);
			                	 }
		                	 }
		                     break;
		                 case RIGHT:
		                	 if(player.getX()+1 <= 19)
		                	 {
		                		 if(!mazegrid[player.getX()+1][player.getY()].isWall())
			                	 {
		                			 mazegrid[player.getX()][player.getY()].setCenter(null);
		                			 player.setX(player.getX() +1);
		                			 mazegrid[player.getX()][player.getY()].setCenter(player);
			                	 }
		                	 }
		                     break;
		                 case DOWN:
		                	 if(player.getY()+1 <= 19)
		                	 {
		                		 if(!mazegrid[player.getX()][player.getY()+1].isWall())
			                	 {
		                			 mazegrid[player.getX()][player.getY()].setCenter(null);
		                			 player.setY(player.getY() + 1);
		                			 mazegrid[player.getX()][player.getY()].setCenter(player);
			                	 }
		                	 }
		                     break;
		                 case LEFT:
		                	 if(player.getX()-1 >= 0)
		                	 {
		                		 if(!mazegrid[player.getX()-1][player.getY()].isWall())
			                	 {
		                			 mazegrid[player.getX()][player.getY()].setCenter(null);
		                			 player.setX(player.getX() - 1);
		                			 mazegrid[player.getX()][player.getY()].setCenter(player);
			                	 }
		                	 }
		                	 
		                	 
		                     break;
		                 case W:
		                	 if(player2.getY()-1 >= 0)
		                	 {
		                		 if(!mazegrid[player2.getX()][player2.getY()-1].isWall())
			                	 {
		                			 mazegrid[player2.getX()][player2.getY()].setCenter(null);
		                			 player2.setY(player2.getY() - 1);
		                			 mazegrid[player2.getX()][player2.getY()].setCenter(player2);
			                	 }
		                	 }
		                     break;
		                 case D:
		                	 if(player2.getX()+1 <= 19)
		                	 {
		                		 if(!mazegrid[player2.getX()+1][player2.getY()].isWall())
			                	 {
		                			 mazegrid[player2.getX()][player2.getY()].setCenter(null);
		                			 player2.setX(player2.getX() +1);
		                			 mazegrid[player2.getX()][player2.getY()].setCenter(player2);
			                	 }
		                	 }
		                 case S:
		                	 if(player2.getY()+1 <= 19)
		                	 {
		                		 if(!mazegrid[player2.getX()][player2.getY()+1].isWall())
			                	 {
		                			 mazegrid[player2.getX()][player2.getY()].setCenter(null);
		                			 player2.setY(player2.getY() + 1);
		                			 mazegrid[player2.getX()][player2.getY()].setCenter(player2);
			                	 }
		                	 }
		                     break;
		                 case A:
		                	 if(player2.getX()-1 >= 0)
		                	 {
		                		 if(!mazegrid[player2.getX()-1][player2.getY()].isWall())
			                	 {
		                			 mazegrid[player2.getX()][player2.getY()].setCenter(null);
		                			 player2.setX(player2.getX() - 1);
		                			 mazegrid[player2.getX()][player2.getY()].setCenter(player2);
			                	 }                		 
		                		 
		                	 }
		                	 break;
		                 case R:	                	
		                	
		                	 Ellipse el1 = new Ellipse();
		                	 System.out.println("Detected " );
		                	 el1.setRadiusX(15);
		                	 el1.setRadiusY(15);
		                	 ScaleTransition st = new ScaleTransition(Duration.millis(2000), el1);
		                     st.setFromX(10);
		                     st.setFromY(10);
		                     st.setToX(0);
		                     st.setToY(0);
		                     
		                     st.play();
		                     el1.setFill(Color.GRAY);
		                     el1.setStroke(Color.YELLOW);
		                     mainPane.getChildren().addAll(el1);
		                	 mazegrid[player2.getX()][player2.getY()].setBottom(el1);
		                	 
		                	 
		             
	            	 break;
	             case N:	                	
	            	
	            	 Ellipse el2 = new Ellipse();
	            	 System.out.println("Detected " );
	            	 el2.setRadiusX(15);
	            	 el2.setRadiusY(15);
	            	 ScaleTransition st1 = new ScaleTransition(Duration.millis(2000), el2);
	                 st1.setFromX(10);
	                 st1.setFromY(10);
	                 st1.setToX(0);
	                 st1.setToY(0);
	            
	                 st1.play();
	                 el2.setFill(Color.RED);
	                 el2.setStroke(Color.BLUE);
	                 mainPane.getChildren().addAll(el2);

	            	 mazegrid[player.getX()][player.getY()].setCenter(el2);
	            	
		                       
	            	 
	             case G:
	            	 Rectangle rectParallel = new Rectangle(10,10,15, 15);
	            	    
	                 rectParallel.setFill(Color.RED);
	                 rectParallel.setTranslateX(22);
	                 rectParallel.setTranslateY(33);

	                 FadeTransition fadeTransition = 
	                         new FadeTransition(Duration.millis(4000), rectParallel);
	                     fadeTransition.setFromValue(1.0f);
	                     fadeTransition.setToValue(0f);
	                     
	                 TranslateTransition translateTransition =
	                         new TranslateTransition(Duration.millis(3000), rectParallel);
	                     translateTransition.setFromX(50);
	                     translateTransition.setToX(450);
	                  
	                     
	                 RotateTransition rotateTransition = 
	                         new RotateTransition(Duration.millis(3000), rectParallel);
	                     rotateTransition.setByAngle(180f);
	                     rotateTransition.setCycleCount(8);
	                     rotateTransition.setAutoReverse(true);
	                 
	                    
	                     
	                     ParallelTransition parallelTransition = new ParallelTransition(
	                             fadeTransition,
	                             translateTransition,
	                             rotateTransition
	                             
	                     );
	                     
	                     parallelTransition.play();
	                 
	                     mainPane.getChildren().add(rectParallel);
		                	 }                
		        	 
		        	 
		             
		        });
		 
	
	


}}}

