package com.kc.mvc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AAA {
//	public static void main(String[] args) {
	public static void main(String[] args) throws SQLException {

		StudentDao1 s = new StudentDao1();
		List<Student> listStudent = s.getListStudent();
		for(Student stu : listStudent) {
			System.out.println(stu);
		}
	}
}
