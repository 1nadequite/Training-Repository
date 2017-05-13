package executors;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Scanner;

import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.PurchasesFactory;

public abstract class AbstractMapExecutor {
	protected Map<Purchase, Integer> purchases;
	public AbstractMapExecutor() {
	}
	public void execute() {
		Scanner scan = null;
		Purchase purchase;
		try {
			scan = new Scanner(new FileReader("src/in.txt"));
			while (scan.hasNext()) {
				purchase = PurchasesFactory.getClassFromFactory(scan);
				System.out.println(purchase);
				updateFrequency(purchase);
			}
			print();
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found!");
		}
	}
	public abstract void updateFrequency(Purchase purchase);
	private void print() {
		System.out.println("purchases map:");
		for (Map.Entry<Purchase, Integer> entry : purchases.entrySet()) {
			System.out.println(entry.getKey().toEqualityString() + " --- " + entry.getValue());
		}
	}
}
