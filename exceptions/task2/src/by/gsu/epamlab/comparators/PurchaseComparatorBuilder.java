package by.gsu.epamlab.comparators;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.comparators.AbstractPurchaseComparator;
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
        Class<AbstractPurchaseComparator> compClass;
        final String FULL_COMPARATOR_NAME =
                PurchaseComparatorBuilder.class.getPackage().getName() + "." + comparatorName;
        try {
            compClass = (Class<AbstractPurchaseComparator>) Class.forName(FULL_COMPARATOR_NAME);
            purchaseComparator = compClass.newInstance();
        } catch (Exception e) {
            purchaseComparator = new PurchaseComparatorV1();
        }
    }
}

