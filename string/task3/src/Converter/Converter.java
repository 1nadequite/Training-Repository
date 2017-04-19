package Converter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Converter {
    public String stringCheck(String regex, String line) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            line = processing(matcher, line);
        }
        return line;
    }

    protected abstract String processing(Matcher matcher, String line);
}
