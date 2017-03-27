package by.gsu.epamlab;

public class Commodity {
    private String name;
    private Byn price;

    public Commodity() {}

    public Commodity(String name, int price) {
        this.name = name;
        this.price = new Byn(price);
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Byn getPrice() { return price; }

    public void setPrice(Byn price) { this.price = price; }

    @Override
    public String toString() {
        return String.format("%s;%s", name, price);
    }
}
