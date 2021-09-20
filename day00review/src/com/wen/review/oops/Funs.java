package com.wen.review.oops;

import java.util.Arrays;
import java.util.Scanner;

public class Funs {
	public static void main(String[] args){
		
		/*
		 * 面向对象
		 * 	1.方法
		 * 
		 */
		
		int[] arr1 = new int[]{1,4,2,34,23};
		int[][] arr2 = {{1,3,2},{230,9,12,21}};
		double[] arr3 = new double[]{-12.4,2.1,1.2,4,8.9,765,-23.4,4.3};
		int[][] arr4 = new int[][]{{1,2,3,4},{}};
		
		System.out.println(Arrays.toString(arr2));
		prints(arr1);
		System.out.println("\n---------------------------------------------");
		prints(arr3);
		System.out.println("\n---------------------------------------------");
		bubble(arr1);
		System.out.println("\n---------------------------------------------");
		bubble(arr3);
		prints(arr3);
		System.out.println();
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入你要查找的数：");
		double a = sc.nextDouble();
		System.out.println(searchs(arr3, a));
		
		
	}
	
	public static void prints(int arr[]){
		for(int i = 0;i<arr.length;i++){
			if(i==arr.length-1){
				System.out.print(arr[i]);
			}else{
				System.out.print(arr[i]+",");
			}
		}
	}
	
	public static void prints(double[] arr){
		for(int i = 0;i<arr.length;i++){
			if(i==arr.length-1){
				System.out.print(arr[i]);
			}else{
				System.out.print(arr[i]+",");
			}
		}
	}
	/**
	 * 
	 * @Descripyion 描述
	 * @author wen
	 * @date 2020年2月17日下午9:16:32
	 * @param arr
	 *
	 */
	public static void bubble(int[] arr){
		for(int i =0;i<arr.length-1;i++){
			for(int j = 0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j+1];
					arr[j+1] =arr[j];
					arr[j] = temp;
				}
			}
		}
		prints(arr);
	}
	public static void bubble(double[] arr){
		for(int i =0;i<arr.length-1;i++){
			for(int j = 0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					double temp = arr[j+1];
					arr[j+1] =arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	public static int searchs(double[] arr,double a){
		bubble(arr);
		int max = arr.length-1;
		int min = 0;
		int mid = (max+min)/2;
		while(a != arr[mid]){
			if(a>arr[mid]){
				min = mid+1;
			}else if(a<arr[mid]){
				max = mid-1;
			}
			if(min > max){
				mid = -1;
				break;
			}
			mid = (max+min)/2;
		}
		return mid;
	}
	
}
