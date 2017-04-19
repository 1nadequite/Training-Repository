public final class Constants {
    public static final String INPUT_TXT = "src/in.txt";
    public static final String PRICE_REGEX =
            "(\\p{Blank}|\\b)(\\p{Blank}*([1-9]{1}[0-9]{0,2})" +
                    "((\\p{Blank}+[0-9]{3})*)\\p{Blank}*)" +
                    "\\p{Blank}(belarusian roubles|blr)";
    public static final String DATE_REGEX = "([0-9]?[1-9])[\\.|\\/|\\-]([0-9]?[1-9])[\\.|\\/|\\-][0-9]{0,2}([0-9]{2})";
}
