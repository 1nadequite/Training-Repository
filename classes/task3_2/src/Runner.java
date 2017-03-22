import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.Utility;
import by.gsu.epamlab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Runner {

    private static void printPurchases(Purchase[] purchases) {
        System.out.printf("%s;%s%n", Purchase.NAME, Utility.toString(Purchase.PRICE));
        for (Purchase purchase: purchases) {
            System.out.println(purchase);
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader("src/in.txt"));
            final int PURCHASES_NUMBER = sc.nextInt();
            // create an array size of PURCHASES_NUMBER
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            // initialize the array by the file data
            for (int i = 0; i < purchases.length; i++) {
                int number = sc.nextInt();
                double percent = sc.nextDouble();
                int day = sc.nextInt();
                // construct a new purchase
                purchases[i] = new Purchase(number, percent, day);
            }

            // printing the all elements of the array
            printPurchases(purchases);

            // calculating the mean cost, the total cost of all purchase on Monday, the day with the maximum cost purchase
            int totalCost = 0;
            int totalCostOnMonday = 0;
            int maxCostPerDay = 0;
            double meanCost = 0.0;
            WeekDay dayWithMaximumCost = null;

            for (Purchase purchase: purchases) {
                int cost = purchase.getCost();
                totalCost += cost;
                if (purchase.getDay() == WeekDay.MONDAY) {
                    totalCostOnMonday += cost;
                }
                if (cost > maxCostPerDay) {
                    maxCostPerDay = cost;
                    dayWithMaximumCost = purchase.getDay();
                }
            }
            if (purchases.length > 0) {
                meanCost = ((double) (totalCost / 100)) / PURCHASES_NUMBER;
            }
            System.out.printf("Mean cost = %.3f%nThe total cost on Monday = %s%n" +
                              "The day with the maximum cost purchase is %s%n",
                              meanCost, Utility.toString(totalCostOnMonday), dayWithMaximumCost);

            // sort the array by numbers
            Arrays.sort(purchases);

            // printing the all elements of the array
            printPurchases(purchases);

            // finding and printing a purchase with number equaled to 5
            int number = 5;
            int index = Arrays.binarySearch(purchases, new Purchase(number, 0, null));
            System.out.println(index);
            System.out.printf("Required purchase is %s%n", (index < 0) ? "not found" : purchases[index]);

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
