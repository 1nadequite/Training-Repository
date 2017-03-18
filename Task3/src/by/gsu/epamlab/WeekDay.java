package by.gsu.epamlab;

import java.util.HashMap;

public enum WeekDay {
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6);

    private static final HashMap<Integer, WeekDay> daysByValue = new HashMap<Integer, WeekDay>();

    // filling the map by the all week days
    static {
        for (WeekDay day : WeekDay.values()) {
            daysByValue.put(day.id, day);
        }
    }

    private WeekDay(int id) {
        this.id = id;
    }

    // get the day id by the week day
    public static int getId(WeekDay day) { return day.id; }

    // get the week day by the day id
    public static WeekDay getDay(int id) { return daysByValue.get(id); }

    private int id;
}
