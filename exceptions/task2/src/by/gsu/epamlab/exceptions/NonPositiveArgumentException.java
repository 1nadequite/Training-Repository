package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.enums.NumField;

public class NonPositiveArgumentException extends IllegalArgumentException {
    private NumField field;
    private int value;

    public NonPositiveArgumentException() {}

    public NonPositiveArgumentException(int value, NumField field) {
        this.value = value;
        this.field = field;
    }

    public int getValue() {
        return value;
    }

    public String getHead() {
        return Constants.ERROR_EXCEPTION_NONPOSITIVE_HEAD;
    }

    @Override
    public String getMessage() {
        return getHead() + value
                + Constants.ERROR_EXCEPTION_NONPOSITIVE_BODY + field
                + Constants.ERROR_EXCEPTION_NONPOSITIVE_FOOT;
    }
}
