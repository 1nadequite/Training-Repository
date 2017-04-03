package by.gsu.epamlab;

import by.gsu.epamlab.Cargo.TransportableObject;

import java.util.ArrayList;

public class Ferry {
    private double capacity;
    private ArrayList<TransportableObject> objects;

    public Ferry(double capacity) {
        this.capacity = capacity;
        this.objects = new ArrayList<>(0);
    }

    public double getCapacity() { return capacity; }

    public ArrayList<TransportableObject> getObjects() { return objects; }

    public void immerseObject(TransportableObject object) { objects.add(object); }

    public double getImmersedMass() {
        double totalMass = 0;
        for (TransportableObject object: objects) {
            totalMass += object.getMass();
        }
        return totalMass;
    }

    public boolean isPassed() { return capacity > getImmersedMass();}
}
