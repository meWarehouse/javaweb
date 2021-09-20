package com.wen.review.oops.test3;

import java.util.Scanner;

public class PizzaView {
	
	private Scanner sc = new Scanner(System.in);
	
	public void EnterView(){
		
		boolean isFlag = true;
		while(isFlag){
			System.out.println("-----------------------------------披萨点餐界面-----------------------------------");
			System.out.println("                                   1.培根披萨");
			System.out.println("                                   2.海鲜披萨");
			System.out.println("                                   3.退出");
			System.out.print("                                       请选择：");
			
			char select = Utility.viewSelect();
			
			switch(select){
			case '1':
				GetBacon();
				break;
			case '2':
				GetSeafood();
				break;
			case '3':
				System.out.print("确认是否退出（Y/N）:");
				char selectYN = Utility.selectYN();
				if(selectYN == 'Y'){
					isFlag = false;
				}
			}
		}
	}
	
	private void GetBacon(){
		System.out.println("--------------------------------培根披萨--------------------------------");
		System.out.print("请输入配料：");
		String inputMess = Utility.inputMess();
		System.out.print("请输入大小：");
		double inputNumber = Utility.inputNumber();
		BaconPizza bp = new BaconPizza(inputMess, inputNumber, 2.4);
		System.out.println(bp.toString());
	}
	
	private void GetSeafood(){
		System.out.println("--------------------------------海鲜披萨--------------------------------");
		System.out.print("请输入配料：");
		String inputMess = Utility.inputMess();
		System.out.print("请输入大小："); 
		double inputNumber = Utility.inputNumber();
		SeafoodPizza sp = new SeafoodPizza(inputMess, inputNumber, 3.1);
		System.out.println(sp.toString());
	}
	
	private void Get(){
		
	}
	
	public static void main(String[] args) {
		
		PizzaView pv = new PizzaView();
		pv.EnterView();
		
	}
	
	
	
}
