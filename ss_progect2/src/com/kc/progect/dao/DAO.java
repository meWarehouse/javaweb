package com.kc.progect.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.kc.progect.db.JDBCUtils;

public class DAO<T> {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;

	public DAO() {
		
		Type superclass = getClass().getGenericSuperclass();
		
		if(superclass instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType)superclass;
			Type[] types = paramType.getActualTypeArguments();
			
			if(types != null && types.length > 0) {
				if(types[0] instanceof Class) {
					clazz = (Class<T>) types[0];
				}
			}
			
		}
	}
	
	public List<T> getListAll(String sql,Object ...params){
		
		Connection connection = null;
		
		try {
			connection = JDBCUtils.getConnection();
			
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), params);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(connection);
		}
		
		return null;
		
	}
	
	public void addData(String sql,Object ...params) {
		Connection connection = null;
		
		try {
			connection = JDBCUtils.getConnection();
			
			queryRunner.update(connection, sql, params);
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCUtils.release(connection);
		}
		
		
	}
	
	

}
