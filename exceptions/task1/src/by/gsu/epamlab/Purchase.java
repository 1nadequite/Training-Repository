package by.gsu.epamlab;

import java.util.Scanner;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() {}

    public Purchase(String name, int price, int number) {
        setName(name);
        setPrice(price);
        setNumber(number);
    }

    public Purchase(Scanner sc) {
        this(sc.next(), sc.nextInt(), sc.nextInt());
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

    public void setPrice(int price) {
        if(price <= 0) {
            throw new IllegalArgumentException(String.format("%s %d %s", Constants.ERROR_NON_POSITIVE_VALUE,
                    price, Constants.IN_PRICE));
        }
        this.price = new Byn(price);
    }

    public int getNumber() { return number; }

    public void setNumber(int number) {
        if(number <= 0) {
            throw new IllegalArgumentException(String.format("%s %d %s", Constants.ERROR_NON_POSITIVE_VALUE,
                    number, Constants.IN_NUMBER));
        }
        this.number = number;
    }

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    protected String isDiscount() {
        return Constants.WITHOUT_DISCOUNT;
    }

    public String getTableView() {
        return String.format("%-10s %10s %10d %10s %10s", name, price, number, isDiscount(), getCost());
    }

    protected String fieldsToString() {
        return String.format("%s;%s;%d", name, price, number);
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fieldsToString(), getCost());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return (name.equals(purchase.name) && price.equals(purchase.price) && number == purchase.number);
    }
}