package com.blog.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestFileReader {
         public static void main(String[] args) {
			     try {
					FileReader   fReader=new  FileReader("11.txt");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
}
