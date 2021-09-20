package com.kc.bookstore.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.kc.bookstore.dao.DAO;
import com.kc.bookstore.db.JdbcUtils;
import com.sun.org.apache.regexp.internal.recompile;

public class BaseDAO<T> implements DAO<T> {
	private QueryRunner queryRunner = new QueryRunner();
	private Class<T> clazz;

	public BaseDAO() {
		Type superclass = getClass().getGenericSuperclass();
		if (superclass instanceof ParameterizedType) {
			ParameterizedType paramTypes = (ParameterizedType) superclass;
			Type[] types = paramTypes.getActualTypeArguments();
			if (types != null && types.length > 0) {
				if (types[0] instanceof Class) {
					clazz = (Class<T>) types[0];
				}
			}
		}
	}

	@Override
	public long insert(String sql, Object... args) {
		long id = 0;
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JdbcUtils.getConnection();

			prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					prepareStatement.setObject(i + 1, args[i]);
				}
			}

			prepareStatement.executeLargeUpdate();

			resultSet = prepareStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getLong(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
			JdbcUtils.release(prepareStatement);
			JdbcUtils.release(resultSet);
		}

		return id;
	}

	@Override
	public void update(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			
			queryRunner.update(connection, sql, args);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
		}

	}

	@Override
	public T query(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			
			return queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
		}

		return null;
	}

	@Override
	public List<T> queryForList(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			
			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
		}

		return null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public <V> V getSingleValue(String sql, Object... args) {
		Connection connection = null;

		try {
			connection = JdbcUtils.getConnection();
			
			return (V) queryRunner.query(connection, sql, new ScalarHandler(), args);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.release(connection);
		}

		return null;
	}
}
