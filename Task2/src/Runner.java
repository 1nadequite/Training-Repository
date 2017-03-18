import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;

public class Runner {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // construct two materials steel and copper
        final Material steel = new Material("steel", 7850.0);
        final Material copper = new Material("copper", 8500.0);

        // the object representing steel wire
        Subject wire = new Subject("wire", steel, 0.03);

        // printing the steel wire using method toString()
        System.out.printf("%s%n%n", wire);

        // change material of the wire on the copper
        wire.setMaterial(copper);

        // printing mass of the copper wire
        System.out.printf("The wire mass is %.1f kg.%n", wire.getMass());
    }
}
