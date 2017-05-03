package by.gsu.epamlab.beans;

import by.gsu.epamlab.Constants;
import by.gsu.epamlab.enums.NumField;
import by.gsu.epamlab.exceptions.NonpositiveArgumentException;

public class PriceDiscountPurchase extends Purchase {
	private Byn discount;

	public PriceDiscountPurchase() {
	}

	public PriceDiscountPurchase(String name, Byn price, int unitsNumber,
			Byn discount) {
		super(name, price, unitsNumber);
		setDiscount(discount);
	}

	public PriceDiscountPurchase(String name, int priceInt, int unitsNumber,
			int discountInt) {
		super(name, priceInt, unitsNumber);
		setDiscount(discountInt);
	}

	public void setDiscount(Byn discount) {
		if (discount.equals(new Byn())) {
			throw new NonpositiveArgumentException(0, NumField.DISCOUNT);
		}
		this.discount = discount;
		if (this.discount.compareTo(getPrice()) >= 0) {
			throw new IllegalArgumentException(
					Constants.ERROR_PRICE_AFTER_DISCOUNT);
		}
	}

	public void setDiscount(int discountInt) {
		checkPositive(discountInt, NumField.DISCOUNT);
		setDiscount(new Byn(discountInt));
	}

	public Byn getDiscount() {
		return discount;
	}

	public Byn getCost() {
		return super.getCost().sub(new Byn(discount).mul(getUnitsNumber()));
	}

	protected String fieldsToString() {
		return  super.fieldsToString() + Constants.DELIMETER + discount;
	}
}