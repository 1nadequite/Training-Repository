package by.gsu.epamlab.beans;

import by.gsu.epamlab.WeekDay;
import java.util.Map;

public interface EntryChecker {
    boolean check(Map.Entry<Purchase, WeekDay>  entry);
}

