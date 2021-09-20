package com.wen.review.oops.test5;

public class Dog extends Animals implements Animal{
	String from;

	public Dog(String name, int age, String from) {
		super(name, age);
		this.from = from;
	}


	public Dog(String from) {
		super();
		this.from = from;
	}

	public Dog() {
		
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	@Override
	public void stunt() {
		System.out.println("狗看门！！！");
		
	}

	@Override
	public void eat() {
		System.out.println("狗啃骨头！！！");
		
	}


	@Override
	public void play() {
		System.out.println("狗玩球！！");
		
	}


	@Override
	public String toString() {
		return "Dog:"+super.toString()+"from=" + from;
	}
	
	

}
