package executors;
import java.util.TreeMap;
import java.util.Map;
import java.util.SortedMap;

import by.gsu.epamlab.Purchase;


public class SortedMapExecutor extends AbstractMapExecutor {
	public SortedMapExecutor() {
		//SortedMap alternative
		//ok if Purchase implements Comparable
		purchases = new TreeMap<Purchase, Integer>();  
	}
	public void updateFrequency(Purchase purchase) {
		SortedMap<Purchase, Integer> sortedPurchases = (SortedMap<Purchase, Integer>) purchases;
		SortedMap<Purchase, Integer> purchasesAfterFound = sortedPurchases.tailMap(purchase);
		if (purchasesAfterFound.isEmpty() || !purchase.equals(purchasesAfterFound.firstKey())) {
			purchases.put(purchase, 1);
		} else {
			Map.Entry<Purchase, Integer> entry = purchasesAfterFound
					.entrySet().iterator().next();
			entry.setValue(entry.getValue() + 1);
		}
	}
}
