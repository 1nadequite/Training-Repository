package by.gsu.epamlab;

import java.util.Scanner;

public class PurchasesFactory {
    public static Purchase getPurchaseFromFactory(Scanner sc) throws CsvLineException {
        String csvLine = sc.nextLine();
        //System.out.println(csvLine);
        String[] values = csvLine.split(Constants.SEPARATOR);
        if (values.length != Constants.CSV_FIELDS_NUMBER1 && values.length != Constants.CSV_FIELDS_NUMBER2) {
            throw new CsvLineException(Constants.ERROR_WRONG_NUMBER, csvLine);
        }
        String name = values[Constants.NAME_INDEX];
        try {
            int price = Integer.parseInt(values[Constants.PRICE_INDEX]);
            int number = Integer.parseInt(values[Constants.NUMBER_INDEX]);
            if (values.length == Constants.CSV_FIELDS_NUMBER2) {
                int discount = Integer.parseInt((values[Constants.DISCOUNT_INDEX]));
                return new PriceDiscountPurchase(name, price, number, discount);
            }
            return new Purchase(name, price, number);
        } catch (NumberFormatException e) {
            throw new CsvLineException(Constants.ERROR_FORMAT_NUMBER, csvLine);
        } catch (IllegalArgumentException e) {
            throw new CsvLineException(e.getMessage(), csvLine);
        }

    }
}