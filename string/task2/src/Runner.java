import java.util.Enumeration;
import java.util.Formatter;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {

        try {
            ResourceBundle rb = ResourceBundle.getBundle(ConstantVariable.INPUT_PROPERTIES);
            Enumeration<String> keys = rb.getKeys();
            Pattern indexPattern = Pattern.compile(ConstantVariable.INDEX + "(.*)");
            Pattern valuePattern = Pattern.compile(ConstantVariable.REGEX);

            double result = 0;
            int errors = 0;
            String key, iString, jString, valueIJ;

            while (keys.hasMoreElements()) {
                key = keys.nextElement();
                Matcher keyMatcher = indexPattern.matcher(key);

                if (keyMatcher.matches()) {

                    iString = keyMatcher.group(ConstantVariable.TAIL_INDEX);
                    jString = rb.getString(key).trim();

                    Matcher iMatcher = valuePattern.matcher(iString);
                    Matcher jMatcher = valuePattern.matcher(jString);

                    if (iMatcher.matches() && jMatcher.matches()) {
                        valueIJ = ConstantVariable.VALUE + iString + jString;
                        try {
                            result += Double.parseDouble(rb.getString(valueIJ));
                        } catch (MissingResourceException | IndexOutOfBoundsException | NumberFormatException e) {
                            errors++;
                        }
                    } else {
                        errors++;
                    }
                }
            }

            Formatter formattedString = new Formatter();
            formattedString.format("sum = %.3f\nerror-lines = %d\n", result, errors);
            System.out.println(formattedString);
        } catch (MissingResourceException e) {
            System.out.println("No input file");
        }
    }
}
