package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.Constants;

public class NonPositiveArgumentException extends IllegalArgumentException {
    private NumField field;
    private int nonPositiveValue;

    public NonPositiveArgumentException() {}

    public NonPositiveArgumentException(int nonPositiveValue, NumField field) {
        this.nonPositiveValue = nonPositiveValue;
        this.field = field;
    }

    @Override
    public String getMessage() {
        return String.format("%s %d %s", Constants.ERROR_NON_POSITIVE_VALUE, nonPositiveValue, field);
    }
}
