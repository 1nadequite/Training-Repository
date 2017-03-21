package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    public final static String NAME = "milk";
    public final static int PRICE = 1357;
    private int number;
    private double percent;
    private WeekDay day;

    public Purchase() {}

    public Purchase(int number, double percent, WeekDay day) {
        this.number = number;
        this.percent = percent;
        this.day = day;
    }

    public Purchase(int number, double percent, int day) {
        this(number, percent, WeekDay.values()[day]);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getDiscount() {
        return percent;
    }

    public void setDiscount(double percent) {
        this.percent = percent;
    }

    public WeekDay getDay() {
        return day;
    }

    public void setDay(WeekDay day) {
        this.day = day;
    }

    // calculating the rounded purchase cost
    public int getCost() {
        return (int) Math.round(PRICE * number * (100 - percent) / 100 / 100) * 100;
    }

    @Override
    public String toString() {
        return String.format("%d;%.2f;%s;%s", number, percent, day, Utility.toString(getCost()));
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number - purchase.number;
    }
}
