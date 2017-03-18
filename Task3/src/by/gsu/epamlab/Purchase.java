package by.gsu.epamlab;

import java.util.Comparator;

public class Purchase implements Comparable<Purchase> {
    private final static String commodity = "milk";
    private final static int price = 1234;
    private int number;
    private int percent;
    private WeekDay week_day;

    public Purchase() {}

    public Purchase(int number, int percent, WeekDay week_day) {
        this.number = number;
        this.percent = percent;
        this.week_day = week_day;
    }

    public static String getCommodity() { return commodity; }

    public static int getPrice() { return price; }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDiscount() {
        return percent;
    }

    public void setDiscount(int percent) {
        this.percent = percent;
    }

    public WeekDay getWeek_day() {
        return week_day;
    }

    public void setWeek_day(WeekDay week_day) {
        this.week_day = week_day;
    }

    // calculating the purchase cost
    public int getCost() {
        return price * number * (100 - percent) / 100;
    }

    @Override
    public String toString() {
        return String.format("%d;%d;%d;%d.%d",
                number, percent, WeekDay.getId(week_day), getCost() / 100, getCost() % 100);
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number > purchase.number ? 1 : number == purchase.number ? 0 : -1;
    }
}
