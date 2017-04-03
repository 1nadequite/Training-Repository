package by.gsu.epamlab.Cargo;

public abstract class Person implements TransportableObject {
    protected abstract String fieldsToString();

    @Override
    public String toString() {
        return String.format("%s;%.1f", fieldsToString(), getMass());
    }
}
