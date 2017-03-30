import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {
    private static void printPurchases(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase: purchases) {
            System.out.println(purchase);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Commodity commodity = new Commodity("Milk", 124);

        AbstractPurchase[] purchases = new AbstractPurchase[] {
            new PriceDiscountPurchase(commodity, 3, 10),
            new PercentDiscountPurchase(commodity, 8, 5.825),
            new TransportExpensesPurchase(commodity, 6, 23),
            new PriceDiscountPurchase(commodity, 10, 73),
            new TransportExpensesPurchase(commodity, 13, 50),
            new PercentDiscountPurchase(commodity, 7, 3.5)
        };

        printPurchases(purchases);

        Arrays.sort(purchases);

        printPurchases(purchases);

        System.out.printf("Minimum cost = %s%n", purchases[purchases.length - 1]);

        AbstractPurchase purchase_for_search =
                new PriceDiscountPurchase(new Commodity(null, 500), 1, 0);
        int index = Arrays.binarySearch(purchases, purchase_for_search);
        System.out.printf("Required purchase is %s%n", (index < 0) ? "not found" : purchases[index]);
    }
}
