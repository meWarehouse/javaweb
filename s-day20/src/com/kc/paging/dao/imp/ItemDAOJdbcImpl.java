package com.kc.paging.dao.imp;

import java.util.List;

import com.kc.paging.dao.DAO;
import com.kc.paging.dao.ItemDAO;
import com.kc.paging.domain.Item;

public class ItemDAOJdbcImpl extends DAO<Item> implements ItemDAO {

	@Override
	public List<Item> queryItemList() {
		String sql = "SELECT * FROM item";

		return queryAll(sql);
	}

	

	@Override
	public List<Item> query(int start,int num) {
		// SELECT * FROM item LIMIT 起始索引,每页显示的数量;  
		String sql = "SELECT * FROM item LIMIT ?,?";
		return queryAll(sql,start ,num);
	}



	@Override
	public long queryCount() {
		String sql = "SELECT COUNT(*) FROM item";
		
		Object count = getCount(sql);
		String value = count.toString();
		long val = Long.parseLong(value);
		return val;
	}

}
