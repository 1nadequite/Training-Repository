package by.gsu.epamlab;

public class Material {
    private final String NAME;
    private final double DESTINY;

    public Material() {
        this.NAME = null;
        this.DESTINY = 0.0;
    }

    public Material(String name, double destiny) {
        this.NAME = name;
        this.DESTINY = destiny;
    }

    public String getName() {
        return NAME;
    }

    public double getDestiny() {
        return DESTINY;
    }

    @Override
    public String toString() {
        return NAME + ";" + DESTINY;
    }
}
