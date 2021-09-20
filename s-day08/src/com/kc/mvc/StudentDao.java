package com.kc.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

	public List<Student> getAll(){
		
		//定义一个List集合，用于存放数据库接收到的数据
		List<Student> listStudents =  new ArrayList<Student>();
		
		
		//连接数据库
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		
		try {
			//获取到驱动反射
			Class.forName("oracle.jdbc.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			String user = "scott";
			String password = "tiger";
			
			connection = DriverManager.getConnection(url, user, password);
//			connection  = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			String sql = "select * from student";
			preparedStatement  = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
					
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				long idCard = resultSet.getLong(2);
				String name = resultSet.getString(3);
				String sex = resultSet.getString(4);
				double height = resultSet.getDouble(5);
				String colation = resultSet.getString(6);
				int classes = resultSet.getInt(7);
				
				
				Student student  = new Student(id, idCard, name, sex, height, colation, classes);
				
				listStudents.add(student);
				
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return listStudents;
		
	}
	
	
}
