package by.gsu.epamlab.Cargo;

public class PlatformCargo extends Cargo {
    private double mass;

    public PlatformCargo(double mass) {
        this.mass = mass;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s - %.1f", this.getClass().getSimpleName(), mass);
    }
}
