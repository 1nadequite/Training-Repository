package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() {}

    public Purchase(String name, int price, int number) {
        this.name = name;
        this.price = new Byn(price);
        this.number = number;
    }

    public Purchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt());
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Byn getPrice() { return price; }

    public void setPrice(Byn price) { this.price = price; }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public Byn getCost() {
        Byn cost = new Byn(price);
        return cost.mul(number);
    }

    protected String fieldsToString() {
        return String.format("%s;%s;%d", name, price, number);
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fieldsToString(), getCost());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Purchase)) return false;
        Purchase purchase = (Purchase) obj;
        return (name.equals(purchase.name) && price.equals(purchase.price));
    }
}
