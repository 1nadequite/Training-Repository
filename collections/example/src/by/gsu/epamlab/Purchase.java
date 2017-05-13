package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase>{
	private String name;
	private int price;
	private int number;
	
	public Purchase() {
	}

	public Purchase(String name, int price, int number) {
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCost(){
		return price*number;
	}
	
	@Override
	public String toString() {
		return  name + ";" + price + ";" + number + ";" +getCost();
	}

	public String toEqualityString() {
		return  name + ";" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Purchase other = (Purchase) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	
	public int compareTo(Purchase purchase) {
		if(!name.equals(purchase.name)) {
			return name.compareTo(purchase.name);
		}
		return price - purchase.price;
		
	}
	
}
