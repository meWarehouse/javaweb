package com.wen.review.oops.test5;

public class Birds extends Animals implements Animal {
	String varieties;// 品种

	public Birds(String name, int age, String varieties) {
		super(name, age);
		this.varieties = varieties;
	}

	public Birds(String varieties) {
		super();
		this.varieties = varieties;
	}

	public Birds() {

	}

	public String getVarieties() {
		return varieties;
	}

	public void setVarieties(String varieties) {
		this.varieties = varieties;
	}

	@Override
	public String toString() {
		return "Birds：" + super.toString() + ",varieties=" + varieties;
	}

	@Override
	public void stunt() {
		System.out.println("企鹅不会飞！！！");

	}

	@Override
	public void eat() {
		System.out.println("吃肉！！！");

	}

	@Override
	public void play() {
		System.out.println("玩火！！");

	}

}
