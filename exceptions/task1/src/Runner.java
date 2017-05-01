import by.gsu.epamlab.Constants;
import by.gsu.epamlab.PurchasesList;
import by.gsu.epamlab.Utilits;

import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {
        PurchasesList purchasesList1 = new PurchasesList(Utilits.createFilePath(args[0]));
        Comparator comparator = Utilits.getComparator(args[2]);

        System.out.println();
        System.out.println("after creation");
        purchasesList1.printInTable();

        PurchasesList purchasesList2 = new PurchasesList(Utilits.createFilePath(args[1]));

        purchasesList1.addByIndex(0, purchasesList2.getPurchaseByIndex(purchasesList2.getSize() - 1));
        purchasesList1.addByIndex(1000, purchasesList2.getPurchaseByIndex(0));
        purchasesList1.addByIndex(2, purchasesList2.getPurchaseByIndex(2));
        purchasesList1.removeByIndex(3);
        purchasesList1.removeByIndex(10);
        purchasesList1.removeByIndex(-5);

        System.out.println();
        System.out.println("before sorting");
        purchasesList1.printInTable();

        purchasesList1.sortPurchase(comparator);

        System.out.println();
        System.out.println("after sorting");
        purchasesList1.printInTable();

        System.out.println();
        int index = purchasesList1.findPurchase(purchasesList2.getPurchases().get(1), comparator);
        System.out.printf("Purchase %s is%s\n", purchasesList2.getPurchases().get(1),
                (index < 0) ? "n't found" : " found at position " + index);

        index = purchasesList1.findPurchase(purchasesList2.getPurchases().get(0), comparator);
        System.out.printf("Purchase %s is%s\n", purchasesList2.getPurchases().get(0),
                (index < 0) ? "n't found" : " found at position " + index);
    }
}