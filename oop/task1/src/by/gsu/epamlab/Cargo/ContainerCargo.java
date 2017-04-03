package by.gsu.epamlab.Cargo;

import by.gsu.epamlab.Receptacle.ContainerReceptacle;

public class ContainerCargo extends Cargo {
    private double density;
    private ContainerReceptacle container;

    public ContainerCargo(double density, ContainerReceptacle container) {
        this.density = density;
        this.container = container;
    }

    public double getDensity() { return density; }

    public ContainerReceptacle getContainer() { return container; }

    @Override
    public double getMass() {
        return density / 1000 * container.getCapacity() + container.getMass();
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s - %.1f;%s", this.getClass().getSimpleName(), density, container);
    }
}
