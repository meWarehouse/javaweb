package com.kc.paging.test;

import java.util.List;

import com.kc.paging.dao.ItemDAO;
import com.kc.paging.dao.imp.ItemDAOJdbcImpl;
import com.kc.paging.domain.Item;

public class T {
	public static void main(String[] args) {
		ItemDAO itemDAO = new ItemDAOJdbcImpl();
		List<Item> items = itemDAO.queryItemList();
		for(Item item : items) {
			System.out.println(item);
		}
	}
}
