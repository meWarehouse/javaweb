package com.wen.review.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {
	public static void main(String[] args){
		
		/*
		 * 面试题目：创建一个长度为6的int型数组，要求取值为1-30，同时元素值各不相同
		 */
		//创建一个长度为6的int型数组[0,1)
		int arr1[] = new int[6];
		//取值为1-30(int)(Math.random()*(30-1+1)+1)
		for(int i = 0;i<arr1.length;i++){
			
			arr1[i] = (int)(Math.random()*30+1);

			for(int j = 0;j<i;j++){
				if(arr1[i] == arr1[j]){
					//arr1[i] = (int)(Math.random()*30+1);
					i--;//********************
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println("-----------------------------------------------------");
		 
		//回形数格式方阵的实现
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一个数字：");
		int len = sc.nextInt();
		int[][] arr2 = new int[len][len];
		
		/*
		arr2[0][0] = 1;
		arr2[0][1] = 2;
		arr2[0][2] = 3;
		...
		arr2[0][len-1] = len;
		
		arr2[1][len-1] = 1;
		arr2[2][len-1] = 2;
		...
		arr2[len-1][len-1] = 2;
		
		
		*/
//		for(int i = 0;i<arr2.length;i++){
//			for(int j=0;j<arr2[i].length;j++ ){
//				arr2[i][j] = j;
//				if(j == arr2[i].length-1){
//					i=j;
//					i--;
//					arr2[i][j] = j++;
//				}
//			}
//			
//		}
//		
//		for(int i = 0;i<arr2.length;i++){
//			for(int j=0;j<arr2[i].length;j++){
//				System.out.print(arr2[i][j]+"\t");
//			}
//			System.out.println();
//		}
//		
		int n = 7;
		int[][] arr = new int[n][n];

		int count = 0; // 要显示的数据
		int maxX = n - 1; // x轴的最大下标
		int maxY = n - 1; // Y轴的最大下标
		int minX = 0; // x轴的最小下标
		int minY = 0; // Y轴的最小下标
		while (minX <= maxX) {
			for (int x = minX; x <= maxX; x++) {
				arr[minY][x] = ++count;
			}
			minY++;
			for (int y = minY; y <= maxY; y++) {
				arr[y][maxX] = ++count;
			}
			maxX--;
			for (int x = maxX; x >= minX; x--) {
				arr[maxY][x] = ++count;
			}
			maxY--;
			for (int y = maxY; y >= minY; y--) {
				arr[y][minX] = ++count;
			}
			minX++;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				String space = (arr[i][j] + "").length() == 1 ? "0" : "";
				System.out.print(space + arr[i][j] + " ");
			}
			System.out.println();
		}


		
	}
	
	
}
