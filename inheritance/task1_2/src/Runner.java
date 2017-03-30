import by.gsu.epamlab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader("src/in.txt"));
            final int PURCHASES_NUMBER = 6;
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            Byn maxCostPerDay = new Byn(0);
            Purchase purchaseWithMaxCost = null;
            boolean equalPurchases = true;
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);

                System.out.println(purchases[i]);

                if (purchases[i].getCost().compareTo(maxCostPerDay) > 0) {
                    maxCostPerDay = purchases[i].getCost();
                    purchaseWithMaxCost = purchases[i];
                }

                if (equalPurchases) {
                    equalPurchases = purchases[i].equals(purchases[0]);
                }

            }
            System.out.printf("The purchase with maximum cost per day %s%nAll purchase are %sequal%n",
                              (purchaseWithMaxCost != null) ? "is " + purchaseWithMaxCost : "doesn't exit",
                              (equalPurchases) ? "" : "not ");

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
