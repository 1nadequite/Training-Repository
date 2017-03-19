package by.gsu.epamlab;

public class Utility {
    // format the price to string
    public static String toString(int value) {
        return String.format("%d.%d%d", value / 100, value / 10 % 10, value % 10);
    }
}
