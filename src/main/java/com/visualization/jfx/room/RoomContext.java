package com.visualization.jfx.room;

public class RoomContext {

	private static final RoomContext ctx = new RoomContext();
	
	private int roomSize;
	
	private RoomContext() {
	}

	public static RoomContext getContext() {
		return ctx;
	}

	public int getRoomSize() {
		return roomSize;
	}

	public void setRoomSize(int roomSize) {
		this.roomSize = roomSize;
	}

	
	
}
