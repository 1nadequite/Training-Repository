package by.gsu.epamlab.beans;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.comparators.PurchaseComparatorBuilder;
import by.gsu.epamlab.enums.Column;
import by.gsu.epamlab.exceptions.CsvLineException;
import by.gsu.epamlab.factories.PurchasesFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchasesList {
    private List<Purchase> purchases;
    private Byn totalCost;
    private final static Comparator<Purchase> COMPARATOR = PurchaseComparatorBuilder.getPurchaseComparator();
    private boolean ordered;

    public PurchasesList() {
        setPurchases(new ArrayList<Purchase>());
        this.totalCost = new Byn();
        this.ordered = true;
    }

    public PurchasesList(String fileName) {
        this();
        final String FILE_PACKAGE = "src/";
        final String FILE_EXT = ".csv";
        ordered = false;
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(FILE_PACKAGE + fileName + FILE_EXT));
            while(sc.hasNext()) {
                try {
                    Purchase purchase = PurchasesFactory.getClassFromFactory(sc.nextLine());
                    purchases.add(purchase);
                    totalCost.add(purchase.getCost());
                } catch (CsvLineException e) {
                    System.err.println(e);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println(Constants.ERROR_FILE_PROC_HEAD + FILE_PACKAGE
                    + fileName + FILE_EXT + Constants.ERROR_FILE_PROC_FOOT);
            setPurchases(new ArrayList<>());
            ordered = true;
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
        if (purchases == null) {
            throw new NullPointerException();
        }
        this.purchases = purchases;
        ordered = false;
    }

    public void insert(int index, Purchase purchase) {
        if (index < 0) {
            index = 0;
        }
        if (index > purchases.size()) {
            index = purchases.size();
        }
        purchases.add(index, purchase);
        totalCost.add(purchase.getCost());
        ordered = false;
    }

    public boolean isIndexCorrect(int index) {
        return index >= 0 && index < purchases.size();
    }

    public int delete(int index) {
        totalCost.sub(purchases.get(index).getCost());
        purchases.remove(index);
        return index;
    }

    public Byn getTotalCost() {
        return totalCost;
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
        Collections.sort(purchases, COMPARATOR);
        ordered = true;
    }

    public int binarySearch(Purchase purchase) {
        if (!ordered) {
            sort();
        }
        return Collections.binarySearch(purchases, purchase,
                COMPARATOR);
    }
}
