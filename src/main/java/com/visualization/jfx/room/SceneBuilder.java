package com.visualization.jfx.room;

import java.util.Arrays;

import com.visualization.jfx.room.validation.EmptyValidator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SceneBuilder {

	public static Scene createInputScene(final SceneCompletedListener listener){
		
		final Scene scene = new Scene(new VBox(), 600, 500);
		
		final MenuBar bar = new MenuBar();
		final VBox vbox = (VBox)scene.getRoot();
		vbox.getChildren().add(bar);
		
		Menu menuComp = new Menu("Вычисления");
		MenuItem item = new MenuItem("Частичная неопределенность");
		menuComp.getItems().add(item);
		bar.getMenus().add(menuComp);
		
		final GridPane grid = new InputPaneBuilder(listener)
								.addListInput("Угол наблюдения", "15", 130, new EmptyValidator(), Arrays.asList("15", "30", "45", "60"))
								.addTextInput("Количество наблюдателей", "", 130, new EmptyValidator())
								.addTextInput("Минимальное расстояние между людьми", "", 130, new EmptyValidator())
								.addListInput("Метод рассадки должностных лиц", "Сетка", 130, new EmptyValidator(), Arrays.asList("Сетка", "Вокруг стола", "Зрительный зал"))
								.addListInput("Основные сценарии работы ", "Аналитика", 130, new EmptyValidator(), Arrays.asList("Аналитика", "Переговоры", "Доклад"))
								.addTextInput("Информационная емкость контента", "", 130, new EmptyValidator())								
								.build();
		vbox.getChildren().add(grid);
		//"Поле \"Количество наблюдателей\" должно быть целым числом"
		
		item.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(vbox.getChildren().size() > 1){
					vbox.getChildren().clear();
					vbox.getChildren().add(bar);
					vbox.getChildren().add(grid);
				}
			}
		});
		
		
		
	        /*GridPane grid = new GridPane();
	        grid.setAlignment(Pos.CENTER);
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(25, 25, 25, 25));

	        Text scenetitle = new Text("Welcome");
	        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	        grid.add(scenetitle, 0, 0, 2, 1);

	        Label userName = new Label("Размер помещения:");
	        grid.add(userName, 0, 1);

	        final TextField userTextField = new TextField();
	        int size = RoomContext.getContext().getRoomSize();
	        if(size > 0) { userTextField.setText("" + size); }
	        grid.add(userTextField, 1, 1);

	        Button btn = new Button("Рассчитать");
	        HBox hbBtn = new HBox(10);
	        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	        hbBtn.getChildren().add(btn);
	        grid.add(hbBtn, 1, 4);
	        
	        final Text actiontarget = new Text();
	        actiontarget.setFill(Color.FIREBRICK);
	        actiontarget.setVisible(false);
	        grid.add(actiontarget, 1, 6);
	        
	        btn.setOnAction(new EventHandler<ActionEvent>() {

	            @Override
	            public void handle(ActionEvent e) {
	            	String size = userTextField.getText();
	            	try{
	            		RoomContext.getContext().setRoomSize(Integer.parseInt(size));
	            		actiontarget.setVisible(true);
	            	}
	            	catch(NumberFormatException nfe){
	                    actiontarget.setText("Размер помещения должен быть целым положительным числом");
	                    actiontarget.setVisible(true);
	                    return;
	            	}
	                listener.onCompleted();
	            }
	        });*/
		
		
	        
	    return scene;
	}
	
	public static Scene createRoomVisualizationScene(final SceneCompletedListener listener){
		
		Pane canvas = new Pane();
		int size = RoomContext.getContext().getRoomSize();
		
		Button btn = new Button("Назад");
		btn.relocate(size - 20, size + 20);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                listener.onCompleted();
            }
        });
		
		canvas.setPrefSize(size + 100, size + 100);
		Rectangle rectangle = new Rectangle(size, size, Color.WHITE);
		rectangle.relocate(0, 0);
		rectangle.setStrokeWidth(2);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeType(StrokeType.INSIDE);
		canvas.getChildren().addAll(rectangle, btn);
	     
		
	    return new Scene(canvas);
	}
	
	
}
