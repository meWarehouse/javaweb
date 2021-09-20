package com.kc.bookstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kc.bookstore.dao.Dao;
import com.kc.bookstore.db.JdbcUtils;
import com.kc.bookstore.utils.ReflectionUtils;
import com.kc.bookstore.web.ConnectionContext;
import com.sun.org.apache.regexp.internal.recompile;

public class BaseDAO<T> implements Dao<T> {

	private QueryRunner queryRunner = new QueryRunner();
	
	private Class<T> clazz;

	public BaseDAO() {
		
		clazz = ReflectionUtils.getSuperGenericType(getClass());
		
	}

	@Override
	public long insert(String sql, Object... args) {

		long id  = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
//			connection = JdbcUtils.getConnection();
			connection = ConnectionContext.getInstance().get();
			
			preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			if(args != null) {
				for(int i  = 0;i < args.length;i++) {
					preparedStatement.setObject(i+1, args[i]);
				}
			}
			
			preparedStatement.executeUpdate();
			
			//获取产出的主键值
			resultSet = preparedStatement.getGeneratedKeys();
			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.release(resultSet);
			JdbcUtils.release(preparedStatement);
//			JdbcUtils.release(connection);
		}

		return id;
	}

	@Override
	public void update(String sql, Object... args) {
		Connection connection = null;

		try {
//			connection = JdbcUtils.getConnection();
			connection = ConnectionContext.getInstance().get();
			
			queryRunner.update(connection, sql, args);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { JdbcUtils.release(connection); }
			 */

	}

	@Override
	public T query(String sql, Object... args) {
		Connection connection = null;

		try {
//			connection = JdbcUtils.getConnection();
			connection = ConnectionContext.getInstance().get();
			
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { JdbcUtils.release(connection); }
			 */
		return null;
	}

	@Override
	public List<T> queryForList(String sql, Object... args) {
		Connection connection = null;

		try {
//			connection = JdbcUtils.getConnection();
			connection = ConnectionContext.getInstance().get();
			
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { JdbcUtils.release(connection); }
			 */
		return null;
	}

	@Override
	public <V> V getSingleVal(String sql, Object... args) {
		Connection connection = null;

		try {
//			connection = JdbcUtils.getConnection();
			connection = ConnectionContext.getInstance().get();
			
			return (V) queryRunner.query(connection, sql, new ScalarHandler(), args);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { JdbcUtils.release(connection); }
			 */
		return null;
	}

	@Override
	public void batch(String sql, Object[] ... args) {
		Connection connection = null;

		try {
//			connection = JdbcUtils.getConnection();
			connection = ConnectionContext.getInstance().get();
			
			queryRunner.batch(connection, sql, args);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * finally { JdbcUtils.release(connection); }
			 */
	}

}
