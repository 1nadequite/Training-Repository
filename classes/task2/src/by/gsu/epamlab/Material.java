package by.gsu.epamlab;

import com.sun.tools.classfile.Exceptions_attribute;

public class Material {
    private final String name;
    private final double destiny;

    public Material() {
        this(null, 0.0);
    }

    public Material(String name, double destiny) {
        this.name = name;
        this.destiny = destiny;
    }

    public String getName() {
        return name;
    }

    public double getDestiny() {
        return destiny;
    }

    @Override
    public String toString() {
        return String.format("%s;%.1f", name, destiny);
    }
}