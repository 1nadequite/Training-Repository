package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    public final static String commodity = "milk";
    public final static int price = 1357;
    private int number;
    private int percent;
    private WeekDay week_day;

    public Purchase() {
    }

    public Purchase(int number, int percent, WeekDay week_day) {
        this.number = number;
        this.percent = percent;
        this.week_day = week_day;
    }

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

    // calculating the rounded purchase cost
    public int getCost() {
        int cost = price * number * (100 - percent) / 100;
        return ((cost % 100 > 50) ? cost + 100 : cost) / 100 * 100;
    }

    @Override
    public String toString() {
        return String.format("%d;%d;%d;%s",
                number, percent, week_day.getId(), priceToString(getCost()));
    }

    @Override
    public int compareTo(Purchase purchase) {
        return number > purchase.number ? 1 : number == purchase.number ? 0 : -1;
    }

    // format the price to string
    public static String priceToString(int value) {
        return String.format("%d.%d%d", value / 100, value / 10 % 10, value % 10);
    }

    // calculating and format the mean cost to string
    public static String meanCostToString(int value, int number) {
        return (number > 0) ? String.format("%s%d", priceToString(value / number), value % number) : "0.000";
    }
}
