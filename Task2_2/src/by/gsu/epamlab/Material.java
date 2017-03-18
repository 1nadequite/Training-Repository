package by.gsu.epamlab;

public enum Material {
    STEEL(7850.0),
    COPPER(8500.0);

    private Material(double destiny) {
        this.destiny = destiny;
    }

    // get the destiny of the material
    public static double getDestiny(Material material) {
        return material.destiny;
    }

    private double destiny;

    @Override
    public String toString() {
        return String.format("%s;%.1f", name(), destiny);
    }
}
