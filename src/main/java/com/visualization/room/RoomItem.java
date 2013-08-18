package com.visualization.room;

import java.awt.Graphics2D;
import java.awt.Shape;

public class RoomItem {
	
	private String name;
	
	private Shape shape;
	
	private Graphics2D graphics;

	public RoomItem(String name, Shape shape, Graphics2D graphics) {
		super();
		this.name = name;
		this.shape = shape;
		this.graphics = graphics;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Graphics2D getGraphics() {
		return graphics;
	}

	public void setGraphics(Graphics2D graphics) {
		this.graphics = graphics;
	}
	

	
}
