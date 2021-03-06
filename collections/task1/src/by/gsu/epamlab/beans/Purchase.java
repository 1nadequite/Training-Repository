package by.gsu.epamlab.beans;

public class Purchase {
    private String name;
    private Byn price;
    private int number;

    public Purchase() {}

    public Purchase(String name) {
        this(name, null, 0);
    }

    public Purchase(String name, int price, int number) {
        this(name, price == 0 ? null : new Byn(price), number);
    }

    public Purchase(String name, Byn price, int number) {
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Byn getPrice() { return price; }

    public void setPrice(Byn price) { this.price = price; }

    public int getNumber() { return number; }

    public void setNumber(int number) { this.number = number; }

    public Byn getCost() {
        return new Byn(price).mul(number);
    }

    protected String fieldsToString() {
        return String.format("%s;%s;%d", name, price, number);
    }

    @Override
    public String toString() {
        return String.format("%s;%s", fieldsToString(), getCost());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + name.hashCode();
        result = prime * result + price.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Purchase)) return false;
        Purchase purchase = (Purchase) obj;
        return (name.equals(purchase.name) && price.equals(purchase.price));
    }
}