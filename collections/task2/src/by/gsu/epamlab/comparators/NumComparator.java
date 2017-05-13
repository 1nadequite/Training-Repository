package by.gsu.epamlab.comparators;

import by.gsu.epamlab.beans.NumLen;

import java.util.Comparator;

public class NumComparator implements Comparator<NumLen> {
    public int compare(NumLen d1, NumLen d2) {
        return d2.getNum() - d1.getNum();
    }
}
