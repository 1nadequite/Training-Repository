package by.gsu.epamlab;

public class Finance {
    private int price;

    public Finance(int price) {
        this.price = price;
    }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }

    public static String priceToString(int value) {
        return String.format("%d.%d%d", value / 100, value / 10 % 10, value % 10);
    }

    @Override
    public String toString() {
        return priceToString(price);
    }
}
