package by.gsu.epamlab;

public enum RoundingType {
    CEIL {
        int getRoundedValue(double value) { return (int) Math.ceil(value); }
    },
    FLOOR {
        int getRoundedValue(double value) { return (int) Math.floor(value); }
    },
    ROUND {
        int getRoundedValue(double value) { return (int) Math.round(value); }
    };

    abstract int getRoundedValue(double value);
}
