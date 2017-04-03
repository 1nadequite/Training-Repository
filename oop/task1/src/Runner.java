import by.gsu.epamlab.Ferry;
import by.gsu.epamlab.Cargo.*;
import by.gsu.epamlab.Receptacle.ContainerReceptacle;
import by.gsu.epamlab.Receptacle.TankReceptacle;

import java.util.ArrayList;
import java.util.Collections;

public class Runner {
    private static void printPurchases(ArrayList<TransportableObject> objects) {
        for (TransportableObject object: objects) {
            System.out.println(object);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final int FERRY_CAPACITY = 100000;
        final Ferry vikingLine = new Ferry(FERRY_CAPACITY);

        final ContainerReceptacle smallContainer = new ContainerReceptacle(300,2.5, 2.5,2.5);
        final ContainerReceptacle mediumContainer = new ContainerReceptacle(600,2.5, 2.5,5);
        final ContainerReceptacle bigContainer = new ContainerReceptacle(1000,2.5, 2.5,8);

        final TankReceptacle hermeticTank = new TankReceptacle(800, 1.25, 8);
        final TankReceptacle usualTank = new TankReceptacle(700, 1.25, 7);

        vikingLine.immerseObject(new TankCargo(2650.0, hermeticTank));
        vikingLine.immerseObject(new PassengerPerson("John", 75));
        vikingLine.immerseObject(new PlatformCargo(5000));
        vikingLine.immerseObject(new PassengerPerson("Dan", 83.5));
        vikingLine.immerseObject(new ContainerCargo(1550.0, mediumContainer));
        vikingLine.immerseObject(new PlatformCargo(10000));
        vikingLine.immerseObject(new ContainerCargo(2135.5, bigContainer));
        vikingLine.immerseObject(new TankCargo(1100.0, usualTank));
        vikingLine.immerseObject(new PassengerPerson("Ivan", 77));
        vikingLine.immerseObject(new ContainerCargo(1760.0, smallContainer));

        printPurchases(vikingLine.getObjects());

        Collections.sort(vikingLine.getObjects(), new ObjectCompare<TransportableObject>());

        printPurchases(vikingLine.getObjects());

        System.out.format("Ferry %s able to carry all people and cargo.%n", (vikingLine.isPassed()) ? "will" : "won't");

    }
}
