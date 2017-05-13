package by.gsu.epamlab;

import java.util.Scanner;

public class PurchasesFactory {
	private static enum PurchasesKinds {
		GENERAL_PURCHASE,WHOLESALE_PURCHASE, PRICE_DISCOUNT_PURCHASE
	}
	public static Purchase getClassFromFactory(Scanner sc) {
		String id = sc.next();
		
		PurchasesKinds kind = PurchasesKinds.valueOf(id);
		String name = sc.next();
		int price = sc.nextInt();
		int num = sc.nextInt();
		switch(kind) {
			case GENERAL_PURCHASE : 
				return new Purchase(name, price, num);
			case PRICE_DISCOUNT_PURCHASE :
				int discount = sc.nextInt();
				return new PriceDiscountPurchase(name, price, num, discount);
			case WHOLESALE_PURCHASE :
				double discountPercent = sc.nextDouble();
				return new WholesalePurchase(name, price, num, discountPercent);
			default :
				throw new IllegalArgumentException();
		}
	}

}
