package com.wen.review.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class ReadTest {

	@Test
	public void testRead() {

		// 读取文件 InputStream

		// 字节流
		InputStream is = null;

		try {
			// 获取到需要读取的文件
			is = new FileInputStream(new File("D:\\JavaLearn\\java\\javaEE-workspace\\day00review\\src\\com\\wen\\review\\io\\iotest.txt"));

			//读取文件，并输出在控制台
			
//			System.out.println(System.currentTimeMillis());
			
			int read = is.read();
			while(read != -1){
				System.out.println(read);
				
			}
			
//			System.out.println(System.currentTimeMillis());
			
			
			
			
			
			
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
