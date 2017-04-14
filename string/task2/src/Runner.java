import java.util.Enumeration;
import java.util.Formatter;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Runner {
    public static void main(String[] args) {

        ResourceBundle rb = ResourceBundle.getBundle(ConstantVariable.INPUT_PROPERTIES);
        Enumeration<String> keys = rb.getKeys();
        String key;
        Pattern index_pattern = Pattern.compile(ConstantVariable.INDEX + ConstantVariable.REGEX);
        Pattern value_pattern = Pattern.compile(ConstantVariable.REGEX);
        Pattern wrong_index_pattern = Pattern.compile(ConstantVariable.INDEX + ".*");

        double result = 0;
        int errors = 0;

        while (keys.hasMoreElements()) {
            try {
                key = keys.nextElement();
                Matcher key_matcher = index_pattern.matcher(key);

                String value = ConstantVariable.VALUE;
                String key_index;

                if (key_matcher.matches()) {

                    value += key_matcher.group(1);
                    key_index = key_matcher.group();

                    Matcher value_matcher = value_pattern.matcher(rb.getString(key_index));

                    if (value_matcher.matches()) {
                        value += rb.getString(key_index);
                        result += Double.parseDouble(rb.getString(value));
                    } else {
                        errors++;
                    }
                } else if (wrong_index_pattern.matcher(key).matches()) {
                    errors++;
                }
            } catch(MissingResourceException | NumberFormatException e) {
                errors++;
            }
        }

        Formatter formattedString = new Formatter();
        formattedString.format("sum = %.3f\nerror-lines = %d\n", result, errors);
        System.out.println(formattedString);
    }
}
