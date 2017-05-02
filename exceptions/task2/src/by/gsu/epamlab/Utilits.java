package by.gsu.epamlab;

public abstract class Utilits {
    public static String createFilePath(String fileName) {
        return Constants.FILE_PATH + fileName + Constants.FILE_CSV;
    }
}