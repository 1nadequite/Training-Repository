import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import Converter.Converter;
import Converter.PriceConverter;
import Converter.DateConverter;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader(Constants.INPUT_TXT));

            String line;
            Converter priceConverter = new PriceConverter();
            Converter dateConverter = new DateConverter();

            while (sc.hasNext()) {
                line = sc.nextLine();

                line = priceConverter.stringCheck(Constants.PRICE_REGEX, line);
                line = dateConverter.stringCheck(Constants.DATE_REGEX, line);

                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
}
