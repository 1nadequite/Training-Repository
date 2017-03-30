package by.gsu.epamlab;

public class Commodity {
    private final String name;
    private final Byn price;

    public Commodity() {
        this(null, 0);
    }

    public Commodity(String name, int price) {
        this.name = name;
        this.price = new Byn(price);
    }

    public String getName() { return name; }

    public Byn getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("%s;%s", name, price);
    }
}
