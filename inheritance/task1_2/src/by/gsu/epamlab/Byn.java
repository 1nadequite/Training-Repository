package by.gsu.epamlab;

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
        return new Byn(value += byn.value);
    }

    public Byn sub(Byn byn) {
        return new Byn(value -= byn.value);
    }

    public Byn mul(int n) {
        return new Byn(value *= n);
    }

    public Byn mul(double n) { return new Byn(value *= n); }

    public Byn div(int n) { return new Byn(value /= n); }

    public Byn div(double n) { return new Byn(value /= n); }

    public Byn ceil() {
        return new Byn(value = (getRubs() + 1) * 100);
    }

    public Byn floor() {
        return new Byn(value = getRubs() * 100);
    }

    public Byn round() {
        return new Byn(value = (getRubs() + ((getCoins() >= 50) ? 1 : 0)) * 100);
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
