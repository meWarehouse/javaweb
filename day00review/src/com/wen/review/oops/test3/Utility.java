package com.wen.review.oops.test3;

import java.util.Scanner;

public class Utility {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * 选择‘1’~‘3’进入对应的选择
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年2月24日下午6:05:54
	 * @return
	 *
	 */
	public static char viewSelect(){
		char c;
		for(;;){
			String str = sc.nextLine();
			c = str.charAt(0);
			if(c == '1' || c == '2' || c=='3'){
				break;
			}else {
				System.out.print("输入错误请重新输入：");
			}
		}
		return c;
	}
	
	/**
	 * 选则'X/Y' 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年2月24日下午6:23:16
	 * @return
	 *
	 */
	public static char selectYN(){
		char c;
		for(;;){
			String str = sc.nextLine();
			c = str.toUpperCase().charAt(0);
			if(c== 'Y' || c == 'N'){
				break;
			}else{
				System.out.print("输入错误请重新输入：");
			}
		}
		return c;
	}
	
	/**
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年2月24日下午6:34:59
	 * @return
	 *
	 */
	public static String inputMess(){
		return sc.nextLine();
	}
	
	
	public static double inputNumber(){
		double num;
		for(;;){
			String str = sc.nextLine();
			try{
				num = Double.parseDouble(str);
				break;
			}catch(Exception e){
				System.out.print("输入错误，请输入数字：");
			}
		}
		return num;
		
	}
	
	
	
}
