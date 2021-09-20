package com.wen.review.oops;

public class RecursionTest{
	public static void main(String[] args){
		/*
		 * recursion 递归
		 * 	1.递归方法：一个方法体内调用它本身
		 *  2.方法递归包含了一种隐士的循环，它会重复的执行某段代码，但这种重复执行无需循环语句控制
		 *  3.递归一定要向已知的方向递归，否则这种递归就变成了死递归
		 * 
		 */
		
		
		//例1：求1-100内所有自然数的和
		int sum = 0;
		for(int i = 0;i<=100;i++){
			sum+=i;
		}
		System.out.println(sum);
		
		RecursionTest t1 = new RecursionTest();
		System.out.println(t1.Sum(100));
		
		System.out.println(t1.Sum1(10));
		
		System.out.println(t1.seriesSum(10));
		
		System.out.println(t1.Fibo(10));
		
	}
	
	//求1-100内所有自然数的和
	public int Sum(int n){
		if(n==1){
			return 1;
		}else{
			return n+Sum(n-1);
		}
	}
	
	//求1-10内所有自然数的乘积 n!
	public int Sum1(int n){
		if(n==1){
			return 1;
		}else{
			return n*Sum1(n-1);
		}
	}
	
	
	//例3：已知有一个数列 f(0)=1,f(1)=4，f(n+2)=2*f(n+1)+f(n),其中n是大于0的整数，求f(10)的值
	public int seriesSum(int n){
		if(n==0){
			return 1;
		}else if(n==1){
			return 4;
		}else{
			return 2*seriesSum(n-1)+seriesSum(n-2);
//			return seriesSum(n+2)-2*seriesSum(n+1);错误 
		}
	}
	
	
	//例4：斐波那契数列
	public int Fibo(int n){
		if(n==1){
			return 1;
		}else if(n==2){
			return 1;
		}else{
			return Fibo(n-1)+Fibo(n-2);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	  
	
	
	
	
	
}
