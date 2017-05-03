import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.beans.PurchasesList;
import by.gsu.epamlab.comparators.PurchaseComparatorBuilder;

public class Runner {

	private static void printList(PurchasesList list, String header) {
		System.out.println(header);
		System.out.println(list.toTable());
		System.out.println();
	}

	private static void deleteItem(int index, PurchasesList purchases) {
		if (purchases.isIndexCorrect(index)) {
			purchases.delete(index);
		}
	}

	private static void findAndShow(PurchasesList main, PurchasesList addon,
			int index) {
		Purchase purchase = addon.getPurchases().get(index);
		int position = main.binarySearch(purchase);
		System.out.print("Purchase " + purchase);
		if (position < 0) {
			System.out.println(" isn't found");
		} else {
			System.out.println(" is found at position " + position);
		}
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

			mainList.insert(
					0,
					addonList.getPurchases().get(
							addonList.getPurchases().size() - 1));
			mainList.insert(1000, addonList.getPurchases().get(0));
			mainList.insert(2, addonList.getPurchases().get(2));

			deleteItem(3, mainList);
			deleteItem(10, mainList);
			deleteItem(-5, mainList);

			printList(mainList, "before sorting");

			mainList.sort();
			printList(mainList, "after sorting");

			findAndShow(mainList, addonList, 1);
			findAndShow(mainList, addonList, 3);
		}
	}
}
