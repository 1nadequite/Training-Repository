package Converter;

import java.util.regex.Matcher;

public abstract class Utilits {
    public static String builtCorrectPrice(Matcher matcher) {
        return matcher.group(2).replace(" ", "");
    }

    public static String builtCorrectDate(Matcher matcher) {
        return matcher.group(2) + '/' + matcher.group(1) + '/' + matcher.group(3);
    }
}
