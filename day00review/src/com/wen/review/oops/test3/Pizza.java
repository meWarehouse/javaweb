package com.wen.review.oops.test3;

public class Pizza {
	String pizzaMessages;// 披萨配料信息
	double size;// 披萨大小
	double unitPrice;// 单价


	public Pizza() {
		super();
		
	}

	public Pizza(String pizzaMessages, double size, double unitPrice) {
		super();
		this.pizzaMessages = pizzaMessages;
		this.size = size;
		this.unitPrice = unitPrice;
	}

	public String getPizzaMessages() {
		return pizzaMessages;
	}

	public void setPizzaMessages(String pizzaMessages) {
		this.pizzaMessages = pizzaMessages;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * 计算总价
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年2月24日下午5:34:53
	 *
	 */
	public double SumPrice() {
		return size * unitPrice;
	}

	@Override
	public String toString() {
		return "配料：" + pizzaMessages + "\n大小：" + size + "\n单价：" + unitPrice + "\n总价："+SumPrice();
	}

	
	
}
