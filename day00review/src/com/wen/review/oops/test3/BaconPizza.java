package com.wen.review.oops.test3;

public class BaconPizza extends Pizza {

	public BaconPizza() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BaconPizza(String pizzaMessages, double size, double unitPrice) {
		super(pizzaMessages, size, unitPrice);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "名称：培根披萨\n"+super.toString();
	}
	
	
}

