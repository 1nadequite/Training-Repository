package Converter;

import java.util.regex.Matcher;

public class PriceConverter extends Converter {
    protected String processing(Matcher matcher, String line) {
        String price = Utilits.builtCorrectPrice(matcher);
        return line.replace(matcher.group(2), price);
    }
}
