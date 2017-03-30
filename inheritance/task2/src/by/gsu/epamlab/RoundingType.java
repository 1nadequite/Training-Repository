package by.gsu.epamlab;

public enum RoundingType {
    CEIL {
        int getRoundedValue(double value) { return (int) Math.ceil(value); }
        int precisionRounding(int value, int precision) {
            return ((int) Math.ceil(value * 1.0 / precision)) * precision;
        }
    },
    FLOOR {
        int getRoundedValue(double value) { return (int) Math.floor(value); }
        int precisionRounding(int value, int precision) {
            return ((int) Math.floor(value * 1.0 / precision)) * precision;
        }
    },
    ROUND {
        int getRoundedValue(double value) { return (int) Math.round(value); }
        int precisionRounding(int value, int precision) {
            return ((int) Math.round(value * 1.0 / precision)) * precision;
        }
    };

    abstract int getRoundedValue(double value);
    abstract int precisionRounding(int value, int precision);
}
