package by.gsu.epamlab.exceptions;

import by.gsu.epamlab.Constants;

public enum NumField {
    PRICE(Constants.PRICE),
    NUMBER(Constants.NUMBER),
    DISCOUNT(Constants.DISCOUNT);

    private final String name;

    private NumField(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "in " + name.toLowerCase();
    }
}
