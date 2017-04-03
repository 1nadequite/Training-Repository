package by.gsu.epamlab.Cargo;

import java.util.Comparator;

public class ObjectCompare<T> implements Comparator<TransportableObject> {
    public int compare(TransportableObject object1, TransportableObject object2) {
        SortSequence objectType1 = SortSequence.valueOf(object1.getClass().getSimpleName().toUpperCase());
        SortSequence objectType2 = SortSequence.valueOf(object2.getClass().getSimpleName().toUpperCase());
        return objectType1.ordinal() - objectType2.ordinal();
    }
}

