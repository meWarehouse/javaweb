package com.wen.review.oops.test5;

public class AnimalTool {
	
	public static Animals getAnimal(String key) {

		switch (key) {
		case "1":
			return new Dog("汪汪",1,"英国");
		case "2":
			return new Birds("企鹅",2,"鸟");
		}
		return null;

	}
	
	public static void display(Animals animals){
		if(animals instanceof Dog){
			Dog d = (Dog)animals;
			d.eat();
			d.play();
			d.stunt();
			d.toString();
		}else if(animals instanceof Birds){
			Birds b = (Birds)animals;
			b.eat();
			b.play();
			b.stunt();
			b.toString();
		}
	}
	
}
