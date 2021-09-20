package com.kc.mvc;

import java.util.List;

public class StudentDao1 extends DAO<Student>{

	public List<Student> getListStudent(){
		
		String sql = "select * from student";
		
		List<Student> all = getAll(sql);
		
		
		return all;
		
	}
	
	
	
}
