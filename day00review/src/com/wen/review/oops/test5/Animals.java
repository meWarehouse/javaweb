package com.wen.review.oops.test5;

public abstract class Animals {
	String name;
	int age;

	public Animals(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Animals() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public abstract void eat();

	public abstract void play();

	@Override
	public String toString() {
		return "name：" + name + ", age：" + age;
	}

	
	
}
