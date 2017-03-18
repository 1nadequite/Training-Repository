import by.gsu.epamlab.Material;
import by.gsu.epamlab.Subject;

public class Runner {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // the object representing steel wire
        Subject wire = new Subject("wire", Material.STEEL, 0.03);

        // printing the steel wire using method toString()
        System.out.printf("%s%n%n", wire);

        // change material of the wire on the copper
        wire.setMat(Material.COPPER);

        // printing mass of the copper wire
        System.out.printf("The wire mass is %.1f kg.%n", wire.getMass());
    }
}
