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
        final Commodity milk = new Commodity("Milk", 124);

        AbstractPurchase[] purchases = new AbstractPurchase[] {
            new PriceDiscountPurchase(milk, 3, 10),
            new PercentDiscountPurchase(milk, 8, 5.825),
            new TransportExpensesPurchase(milk, 6, 23),
            new PriceDiscountPurchase(milk, 10, 73),
            new TransportExpensesPurchase(milk, 13, 50),
            new PercentDiscountPurchase(milk, 7, 3.5)
        };

        printPurchases(purchases);

        Arrays.sort(purchases);

        printPurchases(purchases);

        System.out.printf("Minimum cost = %s%n", purchases[purchases.length - 1]);

        AbstractPurchase purchaseForSearch =
                new PriceDiscountPurchase(new Commodity("Milk", 500), 1, 0);
        int index = Arrays.binarySearch(purchases, purchaseForSearch);
        System.out.printf("Required purchase is %s%n", (index < 0) ? "not found" : purchases[index]);
    }
}
