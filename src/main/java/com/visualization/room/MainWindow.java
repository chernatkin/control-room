package com.visualization.room;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javafx.application.*;
import javax.swing.border.LineBorder;


public class MainWindow {

	public static void main(String[] args) {
		final JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setMinimumSize(new Dimension(500, 400));
        
        final RoomPanel panel = new RoomPanel();
        panel.setBorder(new LineBorder(Color.BLACK, 2));
        
        final InputPanel input = new InputPanel(new PanelCompletingListener() {
			
			@Override
			public void onComplete() {
				frame.getContentPane().removeAll();
				frame.getContentPane().add(panel);
				frame.revalidate();
			}
		});
        
        frame.getContentPane().removeAll();
        frame.getContentPane().add(input);
        
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        
	}

}
