package by.gsu.epamlab.enums;

public enum NumField {
	BYN("BYN"), KOEF("koef"),  
	PRICE("price"), UNITS_NUMBER("unitsNumber"), DISCOUNT("discount");
	private final String name;
	private NumField(final String name) {
		this.name = name;
	}
	public String toString() {
		return name;
	}

}
