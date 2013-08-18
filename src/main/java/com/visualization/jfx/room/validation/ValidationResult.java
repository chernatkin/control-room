package com.visualization.jfx.room.validation;

public class ValidationResult {

	private final boolean valid;
	
	private final String msg;

	public ValidationResult(boolean valid, String msg) {
		this.valid = valid;
		this.msg = msg;
	}

	public boolean isValid() {
		return valid;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
