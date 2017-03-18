import by.gsu.epamlab.Purchase;
import by.gsu.epamlab.WeekDay;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader("src/in.txt"));
            sc.useLocale(Locale.ENGLISH);
            final int PURCHASES_NUMBER = sc.nextInt();

            // create an array size of PURCHASES_NUMBER
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];

            // initialize the array by the file data
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                int number = sc.nextInt();
                int percent = sc.nextInt();
                // get a week day by the day id
                WeekDay week_day = WeekDay.getDay(sc.nextInt());
                // construct a new purchase
                purchases[i] = new Purchase(number, percent, week_day);
            }

            // printing the all elements of the array using method toString();
            System.out.printf("commodity = %s; price = %d.%d%n",
                    Purchase.getCommodity(), Purchase.getPrice() / 100, Purchase.getPrice() % 100);
            for (Purchase purchase: purchases) {
                System.out.println(purchase);
            }

            // calculating the mean cost, the total cost of all purchase on Monday, the day with the maximum cost purchase
            int mean_cost = 0;
            int total_cost_monday = 0;
            int max_cost_per_day = 0;
            WeekDay day_with_maximum_cost = null;

            for (Purchase purchase: purchases) {
                mean_cost += purchase.getCost();
                if (purchase.getWeek_day() == WeekDay.MONDAY) {
                    total_cost_monday += purchase.getCost();
                }
                if (purchase.getCost() > max_cost_per_day) {
                    max_cost_per_day = purchase.getCost();
                    day_with_maximum_cost = purchase.getWeek_day();
                }
            }
            System.out.printf("Mean cost = %.3f%nThe total cost on Monday = %.2f%n" +
                              "The day with the maximum cost purchase is %s%n",
                              (PURCHASES_NUMBER > 0) ? (double) mean_cost / 100 / PURCHASES_NUMBER : 0,
                              (double) total_cost_monday / 100, day_with_maximum_cost);

            // sort the array by numbers
            Arrays.sort(purchases);

            // printing the all elements of the array using method toString();
            if (PURCHASES_NUMBER > 0) {
                System.out.printf("commodity = %s; price = %d.%d%n",
                        Purchase.getCommodity(), Purchase.getPrice() / 100, Purchase.getPrice() % 100);
            }
            for (Purchase purchase: purchases) {
                System.out.println(purchase);
            }

            // printing a purchase with number equaled to 5
            int number = 5;
            int index = Arrays.binarySearch(purchases, new Purchase(number, 0, null));
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
