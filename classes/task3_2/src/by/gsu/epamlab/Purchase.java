package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    public final static String name = "milk";
    public final static int price = 1357;
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

    public WeekDay getWeek_day() {
        return day;
    }

    public void setWeek_day(WeekDay day) {
        this.day = day;
    }

    // calculating the rounded purchase cost
    public int getCost() {
        double cost = price * number * (100 - percent) / 100;
        return (int) cost / 100 * 100;
    }

    @Override
    public String toString() {
        return String.format("%d;%.1f;%s;%s", number, percent, day, Utility.toString(getCost()));
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number - purchase.number;
    }
}
