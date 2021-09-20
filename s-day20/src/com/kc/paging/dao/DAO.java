package com.kc.paging.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kc.paging.db.JdbcUtils;

public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;

	public DAO() {
		
		Type genericSuperclass = getClass().getGenericSuperclass();
		
		if(genericSuperclass instanceof ParameterizedType) {
			ParameterizedType types = (ParameterizedType) genericSuperclass;
			Type[] typeArguments = types.getActualTypeArguments();
			if(typeArguments != null && typeArguments.length > 0) {
				if(typeArguments[0] instanceof Class) {
					clazz = (Class<T>) typeArguments[0];
				}
			}
		}
	}
	
	//查询表中所有数据
	public List<T> queryAll(String sql,Object ...args){
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
		
		
	}
	
	//查询几条数据
	public <E> E getCount(String sql,Object ...args) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			
			return (E) queryRunner.query(connection, sql, new ScalarHandler<T>(),args );
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		return null;
	}
	
	
}
