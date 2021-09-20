package com.kc.paging.dao;

import java.util.List;

import com.kc.paging.domain.Item;

public interface ItemDAO {
	
	public List<Item> queryItemList();
	
	/**
	 * 数据库中的数据索引从 0 开始
	 * @param start 
	 * @param limit
	 * @return
	 */
	public List<Item> query(int start,int limit);
	
	public long queryCount();
	
}
