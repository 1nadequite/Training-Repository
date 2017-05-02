package by.gsu.epamlab.beans;

public class Byn implements Comparable<Byn> {
    private int value;

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
        value += byn.value;
        return this;
    }

    public Byn sub(Byn byn) {
        value -= byn.value;
        return this;
    }

    public Byn mul(int coef) {
        value *= coef;
        return this;
    }

    public Byn mul(double coef, RoundingType type) {
        value = type.getRoundedValue(value * coef);
        return this;
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