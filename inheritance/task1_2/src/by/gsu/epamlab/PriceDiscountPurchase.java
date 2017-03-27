package by.gsu.epamlab;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase {
    private Byn discount;

    public PriceDiscountPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = new Byn(discount);
    }

    public PriceDiscountPurchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        return cost.sub(new Byn(discount).mul(getNumber()));
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%s", super.fieldsToString(), discount);
    }
}