package by.gsu.epamlab.Receptacle;

public class ContainerReceptacle implements Receptacle {
    private double mass;
    private double width;
    private double height;
    private double length;

    public ContainerReceptacle(double mass, double width, double height, double length) {
        this.mass = mass;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public double getWidth() { return width; }

    public double getHeight() { return height; }

    public double getLength() { return length; }

    @Override
    public double getMass() { return mass; }

    @Override
    public double getCapacity() {
        return width * height * length;
    }

    @Override
    public String toString() {
        return String.format("%.1f;%.1f;%.1f;%.1f;%.1f", mass, width, height, length, getCapacity());
    }
}
