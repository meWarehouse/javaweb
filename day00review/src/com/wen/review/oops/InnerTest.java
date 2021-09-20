package com.wen.review.oops;



public class InnerTest {
	public static void main(String[] args) {
		
		Outer.Inner i = new Outer().new Inner();
		Outer.InnerOne i1 = new Outer.InnerOne();
		
		Students s1 = new Students();
		s1.play();
		
		Teachers t1 = new Teachers();
		t1.play();
		
		Students s2 = new Students();
		
		
	}
}

class Outer{
	
	private int n = 9;
	
	class Inner{
		public void display(){
			System.out.println(n++);
		}
	}
	
	static class InnerOne{
		
	}
	
	
	public void play(){
		class InnerTwo{
			
		}
	}
	
	public void method(){
		Persons p = new Persons(){

			@Override
			public void play() {
				System.out.println("play");
				
			} 
			
		};
	}
	
	
}

interface Persons{
	public abstract void play();
}

class Students implements Persons{

	@Override
	public void play() {
		System.out.println("读书");
		
	}
	
}
class Teachers implements Persons{

	@Override
	public void play() {
		System.out.println("教书");
		
	}
	
}