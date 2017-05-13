package by.gsu.epamlab;

public class WholesalePurchase extends Purchase{
	
	private final static int LIMIT_NUMBER = 15;
	private double discountPercent;
	
	public WholesalePurchase() {
		super();
	}

	public WholesalePurchase(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	public WholesalePurchase(String name, int price, int number,double discountPercent) {
		super(name,price,number);
		this.discountPercent = discountPercent;
	}

	public double getDiscontPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
	public int getCost() {
		int cost = super.getCost();
		if(getNumber() > LIMIT_NUMBER){
			cost *= (1-discountPercent/100);
		}
		return cost;
	}

	@Override
	public String toString() {
		return super.toString() + ";" + discountPercent;
	}
	
}
