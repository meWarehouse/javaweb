package com.test.dao;

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

import com.sun.org.apache.regexp.internal.recompile;
import com.test.db.JdbcUtils;

public class DAO<T> {

	private QueryRunner queryRunner = new QueryRunner();
	private Class<T> clazz;

	public DAO() {
		Type superclass = getClass().getGenericSuperclass();
		if (superclass instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType) superclass;
			Type[] types = paramType.getActualTypeArguments();
			if (types != null && types.length > 0) {
				if (types[0] instanceof Class) {
					clazz = (Class<T>) types[0];
				}

			}
		}
	}

	public List<T> getForList(String sql, Object... params) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();

			return queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public T get(String sql, Object... params) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return queryRunner.query(connection, sql, new BeanHandler<>(clazz), params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void update(String sql, Object... params) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			queryRunner.update(connection, sql, params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public <V> V getSingleValue(String sql, Object... params) {
		Connection connection = null;
		try {
			connection = JdbcUtils.getConnection();
			return (V) queryRunner.query(connection, sql, new ScalarHandler<>(), params);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public int insert(String sql, Object... params) {

		long id = 0;
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			connection = JdbcUtils.getConnection();

			prepareStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					prepareStatement.setObject(i + 1, params[i]);
				}
			}

			prepareStatement.executeLargeUpdate();

			resultSet = prepareStatement.getGeneratedKeys();

			if(resultSet.next()) {
				id = resultSet.getLong(1);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.release(connection);
			JdbcUtils.release(resultSet);
			JdbcUtils.release(prepareStatement);
		}

		return (int) id;

	}

	public void batch() {

	}

}
