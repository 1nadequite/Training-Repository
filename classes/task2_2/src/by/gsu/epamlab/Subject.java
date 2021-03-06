package by.gsu.epamlab;

public class Subject {
    private String name;
    private Material material;
    private double volume;

    public Subject() {}

    public Subject(String name, Material material, double volume) {
        this.name = name;
        this.material = material;
        this.volume = volume;
    }

    public Subject(Subject subject) {
        this(subject.name, subject.material, subject.volume);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMat(Material material) {
        this.material = material;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    // calculating the subject mass
    public double getMass() {
        return material.getDestiny() * volume;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%.2f;%.1f", name, material, volume, getMass());
    }
}
