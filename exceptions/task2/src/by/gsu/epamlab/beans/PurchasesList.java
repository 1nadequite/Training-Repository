package by.gsu.epamlab.beans;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.Utilits;
import by.gsu.epamlab.exceptions.CsvLineException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchasesList {
    private List<Purchase> purchases;
    private Byn totalCost;
    private final static Comparator<Purchase> comparator = PurchaseComparatorBuilder.getPurchaseComparator();
    private boolean isSorted;

    public PurchasesList() {
        this.purchases = new ArrayList<Purchase>();
        this.totalCost = new Byn(0);
        this.isSorted = false;
    }

    public PurchasesList(String fileName) {
        this();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(Utilits.createFilePath(fileName)));
            while(sc.hasNext()) {
                try {
                    Purchase purchase = PurchasesFactory.getPurchaseFromFactory(sc);
                    purchases.add(purchase);
                    totalCost.add(purchase.getCost());
                } catch (CsvLineException e) {
                    System.err.println(e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(Constants.ERROR_FILE_FOUND + " " + fileName);
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void insert(int index, Purchase purchase) {
        if (isIndexCorrect(index)) {
            purchases.add(index, purchase);
        } else {
            purchases.add(purchase);
        }
        isSorted = false;
        totalCost.add(purchase.getCost());
    }

    public boolean isIndexCorrect(int index) {
        try {
            purchases.get(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return true;
    }

    public void delete(int index) {
        if (isIndexCorrect(index)) {
            totalCost.sub(purchases.get(index).getCost());
            purchases.remove(index);
        }
    }

    public Byn getTotalCost() {
        return totalCost;
    }

    public String toTable() {
        StringBuilder table = new StringBuilder();
        table.append(String.format(Constants.PRINT_FORMAT_TITLE, Constants.NAME, Constants.PRICE, Constants.NUMBER,
                Constants.DISCOUNT, Constants.COST));
        for (Purchase purchase: purchases) {
            table.append(String.format(purchase.getTableView()));
        }
        table.append(String.format(Constants.PRINT_FORMAT_TOTAL, Constants.TOTAL_COST, totalCost));
        return table.toString();
    }

    public void sort() {
        isSorted = true;
        Collections.sort(purchases, comparator);
    }

    public int binarySearch(Purchase purchase) {
        if (isSorted) {
            return Collections.binarySearch(purchases, purchase, comparator);
        } else {
            throw new IllegalArgumentException(Constants.ERROR_SORT_ARRAY);
        }
    }
}
