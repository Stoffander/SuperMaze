package application.controller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import static javafx.scene.input.KeyCode.DOWN;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class Space extends Application
{

    //create the panes to handle the game
    BorderPane mainPane = new BorderPane();
  
    Pane gameField = new Pane();
    Scene scene;
    //create circle/movement properties
    double increment = 5.0;
    double radius = 10;
    double x = radius, y = radius;
    //create Rectangle properties
    double Rwidth = 80;
    double Rheight = 20;
    //create player and objects
    Circle player = new Circle(x, y, radius);
    Rectangle r1 = new Rectangle(0, 100, Rwidth, Rheight);//Rectangle(int x, int y, int width, int height)

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        setPanes();
        gameField.getChildren().addAll(r1, player);
        moveCircleOnKeyPress(scene, player);//pass to player movement method

        //set the stage
        stage.setScene(scene);
        stage.show();
    }

    public void moveCircleOnKeyPress(Scene scene, Circle player)
    {//player movement
        scene.setOnKeyPressed((KeyEvent event) ->
        {
            switch (event.getCode())
            {
                case UP:
                    player.setCenterY(player.getCenterY() - increment);//move player
                    //if (player.getBoundsInLocal().intersects(r1.getBoundsInLocal()))
                    if (Shape.intersect(player, r1).getBoundsInLocal().getWidth() != -1)
                    {
                        player.setCenterY(player.getCenterY() + increment);
                    }
                    break;
                case RIGHT:
                    player.setCenterX(player.getCenterX() + increment);

                    if (Shape.intersect(player, r1).getBoundsInLocal().getWidth() != -1)
                    {
                        player.setCenterX(player.getCenterX() - increment);
                    }
                    break;
                case DOWN:
                    player.setCenterY(player.getCenterY() + increment);
                    if (Shape.intersect(player, r1).getBoundsInLocal().getWidth() != -1)
                    {
                        player.setCenterY(player.getCenterY() - increment);
                    }
                    break;
                case LEFT:
                    player.setCenterX(player.getCenterX() - increment);
                    if (Shape.intersect(player, r1).getBoundsInLocal().getWidth() != -1)
                    {
                        player.setCenterX(player.getCenterX() + increment);
                    }
                    break;
            }
        });
    }

    public void setPanes()
    {
       
        mainPane.setMaxSize(800, 800);
        mainPane.setCenter(gameField);//place the main game inside the center
        mainPane.setPadding(new Insets(10, 10, 10, 10));
        mainPane.setStyle("-fx-border-color: red");
        gameField.setStyle("-fx-background-color: white");
        gameField.setStyle("-fx-border-color: black");
        gameField.setMaxSize(600, 600);
        scene = new Scene(mainPane, 800, 800);
        player.setFill(Color.RED);

    }
}