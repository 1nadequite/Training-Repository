import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Scanner;

import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

class SetRunner {
	public static void main(String[] args) {
		Scanner scan = null;
		Purchase purchase;
		List<Purchase> purchases = new ArrayList<Purchase>(); 
		try {
			scan = new Scanner(new FileReader("src/in.txt"));
			while (scan.hasNext()) {
				purchase = PurchasesFactory.getClassFromFactory(scan);
				System.out.println(purchase);
				purchases.add(purchase);
			}

//requires hashCode() and equals() 
			Set<Purchase> purchasesSet = new HashSet<Purchase>(purchases); 

//ok if Purchase implements Comparable 
			//Set<Purchase> purchasesSet = new TreeSet<Purchase>(purchases); 

			System.out.println("purchases frequencies:");
			for (Purchase p : purchasesSet) {
				System.out.println(p.toEqualityString() + " --- " + Collections.frequency(purchases, p));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
