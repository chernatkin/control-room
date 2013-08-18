package com.visualization.room;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class RoomPanel extends JPanel {

	private Rectangle room = new Rectangle(10, 10, 250, 250);
	
	private List<RoomItem> items = new ArrayList<RoomItem>();
	
	@Override
	protected void paintComponent(final Graphics g) {
		super.paintComponent(g);
		
		final Graphics2D g2 = ((Graphics2D) g.create());
		g2.draw(room);
		g2.clip(room);
		
		final Shape table = new Ellipse2D.Double(100, 100, 50, 75);
		final Graphics2D tableG = ((Graphics2D) g2.create());
		tableG.setColor(Color.CYAN);
		tableG.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		tableG.fill(table);
		
		tableG.draw(table);
		tableG.clip(table);
		items.add(new RoomItem("table", table, tableG));
		
		
		
	}
	
	
	
}
