package executors;
import java.util.HashMap;
import java.util.TreeMap;

import by.gsu.epamlab.Purchase;

public class SimpleMapExecutor extends AbstractMapExecutor {
	public SimpleMapExecutor() {
		//HashMap alternative
		//requires hashCode() and equals()
		purchases = new HashMap<Purchase, Integer>();  

		//TreeMap alternative
		//ok if Purchase implements Comparable
		//purchases = new TreeMap<Purchase, Integer>();  
	}
	public void updateFrequency(Purchase purchase) {
		Integer freq = purchases.get(purchase);
		if(freq == null) {
			freq = 0;
		}
		purchases.put(purchase, freq + 1);
	}
}
