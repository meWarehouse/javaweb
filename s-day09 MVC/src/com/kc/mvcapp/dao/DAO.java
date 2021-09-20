package com.kc.mvcapp.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.JDBCType;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kc.mvcapp.db.JdbcUtils;

/**
 * 
 * 封装了基本的CRUD的方法，以供子类继承使用
 * 由于当前DAO 较简单没有事务 所以直接在方法中获取数据库连接
 * 整个DAO采用DBUtils 解决方案
 * @param <T> ：当前DAO处理的实体的类型是什么
 */
public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;
	
	public DAO() {
		/*
		 * public Type getGenericSuperclass()
		 * 		返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
		 * 
		 * 	Type 是 Java 编程语言中所有类型的公共高级接口。它们包括原始类型、参数化类型、数组类型、类型变量和基本类型。 
		 */
		
		Type superClass = getClass().getGenericSuperclass();
		
		//ParameterizedType 表示参数化类型
		if(superClass instanceof ParameterizedType) {
			ParameterizedType parameterizedType = (ParameterizedType)superClass;
			/*
			 * Type[] getActualTypeArguments()
			 * 		返回表示此类型实际类型参数的 Type 对象的数组
			 * 		注意，在某些情况下，返回的数组为空。如果此类型表示嵌套在参数化类型中的非参数化类型，则会发生这种情况
			 */
			Type[] typeArgs = parameterizedType.getActualTypeArguments();
			
			if(typeArgs != null && typeArgs.length > 0) {
				
				if(typeArgs[0] instanceof Class) {
					clazz = (Class<T>) typeArgs[0];
				}
				
			}
		
		}
		
		
	}
	/**
	 * 返回某一字段的值， 例如返回某一条记录的customerName，或返回数据表中有多少条记录
	 * @param <E>
	 * @param sql
	 * @param args
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <E> E getForValue(String sql,Object ... args) {
		
		Connection connection  = null;
		
		try {
			
			connection = JdbcUtils.getConnection();
			
			return (E) queryRunner.query(connection, sql, new ScalarHandler<Object>(),args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
		
	}	
	/**
	 * 返回T 所对应的List
	 * @param sql
	 * @param args
	 * @return
	 */
	public List<T> getForList(String sql,Object ... args){
		Connection connection = null;
		try {
			
			connection = JdbcUtils.getConnection();
			
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
	}
	
	/**
	 * 返回一个对应的T的实例对象
	 * @param sql
	 * @param args
	 * @return
	 */
	public T get(String sql,Object ... args) {
		
		Connection connection = null;
		try {
			
			connection = JdbcUtils.getConnection();
			
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(connection);
		}
		
		return null;
		
	}
	
	/**
	 * 该方法封装里 insert delete update 操作
	 * @param sql：SQL语句
	 * @param args：填充SQL语句的占位符
	 */
	public void update(String sql,Object ... args) {
		
		
		Connection connection  = null;
		
		try {
			
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql,args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//调用JdbcUtils的方法释放资源
			JdbcUtils.releaseConnection(connection);
			
		}
		
		
	}
	
}


