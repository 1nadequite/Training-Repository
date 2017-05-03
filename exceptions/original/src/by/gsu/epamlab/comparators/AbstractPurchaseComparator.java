package by.gsu.epamlab.comparators;

import java.util.Comparator;

import by.gsu.epamlab.beans.PriceDiscountPurchase;
import by.gsu.epamlab.beans.Purchase;

public abstract class AbstractPurchaseComparator implements Comparator<Purchase> {
	private static enum Sign {
		EQUAL,
		MORE;
	}

	private int getRank(Purchase p) {
		return isSubPurchase(p) ? Sign.MORE.ordinal() : Sign.EQUAL.ordinal();
	}
	
	protected abstract boolean isSubPurchase(Purchase p);

	public int compare(Purchase p0, Purchase p1) {
		int c = p0.getName().compareTo(p1.getName());
		if (c != 0) {
			return c;
		}
		c = getRank(p0) - getRank(p1);  
		if (c != 0) {
			return c;
		}
		return p0.getCost().compareTo(p1.getCost());
	} 

}
