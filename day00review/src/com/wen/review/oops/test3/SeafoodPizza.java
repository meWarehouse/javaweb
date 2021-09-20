package com.wen.review.oops.test3;

public class SeafoodPizza extends Pizza{
	public SeafoodPizza() {
		super();
	}

	public SeafoodPizza(String pizzaMessages, double size, double unitPrice) {
		super(pizzaMessages, size,unitPrice);
	}

	@Override
	public String toString() {
		return "名称：海鲜披萨\n"+super.toString();
	}
	
}
