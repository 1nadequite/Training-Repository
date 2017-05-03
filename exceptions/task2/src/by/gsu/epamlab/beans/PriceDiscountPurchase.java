package by.gsu.epamlab.beans;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.enums.NumField;
import by.gsu.epamlab.exceptions.NonPositiveArgumentException;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase() {}

    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        setDiscount(discount);
    }

    public PriceDiscountPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        setDiscount(discount);
    }

    public Byn getDiscount() { return discount; }

    public void setDiscount(Byn discount) {
        if (discount.equals(new Byn())) {
            throw new NonPositiveArgumentException(0, NumField.DISCOUNT);
        }
        this.discount = discount;
        if (this.discount.compareTo(getPrice()) >= 0) {
            throw new IllegalArgumentException(
                    Constants.ERROR_WRONG_DISCOUNT);
        }
    }

    public void setDiscount(int discount) {
        checkPositive(discount, NumField.DISCOUNT);
        setDiscount(new Byn(discount));
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(new Byn(discount).mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString() + Constants.SEPARATOR + discount;
    }
}