import by.gsu.epamlab.*;

import java.util.Arrays;

public class Runner {
    private static void printPurchases(AbstractPurchase[] purchases) {
        for (AbstractPurchase purchase: purchases) {
            System.out.println(purchase);
        }
    }

    public static void main(String[] args) {
        Commodity commodity = new Commodity("Milk", 1234);

        AbstractPurchase[] purchases = new AbstractPurchase[] {
            new PriceDiscountPurchase(commodity, 10, 50),
            new PercentDiscountPurchase(commodity, 23, 5.825),
            new TransportExpensePurchase(commodity, 6, 150),
            new TransportExpensePurchase(commodity, 15, 200),
            new PriceDiscountPurchase(commodity, 35, 75),
            new PercentDiscountPurchase(commodity, 9, 3.5)
        };

        printPurchases(purchases);

        Arrays.sort(purchases);

        printPurchases(purchases);

        System.out.printf("Minimum cost = %s%n", purchases[purchases.length - 1]);

        Byn cost = new Byn(500);
        int index = Arrays.binarySearch(purchases, new PriceDiscountPurchase(commodity, 35, 75));
        System.out.printf("Required purchase is %s%n", (index < 0) ? "not found" : purchases[index]);
    }
}
