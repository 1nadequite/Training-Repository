import by.gsu.epamlab.BusinessTrip;

public class Runner {
    /**
     * @param args
     */
    public static void main(String[] args) {
        BusinessTrip[] trips = {
            new BusinessTrip("Ivan Ivanov", 1600, 7),
            new BusinessTrip("Kostya Petrov", 560, 3),
            null,
            new BusinessTrip("Vasya Sidorov", 888, 5),
            new BusinessTrip()
        };

        // printing the all elements of the array using method show()
        for (BusinessTrip trip : trips) {
            if (trip != null) {
                trip.show();
            } else {
                System.out.printf("null%n%n");
            }
        }

        // set a new transportation expenses for the last employee
        trips[trips.length - 1].setTransport(1234);

        // printing duration of days for first two employees
        System.out.printf("Duration = %d%n%n", trips[0].getDays() + trips[1].getDays());

        // printing all the elements of the array using method toString();
        for (BusinessTrip trip : trips) {
            System.out.println(trip);
        }
    }
}
