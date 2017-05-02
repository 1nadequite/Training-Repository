import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.beans.PurchaseComparatorBuilder;
import by.gsu.epamlab.beans.PurchasesList;
import by.gsu.epamlab.Utilits;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.Comparator;

public class Runner {
    private static void printPurchases(String title, String table) {
        System.out.println(title);
        System.out.println(table);
    }

    private static void removePurchase(PurchasesList purchasesList, int index) {
        try {
            purchasesList.delete(index);
        } catch (IndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void searchResult(PurchasesList purchasesList, Purchase purchase) {
        try {
            int index = purchasesList.binarySearch(purchase);
            System.out.printf("Purchase %s is%s\n", purchase,
                    (index < 0) ? "n't found" : " found at position " + index);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        PurchaseComparatorBuilder.buildPurchaseComparator(args[2]);

        PurchasesList purchasesList1 = new PurchasesList(args[0]);

        printPurchases("after creation", purchasesList1.toTable());

        PurchasesList purchasesList2 = new PurchasesList(args[1]);

        purchasesList1.insert(0, purchasesList2.getPurchases().get(4));
        purchasesList1.insert(1000, purchasesList2.getPurchases().get(0));
        purchasesList1.insert(2, purchasesList2.getPurchases().get(2));
        removePurchase(purchasesList1, 3);
        removePurchase(purchasesList1, 10);
        removePurchase(purchasesList1, -5);

        printPurchases("before sorting", purchasesList1.toTable());

        purchasesList1.sort();

        printPurchases("after sorting", purchasesList1.toTable());

        searchResult(purchasesList1, purchasesList2.getPurchases().get(1));
        searchResult(purchasesList1, purchasesList2.getPurchases().get(0));
    }
}