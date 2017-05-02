package by.gsu.epamlab;

import by.gsu.epamlab.beans.TableSize;

public final class Constants {
    public static final String FILE_PATH = "src/";
    public static final String COMPARATOR_PATH = "by.gsu.epamlab.comparators.";
    public static final String FILE_CSV = ".csv";
    public static final String SEPARATOR = ";";
    public static final String WITHOUT_DISCOUNT = "-";

    public final static String PRINT_FORMAT_TITLE = String.format("%s%s%s%s%s%n", TableSize.NAME, TableSize.PRICE,
            TableSize.NUMBER, TableSize.DISCOUNT, TableSize.COST);
    public final static String PRINT_FORMAT_PURCHASE = String.format("%s%s%s%s%s%n", TableSize.NAME, TableSize.PRICE,
            TableSize.NUMBER, TableSize.DISCOUNT, TableSize.COST);
    public final static String PRINT_FORMAT_TOTAL = String.format("%s%s%n", TableSize.NAME, TableSize.TOTAL_COST);

    public static final String ERROR_FILE_FOUND = "input file is not found";
    public static final String ERROR_EXCEPTION_DELIMITER = "->";
    public static final String ERROR_WRONG_NUMBER = "wrong number of arguments";
    public static final String ERROR_WRONG_DISCOUNT = "discount bigger or equal than price";
    public static final String ERROR_FORMAT_NUMBER = "wrong number format";
    public static final String ERROR_NON_POSITIVE_VALUE = "non positive value";
    public static final String ERROR_NULL_NAME = "null name";
    public static final String ERROR_EMPTY_NAME = "empty name";
    public static final String ERROR_SORT_ARRAY = "purchases isn't sorted";

    public static final int CSV_FIELDS_NUMBER1 = 3;
    public static final int CSV_FIELDS_NUMBER2 = 4;
    public static final int NAME_INDEX = 0;
    public static final int PRICE_INDEX = 1;
    public static final int NUMBER_INDEX = 2;
    public static final int DISCOUNT_INDEX = 3;

    public static final String NAME = "Name";
    public static final String PRICE = "Price";
    public static final String NUMBER = "Number";
    public static final String DISCOUNT = "Discount";
    public static final String COST = "Cost";
    public static final String TOTAL_COST = "Total cost";
}