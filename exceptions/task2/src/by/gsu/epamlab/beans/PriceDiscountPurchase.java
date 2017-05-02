package by.gsu.epamlab.beans;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.exceptions.NonPositiveArgumentException;
import by.gsu.epamlab.exceptions.NumField;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase() {}

    public PriceDiscountPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        setDiscount(discount);
    }

    public PriceDiscountPurchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

    public Byn getDiscount() { return discount; }

    public void setDiscount(int discount) {
        if (discount >= getPrice().getRubs() * 100 + getPrice().getCoins()) {
            throw new IllegalArgumentException(Constants.ERROR_WRONG_DISCOUNT);
        }
        if(discount <= 0) {
            throw new NonPositiveArgumentException(discount, NumField.DISCOUNT);
        }
        this.discount = new Byn(discount);
    }

    @Override
    public Byn getCost() {
        return new Byn(getPrice()).sub(discount).mul(getNumber());
    }

    @Override
    protected String isDiscount() {
        return String.format("%s", discount);
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), discount);
    }
}