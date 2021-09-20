package com.kc.mvc;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();
	private Class<T> clazz;
	
	
	public DAO() {
		Type genericSuperclass = getClass().getGenericSuperclass();
		
		if(genericSuperclass instanceof ParameterizedType) {
			
			ParameterizedType type = (ParameterizedType)genericSuperclass;
			Type[] actualTypeArguments = type.getActualTypeArguments();
			if(actualTypeArguments != null && actualTypeArguments.length > 0) {
				if(actualTypeArguments[0] instanceof Class) {
					clazz = (Class)actualTypeArguments[0];
				}
			}
		}	
	}
	
	
	public List<T> getAll(String sql,Object ...args){
		
		Connection connection = null;
		
		try {
			
			connection = JdbcUtils.getConnection();

			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz),args);
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
		
	}
	
	
	
	
}
