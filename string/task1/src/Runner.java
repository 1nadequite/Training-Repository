import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Formatter;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(new FileReader(ConstantVariable.INPUT_CSV));

            double result = 0;
            int errors = 0;
            StringBuilder expression = new StringBuilder();

            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] split = line.split(ConstantVariable.SEPARATOR);

                try {
                    int index = Integer.parseInt(split[0]);
                    double value = Double.parseDouble(split[index]);
                    result += value;
                    expression.append((value < 0) ? ConstantVariable.MINUS : ConstantVariable.PLUS);
                    expression.append(Math.abs(value));
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    errors++;
                }
            }
            String firstSymbol = expression.substring(0, Math.min(expression.length(), ConstantVariable.PLUS_LENGTH));
            expression.delete(0, ConstantVariable.PLUS_LENGTH);
            if (firstSymbol.equals(ConstantVariable.MINUS)) {
                expression.insert(0, "-");
            }
            Formatter formattedString = new Formatter();
            formattedString.format("result(%s) = %.2f\nerror-lines = %d\n", expression.toString(), result, errors);
            System.out.println(formattedString);
        } catch (FileNotFoundException e) {
            System.err.println("Input file is not found");
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }
}
