package com.wen.progect.progect01;

import java.util.Scanner;

/*
 * 
 * Utility工具类
 * 	将不同的功能封装为一个方法，直接通过调用使用其功能
 * 
 */
public class Utility {
	private static Scanner scanner = new Scanner(System.in);
	/*
	 * 用于界面菜单的选择，该方法读取键盘，如果用户输入'1'-'4'中的任意字符，则方法返回，返回值为用户输入的字符
	 */
	public static char readMenuSelection(){
		char c;
		for(;;){
			String str = readkeyBoard(1,false);
			c = str.charAt(0);
			if(c != '1' && c!='2'&&c!='3'&&c!='4'){
				System.out.print("选择错误，请重新输入：");
			}else break;
		}
		return c;
	}
	
	/*
	 * 用于收入和支出金额的输入，该方法从键盘读取一个不超过4位长度的整数，并将其作为方法的返回值
	 */
	public static int readNumber(){
		int n;
		for(;;){
			String str = readkeyBoard(4,false);
			try{
				n = Integer.parseInt(str);
				break;
			}catch(NumberFormatException e){
				System.out.print("数字输入错误，请重新输入：");
			}
		}
		return n;
	}
	
	/*
	 * 用于收入与支出的说明的输入，该方法从键盘读取一个不超过8位长度的字符串，并将其作为方法的返回值
	 */
	public static String readString(){
		String str = readkeyBoard(8,false);
		return str;
	}
	
	/*
	 * 用于确认选择的输入，该方法从键盘读取'N'或'Y'，并将其作为返回值
	 */
	public static char readConfirmSelection(){
		char c;
		for(;;){
			String str = readkeyBoard(1,false).toUpperCase();
			c = str.charAt(0);
			if(c == 'Y' || c == 'N'){
				break;
			}else{
				System.out.println("选择错误，请重新输入：");
			}
		}
		return c;
	}
	
	/**
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年2月16日下午7:07:18
	 * @param limit
	 * @param blankReturn
	 * @return
	 *
	 */
	private static String readkeyBoard(int limit, boolean blankReturn) {
		String line = "";
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.length() == 0) {
				if (blankReturn) {
					return line;
				} else {
					continue;
				}
			}

			if (line.length() < 1 || line.length() > limit) {
				System.out.println("输入长度（不大于" + limit + ") 错误，请重新输入：");
				continue;
			}
			break;
		}
		return line;
	}
	
	
}
