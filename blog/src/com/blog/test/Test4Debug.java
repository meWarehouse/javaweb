package com.blog.test;

import org.junit.Test;

public class Test4Debug {
	@Test
	public void test() {
		System.out.println(1);
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			show();
		}
		System.out.println("game over");
	}

	public static void show() {
		System.out.println("这是执行show方法!");
	}

}
