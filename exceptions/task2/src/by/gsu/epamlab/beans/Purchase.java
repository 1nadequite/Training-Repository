package by.gsu.epamlab.beans;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.enums.NumField;
import by.gsu.epamlab.exceptions.NonPositiveArgumentException;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() { throw new IllegalArgumentException(Constants.ERROR_NULL_NAME); }

    public Purchase(String name, Byn price, int number) {
        setName(name);
        setPrice(price);
        setNumber(number);
    }

    public Purchase(String name, int price, int number) {
        setName(name);
        setPrice(price);
        setNumber(number);
    }

    public String getName() { return name; }

    public void setName(String name) {
        if(name == null) {
            throw new IllegalArgumentException(Constants.ERROR_NULL_NAME);
        }
        if("".equals(name)) {
            throw new IllegalArgumentException(Constants.ERROR_EMPTY_NAME);
        }
        this.name = name;
    }

    public Byn getPrice() { return price; }

    public void setPrice(Byn price) {
        if (price.equals(new Byn())) {
            throw new NonPositiveArgumentException(0, NumField.PRICE);
        }
        this.price = price;
    }

    public void setPrice(int price) {
        checkPositive(price, NumField.PRICE);
        setPrice(new Byn(price));
    }

    public int getNumber() { return number; }

    public void setNumber(int number) {
        checkPositive(number, NumField.NUMBER);
        this.number = number;
    }

    protected void checkPositive(int value, NumField numField) {
        if (value <= 0) {
            throw new NonPositiveArgumentException(value, numField);
        }
    }

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    protected String fieldsToString() {
        return name + Constants.SEPARATOR + price + Constants.SEPARATOR + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + Constants.SEPARATOR + getCost();
    }
}