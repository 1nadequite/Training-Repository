package by.gsu.epamlab.comparators;

public class PurchaseComparatorBuilder {
	private static AbstractPurchaseComparator purchaseComparator;

	private PurchaseComparatorBuilder() {
	}

	public static AbstractPurchaseComparator getPurchaseComparator() {
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
			//use default class independently on exception 
			purchaseComparator = new PurchaseComparatorV1();
		}
	}
}
