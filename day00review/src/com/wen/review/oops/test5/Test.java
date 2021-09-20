package com.wen.review.oops.test5;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
	
		
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入你的选择：");
		String key = sc.nextLine();
		Animals animals = AnimalTool.getAnimal(key);
		AnimalTool.display(animals);;
		
		
	}

	
}
