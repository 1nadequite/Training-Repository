package by.gsu.epamlab.comparators;

import by.gsu.epamlab.Purchase;

import java.util.Comparator;

public class PurchaseComparatorV2<T> implements Comparator<Purchase> {
    public int compare(Purchase purchase1, Purchase purchase2) {
        if (purchase1.getName().equals(purchase2.getName())) {
            if (purchase1.getClass() == purchase2.getClass()) {
                return purchase1.getCost().compareTo(purchase2.getCost());
            } else {
                if (purchase1.getClass() == Purchase.class) {
                    return -1;
                } else {
                    return 1;
                }
            }
        }
        return purchase1.getName().compareTo(purchase2.getName());
    }
}