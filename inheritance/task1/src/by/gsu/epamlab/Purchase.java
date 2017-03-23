package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase {
    private String name;
    private Finance price;
    private int number;

    public Purchase() {}

    public Purchase(String name, int price, int number) {
        this.name = name;
        this.price = new Finance(price);
        this.number = number;
    }

    public Purchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt());
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Finance getPrice() { return price; }

    public void setPrice(Finance price) { this.price = price; }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public int getCost() {
        return price.getCoins() * number;
    }

    protected String fieldsToString() {
        return String.format("%s;%s;%d", name, price, number);
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fieldsToString(), Finance.priceToString(getCost()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return (name.equals(purchase.name) && price.getCoins() == purchase.price.getCoins());
    }
}
