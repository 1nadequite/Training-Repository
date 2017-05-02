package by.gsu.epamlab.comparators;

import by.gsu.epamlab.beans.PriceDiscountPurchase;
import by.gsu.epamlab.beans.Purchase;

import java.util.Comparator;

public class PurchaseComparatorV1<T> implements Comparator<Purchase> {
    public int compare(Purchase purchase1, Purchase purchase2) {
        if (purchase1.getName().equals(purchase2.getName())) {
            if (isInstanceOfDiscount(purchase1)) {
                if (isInstanceOfDiscount(purchase2)) {
                    return purchase1.getCost().compareTo(purchase2.getCost());
                }
                return 1;
            }
            return -1;
        }
        return purchase1.getName().compareTo(purchase2.getName());
    }

    private boolean isInstanceOfDiscount(Purchase purchase) {
        return (purchase instanceof PriceDiscountPurchase);
    }
}