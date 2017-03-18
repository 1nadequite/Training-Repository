package by.gsu.epamlab;

public enum Material {
    STEEL(7850.0),
    COPPER(8500.0);

    private final double destiny;

    private Material(double destiny) {
        this.destiny = destiny;
    }

    // get the name of the material
    public String getName() { return name().toLowerCase(); }

    // get the destiny of the material
    public double getDestiny() {
        return destiny;
    }

    @Override
    public String toString() {
        return String.format("%s;%.1f", getName(), destiny);
    }
}
