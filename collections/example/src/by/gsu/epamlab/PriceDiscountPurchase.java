package by.gsu.epamlab;

public class PriceDiscountPurchase extends Purchase{
	private int discount;

	public PriceDiscountPurchase() {
		super();
	}
	
	public PriceDiscountPurchase(int discont) {
		this.discount = discont;
	}

	public PriceDiscountPurchase(String name, int price, int number,int discount) {
		super(name,price,number);
		this.discount = discount;
	}

	public int getDiscont() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getCost() {
		return (getPrice()-discount)*getNumber();
	}
	
	@Override
	public String toString() {
		return  super.toString()  + ";" + discount;
	}
	
	
}
