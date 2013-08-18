package com.visualization.jfx.room;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PaintApplication extends Application {

	public static void main(final String[] args) {
		launch(args);
	}	
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		 Pane canvas = new Pane();
	     //canvas.setStyle("-fx-background-color: black;");
	     canvas.setPrefSize(200, 200);
	     Circle circle = new Circle(50, Color.BLUE);
	     circle.relocate(20, 20);
	     Rectangle rectangle = new Rectangle(100, 100, Color.RED);
	     rectangle.relocate(70, 70);
	     canvas.getChildren().addAll(circle, rectangle);
	     
	     
		/*c.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				
			}
		});*/
		
		primaryStage.setScene(new Scene(canvas));
		primaryStage.show();
	}

}
