package com.kc.paging.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.kc.paging.dao.ItemDAO;
import com.kc.paging.dao.imp.ItemDAOJdbcImpl;
import com.kc.paging.domain.Item;

class TestItemDAOJdbcImpl {

	@Test
	void testQueryItemList() {
		ItemDAO itemDAO = new ItemDAOJdbcImpl();
		List<Item> items = itemDAO.queryItemList();
		for(Item item : items) {
			System.out.println(item);
		}
	}

}
