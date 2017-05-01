package by.gsu.epamlab;

import java.util.Comparator;

public abstract class Utilits {
    public static String createFilePath(String fileName) {
        return Constants.FILE_PATH + fileName + Constants.FILE_CSV;
    }

    public static Comparator getComparator(String compType) {
        Comparator comparator = null;
        try {
            Class cls = Class.forName(Constants.COMPARATOR_PATH + compType);
            comparator = (Comparator) cls.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.err.println(Constants.ERROR_COMPARATOR);
        }
        return comparator;
    }
}