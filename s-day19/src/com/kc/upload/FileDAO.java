package com.kc.upload;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import jdk.nashorn.internal.scripts.JS;

public class FileDAO {
	
	private QueryRunner queryRunner = new QueryRunner();
	
	public void insertData(TFile tfile) {
		
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "insert into test(fileName,filePath) values(?,?)";
			
			queryRunner.update(conn, sql, tfile.getFileName(),tfile.getFilePath());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(conn);
		}
		
		
	}
	
	
	public List<TFile> queryAll(){
		
		List<TFile> listFile = new ArrayList<TFile>();
		
		Connection conn = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "SELECT * FROM test";
			
			listFile = queryRunner.query(conn, sql, new BeanListHandler<TFile>(TFile.class));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(conn);
		}
		
		return listFile;
		
	}
	
	
	public TFile getTFile(Integer id) {
		
		Connection conn = null;
		TFile tfile = null;
		try {
			conn = JdbcUtils.getConnection();
			String sql = "SELECT * FROM test WHERE fileId = ?";
			
			tfile = queryRunner.query(conn, sql, new BeanHandler<TFile>(TFile.class),id );
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.releaseConnection(conn);
		}
		
		return tfile;
		
	}
	
	
	
}
