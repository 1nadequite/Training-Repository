package by.gsu.epamlab;

public enum RoundingType {
    CEIL {
        int getRoundedValue(double value) { return (int) Math.ceil(value); }
        int precisionRounding(int value, int precision) {
            return ((int) Math.ceil((double) value / precision)) * precision;
        }
    },
    FLOOR {
        int getRoundedValue(double value) { return (int) Math.floor(value); }
        int precisionRounding(int value, int precision) {
            return ((int) Math.floor((double) value / precision)) * precision;
        }
    },
    ROUND {
        int getRoundedValue(double value) { return (int) Math.round(value); }
        int precisionRounding(int value, int precision) {
            return ((int) Math.round((double) value / precision)) * precision;
        }
    };

    abstract int getRoundedValue(double value);
    abstract int precisionRounding(int value, int precision);
}