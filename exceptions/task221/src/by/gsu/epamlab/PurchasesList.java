package by.gsu.epamlab;

import com.sun.tools.internal.jxc.ap.Const;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class PurchasesList {
    private List<Purchase> purchases;
    private Byn totalCost;

    public PurchasesList() {
        purchases = new ArrayList<Purchase>();
        totalCost = new Byn(0);
    }

    public PurchasesList(String fileName) {
        this();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader(fileName));
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

    public void addByIndex(int index, Purchase purchase) {
        try {
            purchases.add(index, purchase);
        } catch (IndexOutOfBoundsException e) {
            purchases.add(purchase);
        }
        totalCost.add(purchase.getCost());
    }

    public void removeByIndex(int index) {
        try {
            totalCost.sub(purchases.get(index).getCost());
            purchases.remove(index);
        } catch (IndexOutOfBoundsException e) {
            //System.err.println(Constants.ERROR_OUT_OF_BOUND + " " + index);
        }
    }

    public Byn getTotalCost() {
        return totalCost;
    }

    public void printInTable() {
        System.out.format("%-10s %10s %10s %10s %10s%n", Constants.NAME, Constants.PRICE, Constants.NUMBER,
                Constants.DISCOUNT, Constants.COST);
        for (Purchase purchase: purchases) {
            System.out.println(purchase.getTableView());
        }
        System.out.format("%-10s %43s%n", Constants.TOTAL_COST, totalCost);
    }

    public void sortPurchase(Comparator comparator) {
        Collections.sort(purchases, comparator);
    }

    public int getSize() {
        return purchases.size();
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public Purchase getPurchaseByIndex(int index) {
        Purchase purchase = null;
        try {
            purchase = purchases.get(index);
        } catch (IndexOutOfBoundsException e) {
            //System.err.println(Constants.ERROR_OUT_OF_BOUND + " " + index);
        }
        return purchase;
    }

    public int findPurchase(Purchase purchase, Comparator comparator) {
        return Collections.binarySearch(purchases, purchase, comparator);
    }
}
