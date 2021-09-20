package com.kc.bookstore.test;

public class ThreadLocalTest implements Runnable{

	String name = null;
	int i = 0;
	
	@Override
	public void run() {
		for(;i < 10;i++) {
			name = Thread.currentThread().getName();
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()+":"+name);
		}
		
	}
	
	public static void main(String[] args) {
		
		ThreadLocalTest tlt = new ThreadLocalTest();
		
		new Thread(tlt, "AAA");
		new Thread(tlt, "BBB");
		
	}

}
