package application.controller;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class MoveLabel extends Application {
	 
    double lx,ly; // storing starting coordinates for label

    

    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        
        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
		
        Label lbl = new Label("Hello World");
        lbl.setStyle(("-fx-background-color: gainsboro"));
        root.getChildren().add(lbl);
        Scene scene = new Scene(root, 300, 250);

        scene.setOnKeyPressed( new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
            			switch(e.getCode()) { 
            				case RIGHT:
            					lbl.setTranslateX( lbl.getTranslateX() + 10);
            					break;
            				case LEFT:
            					lbl.setTranslateX( lbl.getTranslateX() - 10);
            					break;	
            				case UP:
            					lbl.setTranslateY( lbl.getTranslateY() - 10);
            					break;	
            				case DOWN:
            					lbl.setTranslateY( lbl.getTranslateY() + 10);
            					break;	
            			}
        				lbl.setStyle("-fx-background-color: LightGreen");
            		}
        });
        scene.setOnKeyReleased(
        	    new EventHandler<KeyEvent>() {
            		@Override public void handle(KeyEvent e) {
            			lbl.setStyle(("-fx-background-color: gainsboro"));
            		}
        });
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
