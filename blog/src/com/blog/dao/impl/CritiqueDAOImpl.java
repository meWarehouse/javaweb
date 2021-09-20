package com.blog.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.blog.bean.Critique;
import com.blog.dao.CritiqueDAO;
import com.blog.util.DBUtils;

public class CritiqueDAOImpl implements CritiqueDAO {
	private DBUtils dbutils = DBUtils.getDBUtils();// ��ȡDBUtils����

	@Override
	public int addCritique(Critique critique) {

//		String   time=new  SimpleDateFormat("yyyy-MM-dd E hh:mm:ss").format(new  Date());
		String time = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		String sql = "insert  into  critique(name,content,time)values(?,?,?)";
		int num = dbutils.executeUpdate(sql, critique.getName(), critique.getContent(), time);
		return num;
	}

	@Override
	public List<Critique> findCritiquesAll() {
		String sql = "select  *  from   critique";
		List<Critique> list = dbutils.findCritique(sql);
		return list;
	}

	@Override
	public List<Critique> findCritiquesByPage(int page) {
		int num = 5;
		int index = (page - 1) * num;// ���±�
		// ��һ���ʺ����±꣬�ڶ����ʺ��Ǵ���һҳ����
		String sql = "select  * from   critique order   by   id  desc  limit ?,?";
		List<Critique> critiquesPage = dbutils.findCritique(sql, index, num);
		return critiquesPage;
	}

	@Override
	public List<Critique> findCritiquesNew() {
		int numNew = 5;
		String sql = "select  *  from  critique  order  by  id  desc limit ?";
		return dbutils.findCritique(sql, numNew);
	}

	@Override
	public int findTotalPage() {
		List<Critique> critiquesAll = findCritiquesAll();
		int sum = critiquesAll.size();// �ܹ����ٸ�
		int num = 5; // һҳ����
		int totalPage;
		if (sum % 5 == 0) {
			totalPage = sum / 5;
		} else {
			totalPage = sum / 5 + 1;// ��������ҳ���ͼ�1
		}
		return totalPage;
	}
}
