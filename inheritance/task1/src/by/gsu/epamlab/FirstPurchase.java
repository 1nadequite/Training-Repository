package by.gsu.epamlab;

import java.util.Scanner;

public class FirstPurchase extends Purchase {
    private int discount;

    public FirstPurchase() {}

    public FirstPurchase(String name, int price, int number, int discount) {
        super(name, price, number);
        this.discount = discount;
    }

    public FirstPurchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
    }

    public int getDiscount() { return discount; }

    public void setDiscount(int discount) { this.discount = discount; }

    @Override
    public int getCost() {
        return (getPrice().getPrice() - discount) * getNumber();
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s;%d", super.fieldsToString(), discount);
    }
}
