package com.wen.review.oops;

public class OOPs {
	public static void main(String[] args) {
		
		/*
		 * 面向对象三条主线
		 * 	1.java类及类的成员：属性、方法、构造器、代码块、内部类
		 * 	2.面向对象三大特征：封装、继承、多态、(抽象性)
		 * 	3.其他关键字：this,supper,static,final,abstract,interface,package,import
		 * 
		 */
		
		/*
		 * ctrl+shift+/(\) 多行注释(取消注释)
		 * 
		 * ctrl+(ctrl+shift+t) 查看源码
		 * 
		 * Ctrl+left(right) 退回上一个界面(进入下一个界面)
		 * 
		 * Ctrl+t	查看继承结构
		 * 
		 * Ctrl+shift+y(x) 转小写(大写)
		 */
		
		Person p1 = new Person();
		p1.name="wd";
		p1.age = 12;
		p1.sex = 0;
		
		p1.study();
		p1.showAge();
		System.out.println(p1.addAge(2));
		
		System.out.println("-------------------------------------------------");
		
		//创建20个学生对象
		Student[] stus = new Student[20];
		for(int i = 0;i<stus.length;i++){
			stus[i] = new Student();
			stus[i].number = (i+1);
			stus[i].state = (int)(Math.random()*(6-1+1)+1);
			stus[i].score = (int)(Math.random()*(100-0+1)+0);
			
		}
		
		for(Student s:stus){
			System.out.println(s);
		}
		
	}
	
}

class Student{
	int number;
	int state;
	int score;
	@Override
	public String toString() {
		return "Student [number=" + number + ", state=" + state + ", score=" + score + "]";
	}
	
	
}



class Person{
	String name;
	static int age;
	int sex;
	
	

	public void study(){
		System.out.println("studying");
	}
	
	public void showAge(){
		System.out.println("age:"+age);
	}
	
	public int addAge(int i){
		age+=i;
		return age;
	}
	
	
	
}
