package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.enums.NumField;

public class NegativeArgumentException extends NonPositiveArgumentException {
	public NegativeArgumentException() {}

	public NegativeArgumentException(int value, NumField field) {
		super(value, field);
	}

	public String getHead() {
		return Constants.ERROR_EXCEPTION_NEGATIVE_HEAD;
	}
}
