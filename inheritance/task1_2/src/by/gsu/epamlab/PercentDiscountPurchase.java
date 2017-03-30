package by.gsu.epamlab;

import java.util.Scanner;

public class PercentDiscountPurchase extends Purchase {
    private final static int NUMBER_FOR_DISCOUNT = 5;
    private double percent;

    public PercentDiscountPurchase(String name, int price, int number, double percent) {
        super(name, price, number);
        this.percent = percent;
    }

    public PercentDiscountPurchase(Scanner sc) {
        super(sc);
        this.percent = sc.nextDouble();
    }

    @Override
    public Byn getCost() {
        Byn cost = super.getCost();
        if (getNumber() > NUMBER_FOR_DISCOUNT) {
            cost.mul(1 - percent / 100, RoundingType.ROUND);
        }
        return cost;
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%.3f", super.fieldsToString(), percent);
    }
}
