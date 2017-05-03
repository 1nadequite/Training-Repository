package by.gsu.epamlab.beans;


import by.gsu.epamlab.Constants;
import by.gsu.epamlab.enums.NumField;
import by.gsu.epamlab.exceptions.NonpositiveArgumentException;

public class Purchase {
	private String name;

	private Byn price;

	private int unitsNumber;

	public Purchase() {
		throw new IllegalArgumentException(Constants.ERROR_NULL_NAME);
	}

	public Purchase(String name, Byn price, int unitsNumber) {
		setNameAndNumber(name, unitsNumber);
		setPrice(price);
	}

	public Purchase(String name, int priceInt, int unitsNumber) {
		setNameAndNumber(name, unitsNumber);
		setPrice(priceInt);
	}

	private void setNameAndNumber(String name, int unitsNumber) {
		setName(name);
		setUnitsNumber(unitsNumber);
	}
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException(Constants.ERROR_NULL_NAME);
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException(Constants.ERROR_EMPTY_NAME);
		}
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPrice(Byn price) {
		if (price.equals(new Byn())) {
			throw new NonpositiveArgumentException(0, NumField.PRICE);
		}
		this.price = price;
	}

	public void setPrice(int priceInt) {
		checkPositive(priceInt, NumField.PRICE);
		setPrice(new Byn(priceInt));
	}

	public Byn getPrice() {
		return price;
	}

	public void setUnitsNumber(int unitsNumber) {
		checkPositive(unitsNumber, NumField.UNITS_NUMBER);
		this.unitsNumber = unitsNumber;
	}

	public int getUnitsNumber() {
		return unitsNumber;
	}

	protected void checkPositive(int value, NumField numField) {
		if (value <= 0) {
			throw new NonpositiveArgumentException(value, numField);
		}
	}
	
	public Byn getCost() {
		return new Byn(price).mul(unitsNumber);
	}

	protected String fieldsToString() {
		return name + Constants.DELIMETER + price + Constants.DELIMETER
				+ unitsNumber;
	}

	public String toString() {
		return  fieldsToString() + Constants.DELIMETER + getCost();
	}
}