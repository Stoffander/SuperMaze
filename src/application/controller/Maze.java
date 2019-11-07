package application.controller;

import java.io.FileInputStream;

import application.controller.Cell;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Maze extends Stage{
	
    BorderPane mainPane = new BorderPane();
    HBox hBox = new HBox();
    Label labelP1 = new Label("BATMAN LIFE: 100");
    Label labelP2 = new Label("SUPERMAN LIFE: 100");
    
	 
	 //create circle/movement properties
    double increment = 25.0;
    //create Rectangle properties
    double Rwidth = 80;
    double Rheight = 20;
    //create player and objects
    Player player = new Player();//superman
    Player2 player2 = new Player2();//batman
    int Playerlife1 = 100;
    int Playerlife2 = 100;
    
    //Rectangle r1 = new Rectangle(0, 100, Rwidth, Rheight);//Rectangle(int x, int y, int width, int height)
    private Cell[][] mazegrid = new Cell[21][21];
    
   
    
    
//    public void start(final Stage stage) throws Exception {
    public void setupMaze(){
        int rows = 21;
        int columns = 21;
   
//        String path = "../Game/Image/Superman.png"; // relative path
//        Image image = new Image(new FileInputStream(path)); 
//        ImageView imageView = new ImageView(image);   
//        FlowPane img = new FlowPane();
//        img.getChildren().add(imageView); 
      //Creating a layout
        
       //	r1.setTranslateY(155);
        this.setTitle("Enjoy your game");
        
        
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
        
//                pane.setOnMouseReleased(e -> {
//                    
//                    pane.getChildren().add(Anims.getAtoms(1));
//                    
//                   
//                 
//                });
//               
    			
    			
                /*BorderPane border = new BorderPane();
                BorderPane border1 = new BorderPane();
                BorderPane border2 = new BorderPane();
                BorderPane border3 = new BorderPane();
                BorderPane border4 = new BorderPane();
                BorderPane border5 = new BorderPane();
                BorderPane border6 = new BorderPane();
                BorderPane border7 = new BorderPane();
                BorderPane border8 = new BorderPane();
                BorderPane border9 = new BorderPane();
                BorderPane border10 = new BorderPane();
                border.getStyleClass().add("game-border-color");  	
                border1.getStyleClass().add("game-border-color"); 
                border2.getStyleClass().add("game-border-color");
                border3.getStyleClass().add("game-border-color");
                border4.getStyleClass().add("game-border-color");
                border5.getStyleClass().add("game-border-color");
                border6.getStyleClass().add("game-border-color");
                border7.getStyleClass().add("game-border-color");  
                border8.getStyleClass().add("game-border-color");
                border9.getStyleClass().add("game-border-color"); 
                border10.getStyleClass().add("game-border-color");  
                grid.add(border, 2,3,3,1);
                grid.add(border1, 5,3,4,1);
                grid.add(border2, 13,15,5,1);
                grid.add(border3, 3,7,1,5);
                grid.add(border4, 11,11,1,3);
                grid.add(border5, 2,16,4,1);
                grid.add(border6, 16,2,1,4);
                grid.add(border7, 16,5,3,1);
                grid.add(border8, 7,9,3,3);
                grid.add(border9, 13,7,1,5);
                grid.add(border10, 13,15,2,3);
            
        		
    			
//    			grid.addColumn(columnIndex, children);
//    			grid.addRow(rowIndex, children);
    			
    			


                pane.getStyleClass().add("game-grid-cell");
          
//                if (i == 0) {
//                    pane.getStyleClass().add("first-column");
//                }
//                if (j == 0) {
//                    pane.getStyleClass().add("first-row");
//                }
                grid.add(pane, i, j);
                
                
            }
        }*/
        
        mainPane.setCenter(grid);//place the main game inside the center
        mainPane.setPadding(new Insets(20, 20, 20, 20));
        mainPane.setStyle("-fx-border-color: red");
        labelP2.setAlignment(Pos.CENTER_RIGHT);
        hBox.setMargin(labelP2, new Insets(0, 0, 0, 550)); 
        
    //    labelP1.setPrefHeight(20);
     //   labelP2.setPrefHeight(20);
   //     labelP1.setAlignment(Pos.TOP_LEFT);
          mainPane.setTop(hBox);
          hBox.getChildren().addAll(labelP1, labelP2);
       // Scene scene = new Scene(grid, (columns * 40) + 100, (rows * 40) + 100, Color.WHITE);
        Scene scene = new Scene(mainPane, Color.WHITE);
        
        //grid.getChildren().add(player);
        moveCircleOnKeyPress(scene);
        
        //r1.setFill(Color.GREEN);

        scene.getStylesheets().add(getClass().getResource("game.css").toExternalForm());
        this.setScene(scene);
        this.show();
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
//	                     if (Shape.intersect(player, r1).getBoundsInLocal().getWidth() != -1)
//	                     {
//	                         player.setCenterY(player.getCenterY() + increment);
//	                     }
	                	 
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
	                     
	                     //st.seCycleCount(Timeline.INDEFINITE);
	                     //st.setAutoReverse(true);
	                     st.play();
	                     el1.setFill(Color.GRAY);
	                     el1.setStroke(Color.YELLOW);
	                     mainPane.getChildren().addAll(el1);
	                	// mazegrid[player2.getX()][player2.getY()].setClip(el1);
	                	 mazegrid[player2.getX()][player2.getY()].setBottom(el1);
	                	 
	                	 
	                	 
	                	 int disX;
	                	 int disY;
	                	 disX = player2.getX() - player.getX();
	                	 disY = player2.getY() - player.getY();
	                	 System.out.println(disX);
	                	 if ((-2 <= disX && disX <= 2)&& (-2 <= disY && disY <= 2)) {
	                		 
	                		 System.out.println("HITTTT");
	                	
	                		 if(Playerlife2>0) {
	                			 Playerlife2 = Playerlife2-10;
	                			 String PlayerlifeS = Integer.toString(Playerlife2);
	                			 labelP2.setText("SUPERMAN LIFE:" + PlayerlifeS);
	                		
		                		}
	                		 
	                		if(Playerlife2==0) {
	                			labelP2.setTextFill(Color.RED);
	                			labelP2.setText("GAME OVER");
	                			player.setVisible(false);
	                			System.out.println("oasd");
	                		}
	                		 
	                		 System.out.println(Playerlife2);
	                	 }
	                	 
	                	// mazegrid[player2.getX()][player2.getY()].setBottom(el1);
	                	
	             
            	 break;
             case SHIFT:	                	
            	
            	 Ellipse el2 = new Ellipse();
            	 System.out.println("Detected " );
            	 el2.setRadiusX(15);
            	 el2.setRadiusY(15);
            	 ScaleTransition st1 = new ScaleTransition(Duration.millis(2000), el2);
                 st1.setFromX(10);
                 st1.setFromY(10);
                 st1.setToX(0);
                 st1.setToY(0);
                 
                 //st.seCycleCount(Timeline.INDEFINITE);
                 //st.setAutoReverse(true);
                 st1.play();
                 el2.setFill(Color.RED);
                 el2.setStroke(Color.BLUE);
                 mainPane.getChildren().addAll(el2);
            	// mazegrid[player2.getX()][player2.getY()].setClip(el1);
            	 mazegrid[player.getX()][player.getY()].setCenter(el2);
            	 
            	 
            	 
            	 //el1.setCenterY(this.player.getCenterY());
            	// el1.setCenterX(100);
            	// el1.setCenterY(100);
            	 
            	 
            	 int disX2;
            	 int disY2;
            	 disX = player.getX() - player2.getX();
            	 disY = player.getY() - player2.getY();
            	 System.out.println(disX);
            	 if ((-2 <= disX && disX <= 2)&& (-2 <= disY && disY <= 2)) {
            		 
            		 System.out.println("HITTTT");
            	
            		 if(Playerlife1>0) {
            			 Playerlife1 = Playerlife1-10;
            			 String PlayerlifeS2 = Integer.toString(Playerlife1);
            			 labelP1.setText("BATMAN LIFE:" + PlayerlifeS2);
            		
                		}
            		 
            		if(Playerlife1==0) {
            			labelP1.setTextFill(Color.RED);
            			player2.setVisible(false);
            			labelP1.setText("GAME OVER");
            			
            		}
            		
            		
            		 
            		 System.out.println(Playerlife2);
            	 }
            	 
            	 
	             break;
	             
             case SPACE:
            	 Arc arc = new Arc();
            	    

            	 arc.setRadiusX(15.0f);
            	 arc.setRadiusY(15.0f);
            	 arc.setStartAngle(90.0f);
            	 arc.setLength(200.0f);
            	 arc.setRotate(200.0f);
            
            	 
            	 
            	 arc.setFill(Color.PURPLE);
         

                 FadeTransition fadeTransition1 = 
                         new FadeTransition(Duration.millis(4000), arc);
                     fadeTransition1.setFromValue(1.0f);
                     fadeTransition1.setToValue(0f);
                     //fadeTransition.setCycleCount(50);
                     //fadeTransition.setAutoReverse(true);
                     
                 TranslateTransition translateTransition1 =
                         new TranslateTransition(Duration.millis(3000), arc);
                     translateTransition1.setFromX(50);
                     translateTransition1.setToX(450);
                  
                     
                 RotateTransition rotateTransition1 = 
                         new RotateTransition(Duration.millis(500), arc);
                     rotateTransition1.setByAngle(180f);
                     rotateTransition1.setCycleCount(18);
                     rotateTransition1.setAutoReverse(true);
                 
                    
                     
                     ParallelTransition parallelTransition1 = new ParallelTransition(
                             fadeTransition1,
                             translateTransition1,
                             rotateTransition1
                             
                     );
                     
                     //parallelTransition.setCycleCount(Timeline.INDEFINITE);
                     parallelTransition1.play();
                 
                     mainPane.getChildren().add(arc);
                     
                     mazegrid[player2.getX()][player2.getY()].setTop(arc);
            	 break;
            	 
             case ENTER:
            	 Rectangle rectParallel = new Rectangle(10,10,15, 15);
            	    
                 rectParallel.setFill(Color.RED);
                 rectParallel.setTranslateX(22);
                 rectParallel.setTranslateY(33);

                 FadeTransition fadeTransition = 
                         new FadeTransition(Duration.millis(4000), rectParallel);
                     fadeTransition.setFromValue(1.0f);
                     fadeTransition.setToValue(0f);
                     //fadeTransition.setCycleCount(50);
                     //fadeTransition.setAutoReverse(true);
                     
                 TranslateTransition translateTransition =
                         new TranslateTransition(Duration.millis(3000), rectParallel);
                     translateTransition.setFromX(player.getX());
                     translateTransition.setToX(player.getX()-450);
                     
          
                  
                     
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
                     
                     //parallelTransition.setCycleCount(Timeline.INDEFINITE);
                     parallelTransition.play();
                 
                     mainPane.getChildren().add(rectParallel);
                //     mainPane.setTop(labelP1);
                     
                     mazegrid[player.getX()][player.getY()].setTop(rectParallel);
	                	 }                
	        	 
	        	 
	             
	        });
	    }
		
	}


    
}