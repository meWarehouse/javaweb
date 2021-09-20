package com.wen.progect.progect03.junit;

import org.junit.Test;

import com.wen.progect.progect03.domain.Employee;
import com.wen.progect.progect03.service.NameListService;
import com.wen.progect.progect03.service.TeamException;

/**
 * 测试TeamListService类中方法
 * @Descripyion 描述
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月2日下午8:14:01
 *
 */
public class TeamListServiceTest{
	
	@Test
	public void testGetAllEmployees(){
		NameListService service = new NameListService();
		Employee[] allEmployees = service.getAllEmployees();
		for(int i = 0;i<allEmployees.length;i++){
			System.out.println(allEmployees[i]);
		}
	}
	
	@Test
	public void testGetEmployee(){
		NameListService service = new NameListService();
		
		try {
			Employee employee = service.getEmployee(101);
			System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
