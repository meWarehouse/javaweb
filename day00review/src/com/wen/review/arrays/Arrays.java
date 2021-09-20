package com.wen.review.arrays;

import java.util.Scanner;

public class Arrays {
	public static void main(String[] args){
		
		/*
		 *	数组
		 *	
		 *			 	
		 */
		
		//一维数组
//		int[] a;
//		int b[];
//		a = new int[2];
//		b = new int[9];
		int b[] = new int[3];
		b[0] = 1;
		int[] a = {1,2,3,5};
		System.out.println(b);
		System.out.println(a);
		for(int i =0;i<a.length;i++){
			System.out.println(a[i]);
		}
		for(int i:a){
			System.out.println(i);
		}
			
//		int[] a1[];
//		int b1[][];
//		a1 = new int[2][];
//		b1 = new int[9][];
//		int[] b1,a1[];
		int a1[][] = new int[4][2];
		a1[0] = new int[3];
		a1[2] = new int[2];
		a1[0][1] = 2;
		a1[1][1] = 4;
		int b1[][] = {{1,2,3},{2,4},{5}};
		for(int i=0;i<b1.length;i++){
			for(int j=0;j<b1[i].length;j++){
				System.out.println(b1[i][j]);
			}
		}
		
		
		System.out.println("------------------------------------------------------------");
		
		
		/*
		 * 杨辉三角
		 */
		int[][] yanghui = new int[10][];
		for(int i=0;i<yanghui.length;i++){
			yanghui[i] = new int[i+1];
			yanghui[i][0] = yanghui[i][i] = 1;
			
			for(int j=1;j<yanghui[i].length-1;j++){
				 yanghui[i][j] = yanghui[i-1][j]+yanghui[i-1][j-1];
			}
			
		}
		for(int i = 0;i<yanghui.length;i++){
			for(int j =0;j<yanghui[i].length;j++){
				System.out.print(yanghui[i][j]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("-------------------------------------------------------------");
		
		/*
		 * 
		 * 1.创建一个长度为6的int类型数组，要求数组元素的值在1-30之间，且是随机赋值，同时要求元素的值个不相同
		 * 
		 */

		/*
		 * 1.定义一个int数组类型的数组，包含10个元素，分别赋一些随机整数
		 * 	 然后求出所有元素的最大值，最小值，和，平均值
		 * 要求：
		 * 	所有的随机数都是两位数
		 *	[10-99]:(int)(Math.random()*(99-10+1)+10)
		 * 
		 * 
		 */
		
		//定义一个长度为10 的数组
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++ ){
			arr[i] = (int)(Math.random()*(99-10+1)+10);
		}
		
		for(int i:arr){
			System.out.print(i+"\t");
		}
		
		//求最大值
		int max = arr[0];
		for(int i= 0;i<arr.length;i++){
			if(arr[i]>max){
				max = arr[i];
			}
		}
		System.out.println(max);
		
		//求最小值
		int min = arr[0];
		for(int i=0;i<arr.length;i++){
			if(arr[i]<min){
				min = arr[i];
			}
		}
		System.out.println(min);
		//求总和
		int sum = 0;
		for(int i:arr){
			sum+=i;
		}
		//求平均值
		double avg = sum/10.0;
		System.out.println(sum+","+avg);
		System.out.println("----------------------------------------------------------------");
		
		/*
		 * 数组复制
		 * 
		 */
		int[] array2;
		int[] array1 = {2,3,5,7,11,13,17,19};
		
		for(int i:array1){
			System.out.print(i+"\t");
		}
		System.out.println();
		//赋值array2变量等于array1变量
		array2 = array1;//地址值  赋值  不是复制
		
		//修改array2中的偶数索引元素，使其等于索引值
		for(int i=0;i<array2.length;i++){
			if(i%2 == 0){
				array2[i] = i;
			}
		}
		for(int i:array2){
			System.out.print(i+"\t");
		}
		System.out.println();
		for(int i:array1){
			System.out.print(i+"\t");
		}
		
		//数组复制
		int[] array3 = new int[array1.length];
		for(int i = 0;i<array3.length;i++){
			array3[i] = array1[i];
		}
		System.out.println();
		System.out.println("----------------------------------------------------------------");
		/*
		 * 反转
		 */
		//方法一
		for(int i = 0;i<array1.length/2;i++){
			int temp = array1[i];
			array1[i] = array1[array1.length-1-i];
			array1[array1.length-1-i] = temp;
		}
		for(int i:array1){
			System.out.print(i+"\t");
		}
		System.out.println();
		//方法二
		for(int i=0,j=array2.length-1;i<j;i++,j--){
			int temp = array2[i];
			array2[i] = array2[j];
			array2[j] = temp;
		}
		for(int i:array2){
			System.out.print(i+"\t");
		}
		System.out.println();
		/*
		 * 查找
		 * 	1.线性查找
		 * 	2.二分差找
		 * 
		 */
		//array2:0	3	2	7	4	13	6	19
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("请输入要查找的数：");
//		
//		while (!sc.hasNextInt()) {
//			System.out.print("输入错误请重新输入：");
//		}
//		int aa = sc.nextInt();
//		boolean isFlat = true;
//		
//		//线性查找
//		for(int i=0;i<array2.length;i++){
//			if(aa == array2[i]){
//				System.out.println("有："+i);
//				isFlat = false;
//				break;
//			}
//		}
//		if(isFlat){
//			System.out.println("很遗憾，没有找到哦！！");
//		}
		
		//二分查找
//		System.out.print("请输入要查找的数：");
//		int a2 = sc.nextInt();
//		int[] array4 = {1,2,3,4,5,6,7,9};
//		
//		int minIndex = 0;
//		int maxIndex = array4.length-1;
//		boolean is = true;
//		while(minIndex<=maxIndex){
//			int midIndex = (maxIndex-minIndex)/2;
//			if(a2 == array4[midIndex]){
//				System.out.println("有"+midIndex);
//				is = false;
//				break;
//			}else if(a2>array4[midIndex]){
//				midIndex = midIndex+1;
//			}else if(a2<array4[midIndex]){
//				maxIndex = midIndex-1;
//			}
//		}
//		if(is){
//			System.out.println("很遗憾，没有找到哦！！");
//		}
		System.out.println("---------------------------------------");
		
		/*
		 * 冒泡排序
		 * 
		 */
		//array2:0	3	2	7	4	13	6	19
		for(int i = 0;i<array2.length-1;i++){
			for(int j = 0;j<array2.length-1-i;j++){
				if(array2[j]>array2[j+1]){
					int temp = array2[j+1];
					array2[j+1] = array2[j];
					array2[j] = temp;
				}
			}
		}
		prints(array2);
		java.util.Arrays.toString(array3);
		
		/*
		 * 堆排序
		 * 快速排序
		 * 归并排序
		 * 
		 */
		
		
		
		
		
		
		

	}
	public static void prints(int arr[]){
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
	}
	
	public static void prints(double arr[]){
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]+"\t");
		}
	}
	
}
