package by.gsu.epamlab.beans;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.comparators.PurchaseComparatorV1;

import java.util.Comparator;

public class PurchaseComparatorBuilder {
    private static Comparator<Purchase> purchaseComparator;

    private PurchaseComparatorBuilder() {}

    public static Comparator<Purchase> getPurchaseComparator() {
        return purchaseComparator;
    }

    public static void buildPurchaseComparator(String comparatorName) {
        if(purchaseComparator != null) {
            return;
        }
        try {
            Class cls = Class.forName(Constants.COMPARATOR_PATH + comparatorName);
            purchaseComparator = (Comparator) cls.newInstance();
        } catch (Exception e) {
            purchaseComparator = new PurchaseComparatorV1<>();
        }
    }
}

