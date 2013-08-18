package com.visualization.jfx.room;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RoomApplication extends Application{

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("Рассчет параметров ситуационного зала");
        
		final SceneCompletedListener listener = new SceneCompletedListener() {
			
			private final SceneCompletedListener parent = this;
			
			@Override
			public void onCompleted() {
				primaryStage.setScene(SceneBuilder.createRoomVisualizationScene(new SceneCompletedListener() {
					
					@Override
					public void onCompleted() {
						primaryStage.setScene(SceneBuilder.createInputScene(parent));
					}
				}));
			}
		};
		
        primaryStage.setScene(SceneBuilder.createInputScene(listener));
        primaryStage.show();
	}

}
