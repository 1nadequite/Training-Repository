package by.gsu.epamlab.beans;

import by.gsu.epamlab.WeekDay;

import java.util.Map;

public class EntryCheckerPurchaseAndWeekDay<T extends Purchase> implements EntryChecker {
    private T purchase;
    private WeekDay weekDay;
    private Byn cost;

    public EntryCheckerPurchaseAndWeekDay() {}

    public EntryCheckerPurchaseAndWeekDay(T purchase) {
        this(purchase, null, null);
    }

    public EntryCheckerPurchaseAndWeekDay(WeekDay weekDay) {
        this(null, weekDay, null);
    }

    public EntryCheckerPurchaseAndWeekDay(int cost) {
        this(new Byn(cost));
    }

    public EntryCheckerPurchaseAndWeekDay(Byn cost) {
        this(null, null, cost);
    }

    public EntryCheckerPurchaseAndWeekDay(T purchase, WeekDay weekDay, int cost) {
        this(purchase, weekDay, cost == 0 ? null : new Byn(cost));
    }

    public EntryCheckerPurchaseAndWeekDay(T purchase, WeekDay weekDay, Byn cost) {
        this.purchase = purchase;
        this.weekDay = weekDay;
        this.cost = cost;
    }

    public boolean check(Map.Entry<Purchase, WeekDay> entry) {
        Purchase purchase = entry.getKey();
        return (this.purchase == null || (checkName(purchase.getName()) && checkPrice(purchase.getPrice()) &&
                checkNumber(purchase.getNumber()))) &&
                checkDiscount(purchase) &&
                checkCost(purchase.getCost()) &&
                checkWeekDay(entry.getValue());
    }

    private boolean checkName(String name) {
        return purchase.getName() == null || purchase.getName().equals(name);
    }

    private boolean checkPrice(Byn price) {
        return purchase.getPrice() == null || purchase.getPrice().equals(price);
    }

    private boolean checkNumber(int number) {
        return purchase.getNumber() == 0 || purchase.getNumber() == number;
    }

    private boolean checkDiscount(Purchase purchase) {
        boolean matcher = true;
        if (this.purchase instanceof PricePurchase && purchase instanceof PricePurchase) {
            matcher = ((PricePurchase) this.purchase).getDiscount() == null ||
                    ((PricePurchase) this.purchase).getDiscount().equals(((PricePurchase) purchase).getDiscount());
        }
        return matcher;
    }

    private boolean checkCost(Byn cost) {
        return this.cost == null || this.cost.equals(cost);
    }

    private boolean checkWeekDay(WeekDay weekDay) {
        return this.weekDay == null || this.weekDay == weekDay;
    }
}
