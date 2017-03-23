import by.gsu.epamlab.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader("src/in.txt"));
            Purchase[] purchases = new Purchase[6];

            int maxCostPerDay = 0;
            boolean equalPurchase = true;
            for (int i = 0; i < purchases.length; i++) {
                purchases[i] = PurchasesFactory.getPurchaseFromFactory(sc);

                System.out.println(purchases[i]);

                if (purchases[i].getCost() > maxCostPerDay) {
                    maxCostPerDay = purchases[i].getCost();
                }

                if (i > 0 && !purchases[i].equals(purchases[i - 1])) {
                    equalPurchase = false;
                }
            }
            System.out.printf("The maximum cost per day is %s%nAll purchase are %sequal%n",
                              Finance.priceToString(maxCostPerDay), (equalPurchase) ? "" : "not ");

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
