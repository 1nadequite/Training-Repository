package by.gsu.epamlab.beans;

public enum TableSize {
    NAME("%-12s"),
    PRICE("%12s"),
    NUMBER("%12s"),
    DISCOUNT("%12s"),
    COST("%12s"),
    TOTAL_COST("%48s");

    private final String size;

    private TableSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return size;
    }
}
