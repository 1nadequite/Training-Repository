package by.gsu.epamlab.factories;

import by.gsu.epamlab.beans.PricePurchase;
import by.gsu.epamlab.beans.Purchase;
import by.gsu.epamlab.Constants;

public class PurchasesFactory {
    private final static int PURCHASE_FIELDS_NUMBER = Purchase.class.getDeclaredFields().length;

    public static Purchase getClassFromFactory(String csvLine) {
        String[] values = csvLine.split(Constants.SEPARATOR);

        String name = values[Constants.NAME_INDEX];
        int price = Integer.parseInt(values[Constants.PRICE_INDEX]);
        int number = Integer.parseInt(values[Constants.NUMBER_INDEX]);
        Purchase purchase;
        if (values.length == PURCHASE_FIELDS_NUMBER) {
            purchase = new Purchase(name, price, number);
        } else {
            int discount = Integer.parseInt(values[Constants.DISCOUNT_INDEX]);
            purchase = new PricePurchase(name, price, number, discount);
        }
        return purchase;
    }
}