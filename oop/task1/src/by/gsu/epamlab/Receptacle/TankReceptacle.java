package by.gsu.epamlab.Receptacle;

public class TankReceptacle implements Receptacle {
    private double mass;
    private double radius;
    private double length;

    public TankReceptacle(double mass, double radius, double length) {
        this.mass = mass;
        this.radius = radius;
        this.length = length;
    }

    public double getRadius() { return radius; }

    public double getLength() { return length; }

    @Override
    public double getMass() { return mass; }

    @Override
    public double getCapacity() {
        return Math.PI * radius * radius * length;
    }

    @Override
    public String toString() {
        return String.format("%.1f;%.1f;%.1f;%.1f", mass, radius, length, getCapacity());
    }
}
