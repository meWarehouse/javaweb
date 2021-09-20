package com.wen.review.oops;

public class Test1 {

}

interface A{
	int x = 0;
}
class B{
	int x = 1;
}
class C extends B implements A{
	public void pX(){
//		System.out.println(x); //错误
		System.out.println(super.x);
		System.out.println(A.x);//接口中的变量都是静态的常量
	}
} 

interface Playable{
	public abstract void play();
	public static void method(){
		System.out.println("JDK8以后接口可以定义静态方法 接口中的静态方法只能由接口调用");
	}
	default void method1(){
		System.out.println("JDK8以后接口可以定义默认方法");
	}
	
}
interface Bounceable{
	public abstract void play();
}
interface Rollable extends Playable,Bounceable{
	public static final Ball ball = new Ball("pingpang");
}
class Ball implements Rollable{

	private String name;
	
	public Ball(String name) {
		this.name = name;
	}

	@Override
	public void play() {
//		ball = new Ball("edvf");
		
	}
	
}