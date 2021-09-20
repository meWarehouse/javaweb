package com.wen.review.oops.test4;

public class Dog extends Animal{

	public Dog(){
		
	}
	public Dog(String name, int age) {
		super(name, age);
	}
	
	public void eat(){
		System.out.println("狗啃骨头");
	}
	
	public void lookDoor(){
		System.out.println("狗看门");
	}
}
