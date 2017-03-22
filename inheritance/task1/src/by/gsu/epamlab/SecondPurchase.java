package by.gsu.epamlab;

import java.util.Scanner;

public class SecondPurchase extends Purchase {
    public final static int NUMBER_FOR_DISCOUNT = 5;
    private double discount;

    public SecondPurchase() {}

    public SecondPurchase(String name, int price, int number, double discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public SecondPurchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextDouble());
    }

    public double getDiscount() { return discount; }

    public void setDiscount(double discount) { this.discount = discount; }

    @Override
    public int getCost() {
        return (getNumber() > NUMBER_FOR_DISCOUNT) ?
                (int) (getPrice().getPrice() * getNumber() * (1 - discount / 100)) :
                super.getCost();
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%.3f", super.fieldsToString(), discount);
    }
}
