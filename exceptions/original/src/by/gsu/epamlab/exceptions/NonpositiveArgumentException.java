package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.enums.NumField;

public class NonpositiveArgumentException extends IllegalArgumentException {

	private int value;

	private NumField field;

	public NonpositiveArgumentException() {
		super();
	}

	public NonpositiveArgumentException(int value, NumField field) {
		super();
		this.value = value;
		this.field = field;
	}

	public int getValue() {
		return value;
	}

	public String getHead() {
		return Constants.ERROR_EXCEPTION_NONPOSITIVE_HEAD;
	}

	public String toString() {
		return getHead() + value
				+ Constants.ERROR_EXCEPTION_NONPOSITIVE_BODY + field
				+ Constants.ERROR_EXCEPTION_NONPOSITIVE_FOOT;
	}
}
