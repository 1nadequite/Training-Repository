package executors;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import by.gsu.epamlab.Purchase;


public class NavigableMapExecutor extends AbstractMapExecutor {
	public NavigableMapExecutor() {
		//NavigableMap alternative
		//ok if Purchase implements Comparable
		purchases = new TreeMap<Purchase, Integer>();  
	}
	public void updateFrequency(Purchase purchase) {
		NavigableMap<Purchase, Integer> navigablePurchases = (NavigableMap<Purchase, Integer>) purchases;
		Map.Entry<Purchase, Integer> entryAfterFound = navigablePurchases.floorEntry(purchase);
		int setValue = 0;
		if (entryAfterFound != null && purchase.equals(entryAfterFound.getKey())) {
			setValue = entryAfterFound.getValue();
		}
		purchases.put(purchase, setValue + 1);
	}
}
