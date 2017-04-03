package by.gsu.epamlab.Cargo;

public class PassengerPerson extends Person {
    private String name;
    private double mass;

    public PassengerPerson(String name, double mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() { return name; }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    protected String fieldsToString() {
        return String.format("%s - %s;%.1f", this.getClass().getSimpleName(), name, mass);
    }
}
