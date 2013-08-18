package com.visualization.room;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InputPanel extends JPanel {

	private final PanelCompletingListener completeListener;
	
	public InputPanel(final PanelCompletingListener completeListener) {
		this.completeListener = completeListener;
		
		JButton next = new JButton();
		next.setText("Next");
		
		add(next);
		
		next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				completeListener.onComplete();
			}
		});
	}

	
	
}
