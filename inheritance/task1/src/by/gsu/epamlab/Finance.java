package by.gsu.epamlab;

public class Finance {
    private int coins;

    public Finance(int price) {
        this.coins = price;
    }

    public int getCoins() { return coins; }

    public void setCoins(int coins) { this.coins = coins; }

    public static String priceToString(int value) {
        return String.format("%d.%d%d", value / 100, value / 10 % 10, value % 10);
    }

    @Override
    public String toString() {
        return priceToString(coins);
    }
}
