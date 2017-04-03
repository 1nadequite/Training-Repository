package by.gsu.epamlab.Cargo;

import by.gsu.epamlab.Receptacle.TankReceptacle;

public class TankCargo extends Cargo {
    private double density;
    private TankReceptacle tank;

    public TankCargo(double density, TankReceptacle tank) {
        this.density = density;
        this.tank = tank;
    }

    public double getDensity() { return density; }

    public TankReceptacle getTank() { return tank; }

    @Override
    public double getMass() {
        return density / 1000 * tank.getCapacity() + tank.getMass();
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s - %.1f;%s", this.getClass().getSimpleName(), density, tank);
    }
}
