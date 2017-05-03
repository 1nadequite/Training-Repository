package by.gsu.epamlab.beans;

import by.gsu.epamlab.enums.NumField;
import by.gsu.epamlab.exceptions.NegativeArgumentException;

public class Byn implements Comparable<Byn>{
	private int value;

	public Byn() {
		this(0);
	}

	public Byn(int value) {
		if (value < 0) {
			throw new NegativeArgumentException(value, NumField.BYN);
		}
		this.value = value;
	}

	public Byn(int rubs, int coins) {
		if (rubs < 0) {
			throw new NegativeArgumentException(rubs, NumField.BYN);
		}
		if (coins < 0 || coins > 99) {
			throw new NegativeArgumentException(coins, NumField.BYN);
		}
		this.value = rubs * 100 + coins;
	}

	public Byn(Byn byn) {
		this(byn.value);
	}
	
	public int getRubs() {
		return value / 100;
	}
	
	public int getCoins() {
		return value % 100;
	}
	
	public Byn add(Byn byn) {
		value += byn.value;
		return this;	
	}
	
	public Byn sub(Byn byn) {
		if (value < byn.value) {
			throw new NegativeArgumentException(value - byn.value, NumField.BYN);
		}
		value -= byn.value;
		return this;	
	}
	
	public Byn mul(int k) {
		if (k < 0) {
			throw new NegativeArgumentException(k, NumField.KOEF);
		}
		value *= k;
		return this;	
	}
	
	public String toString() {
		int coins = getCoins();
		return getRubs() + "." + (coins < 10 ? "0" : "") + coins; 
	}
	
	public int compareTo(Byn byn) {
		return value - byn.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Byn))
			return false;
		Byn other = (Byn) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
}
