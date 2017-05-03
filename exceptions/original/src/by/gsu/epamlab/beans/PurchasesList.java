package by.gsu.epamlab.beans;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.comparators.AbstractPurchaseComparator;
import by.gsu.epamlab.comparators.PurchaseComparatorBuilder;
import by.gsu.epamlab.enums.Column;
import by.gsu.epamlab.exceptions.CsvLineException;
import by.gsu.epamlab.factories.PurchasesFactory;

public class PurchasesList {
	private List<Purchase> purchases;

	private boolean ordered;

	private final static AbstractPurchaseComparator PURCHASE_COMPARATOR = PurchaseComparatorBuilder.getPurchaseComparator();

	public PurchasesList() {
		setPurchases(new ArrayList<Purchase>());
		ordered = true;
	}

	public PurchasesList(String filename) {
		this();
		final String PACKAGE = "src/";
		final String EXT = ".csv";
		ordered = false;
		Scanner scr = null;
		try {
			scr = new Scanner(new FileReader(PACKAGE + filename + EXT));

			while (scr.hasNext()) {
				try {
					Purchase purchase = PurchasesFactory
							.getClassFromFactory(scr.nextLine());
					purchases.add(purchase);
				} catch (CsvLineException e) {
					System.out.println(e);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println(Constants.ERROR_FILE_PROC_HEAD + PACKAGE
					+ filename + EXT + Constants.ERROR_FILE_PROC_FOOT);
			// create empty collection if there is an error of file processing
			setPurchases(new ArrayList<Purchase>());
			ordered = true;
		} finally {
			if (scr != null) {
				scr.close();
			}
		}

	}

	public void setPurchases(List<Purchase> purchases) {
		if (purchases == null) {
			throw new NullPointerException();
		}
		this.purchases = purchases;
		ordered = false;
	}

	public List<Purchase> getPurchases() {
		ordered = false;
		return purchases;
	}

	public void insert(int index, Purchase purchase) {
		if (index < 0) {
			index = 0;
		}
		if (index > purchases.size()) {
			index = purchases.size();
		}
		purchases.add(index, purchase);
		ordered = false;
	}

	public boolean isIndexCorrect(int index) {
		return index >= 0 && index < purchases.size();
	}

	public int delete(int index) {
		purchases.remove(index);
		return index;
	}

	public Byn getTotalCost() {
		Byn total = new Byn();
		for (Purchase purchase : purchases) {
			total.add(purchase.getCost());
		}
		return total;
	}

	public String toTable() {
		StringBuilder table = new StringBuilder();
		table.append(Column.getHeader()).append('\n');
		table.append(Column.HORIZONTAL_LINE).append('\n');
		for (Purchase purchase : purchases) {
			table.append(Column.getRow(purchase.toString())).append('\n');
		}
		table.append(Column.HORIZONTAL_LINE).append('\n');
		table.append(Column.getFooter(getTotalCost())).append('\n');
		return table.toString();
	}

	public void sort() {
		Collections.sort(purchases, PURCHASE_COMPARATOR);
		ordered = true;
	}

	public int binarySearch(Purchase purchase) {
		if (!ordered) {
			sort();
		}
		return Collections.binarySearch(purchases, purchase,
				PURCHASE_COMPARATOR);
	}
}
