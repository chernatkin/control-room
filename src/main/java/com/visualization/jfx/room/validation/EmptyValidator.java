package com.visualization.jfx.room.validation;


public class EmptyValidator implements Validator {

	@Override
	public ValidationResult validate(String value) {
		return new ValidationResult(false, "Ok");
	}

}
