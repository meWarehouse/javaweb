package com.wen.review.oops.test4;

public class Cat extends Animal{

	public Cat(){
		
	}
	public Cat(String name, int age) {
		super(name, age);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void eat() {
		System.out.println("猫吃鱼");
	}
	
	public void play(){
		System.out.println("猫玩球");
	}
}
