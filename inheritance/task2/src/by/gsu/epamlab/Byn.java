package by.gsu.epamlab;

public class Byn implements Comparable<Byn> {
    private final int value;

    public Byn(int value) {
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        this(rubs * 100 + coins);
    }

    public Byn(Byn byn) { this(byn.getRubs(), byn.getCoins()); }

    public int getRubs() {
        return value / 100;
    }

    public int getCoins() {
        return value % 100;
    }

    public Byn add(Byn byn) {
        return new Byn(value + byn.value);
    }

    public Byn sub(Byn byn) {
        return new Byn(value - byn.value);
    }

    public Byn mul(int coef) {
        return new Byn(value * coef);
    }

    public Byn mul(double coef, RoundingType type) {
        return new Byn(type.getRoundedValue(value * coef));
    }

    public Byn rounding(int precision, RoundingType type) {
        return new Byn(type.precisionRounding(value, precision));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Byn byn = (Byn) obj;
        return value == byn.value;
    }

    @Override
    public String toString() {
        return String.format("%d.%d%d", value / 100, value / 10 % 10, value % 10);
    }

    @Override
    public int compareTo(Byn byn) {
        return value - byn.value;
    }
}
