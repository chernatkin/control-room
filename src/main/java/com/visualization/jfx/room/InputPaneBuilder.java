package com.visualization.jfx.room;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.LimitExceededException;

import com.visualization.jfx.room.validation.ValidationResult;
import com.visualization.jfx.room.validation.Validator;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class InputPaneBuilder {

	private final SceneCompletedListener listener;
	
	private final GridPane grid;
	
	private int maxRow = 0;
	
	private final Map<TextField, Validator> textFields = new HashMap<TextField, Validator>();
	
	private final Map<ComboBox<String>, Validator> comboBoxes = new HashMap<ComboBox<String>, Validator>();
	
	public InputPaneBuilder(final SceneCompletedListener listener) {
		this.listener = listener;
		this.grid = new GridPane();
		grid.setAlignment(Pos.BOTTOM_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Введите параметры");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, maxRow++, 2, 1);
	}

	public InputPaneBuilder addTextInput(String labelText, String initalValue, int length, Validator validator){
		final int row = addRow(labelText);
        
        final TextField textField = new TextField(initalValue == null ? "" : initalValue);
        textField.setMaxWidth(length);
        grid.add(textField, 1, row);
        
        textFields.put(textField, validator);
		return this;
	}
	
	public InputPaneBuilder addListInput(String labelText, String initalValue, int length, Validator validator, List<String> values){
		final int row = addRow(labelText);
		
		final ComboBox<String> combo = new ComboBox<String>(FXCollections.observableArrayList(values));
		combo.setValue(initalValue);
		combo.setMaxWidth(length);
		grid.add(combo, 1, row);
		
		comboBoxes.put(combo, validator);
		return this;
	}
	
	protected int addRow(String labelText){
		final int row = maxRow++;
		
		final Label label = new Label(labelText);
		label.setMaxWidth(250);
		label.setMinWidth(250);
        grid.add(label, 0, row);
        
        return row;
	} 
	
	public GridPane build(){
		
		final TextArea actiontarget = new TextArea();
        actiontarget.setStyle("-fx-text-fill: red; -fx-background-color:transparent;");
        actiontarget.setVisible(false);
        actiontarget.setWrapText(true);
        actiontarget.setEditable(false);
        
        grid.add(actiontarget, 0, maxRow++, 2, 1);
		
		Button btn = new Button("Рассчитать");
		btn.setAlignment(Pos.BOTTOM_LEFT);
        HBox hbBtn = new HBox(2);
        hbBtn.setMaxWidth(390);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 0, maxRow++, 2, 1);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
            	
            	boolean valid = true;
            	final StringBuilder msgs = new StringBuilder();
            	for(Map.Entry<TextField, Validator> validationEntry: textFields.entrySet()){
            		ValidationResult result = validationEntry.getValue().validate(validationEntry.getKey().getText());
            		if(!result.isValid()){
            			valid = false;
            			msgs.append(result.getMsg()).append("\n");
            		}
            	}
            	
            	for(Map.Entry<ComboBox<String>, Validator> validationEntry: comboBoxes.entrySet()){
            		ValidationResult result = validationEntry.getValue().validate(validationEntry.getKey().getValue());
            		if(!result.isValid()){
            			valid = false;
            			msgs.append(result.getMsg()).append("\n");
            		}
            	}
            	
            	actiontarget.setVisible(!valid);
            	if(valid){
            		listener.onCompleted();
            	}
            	else{
            		actiontarget.setText(msgs.toString());
            	}
            }
        });
		return grid;
	}
	
}
