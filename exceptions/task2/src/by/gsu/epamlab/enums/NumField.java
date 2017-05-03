package by.gsu.epamlab.enums;

public enum NumField {
    BYN("BYN"),
    COEF("coef"),
    PRICE("price"),
    NUMBER("number"),
    DISCOUNT("discount");

    private final String name;

    private NumField(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
