package com.blog.dao.impl;

import com.blog.bean.Me;
import com.blog.dao.MeDAO;
import com.blog.util.DBUtils;

public class MeDAOImpl  implements   MeDAO{
	private    DBUtils      dbutils=DBUtils.getDBUtils();//��ȡDBUtils����
	@Override
	public Me findMeById() {
		int   id=1;
		String   sql="select id,content,name,notice from me   where   id=?";
		//�м���ǲ������ݿ�
		Me   me=dbutils.executeQueryMe(sql, id).get(0);
		return me;
	}
        
}
