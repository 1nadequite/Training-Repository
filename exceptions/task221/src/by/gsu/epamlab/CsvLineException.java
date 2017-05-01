package by.gsu.epamlab;

public class CsvLineException extends Exception {
    private String csvLine;

    public CsvLineException() {}

    public CsvLineException(Exception exception, String csvLine ) {
        super(exception);
        this.csvLine = csvLine;
    }

    public CsvLineException(String cause, String csvLine) {
        super(cause);
        this.csvLine = csvLine;
    }

    public String toString() {
        return String.format("%s\t%s %s", csvLine, Constants.ERROR_EXCEPTION_DELIMITER, getMessage());
    }
}

