package Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;

public class DateConverter extends Converter {
    protected String processing(Matcher matcher, String line) {
        DateFormat df = null;
        Date newDate = null;
        String date = Utilits.builtCorrectDate(matcher);
        try {
            df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);
            newDate = df.parse(date);
        } catch (ParseException e) {
            System.err.print("Error position: " + e.getErrorOffset());
        }
        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.ENGLISH);
        return line.replace(matcher.group(), df.format(newDate));
    }
}
