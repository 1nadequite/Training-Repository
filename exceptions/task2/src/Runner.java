import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.beans.PurchasesList;
import by.gsu.epamlab.comparators.PurchaseComparatorBuilder;

public class Runner {
    private static void printList(PurchasesList purchases, String title) {
        System.out.println(title);
        System.out.println(purchases.toTable());
        System.out.println();
    }

    private static void deleteItem(PurchasesList purchases, int index) {
        if (purchases.isIndexCorrect(index)) {
            purchases.delete(index);
        }
    }

    private static void searchResult(PurchasesList main, PurchasesList addon, int index) {
        Purchase purchase = addon.getPurchases().get(index);
        int position = main.binarySearch(purchase);
        System.out.printf("Purchase %s is%s\n", purchase,
                (position < 0) ? "n't found" : " found at position " + position);
    }

    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("command line: java Runner main additional comparator");
        } else {
            final int MAIN = 0;
            final int ADDITIONAL = 1;
            final int COMPARATOR = 2;
            PurchaseComparatorBuilder.buildPurchaseComparator(args[COMPARATOR]);

            final PurchasesList mainList = new PurchasesList(args[MAIN]);

            printList(mainList, "after creation");

            final PurchasesList addonList = new PurchasesList(args[ADDITIONAL]);

            mainList.insert(0, addonList.getPurchases().get(addonList.getPurchases().size() - 1));
            mainList.insert(1000, addonList.getPurchases().get(0));
            mainList.insert(2, addonList.getPurchases().get(2));
            deleteItem(mainList, 3);
            deleteItem(mainList, 10);
            deleteItem(mainList, -5);

            printList(mainList, "before sorting");

            mainList.sort();

            printList(mainList, "after sorting");

            searchResult(mainList, addonList, 1);
            searchResult(mainList, addonList, 0);
        }
    }
}