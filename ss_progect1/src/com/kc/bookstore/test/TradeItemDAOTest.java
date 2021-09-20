package com.kc.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.kc.bookstore.dao.TradeItemDAO;
import com.kc.bookstore.dao.impl.TradeItemDAOImpl;
import com.kc.bookstore.domain.TradeItem;

class TradeItemDAOTest {
	
	private TradeItemDAO tradeItemDAO = new TradeItemDAOImpl();

	@Test
	void testBatchSave() {
		
		Collection<TradeItem> items = new ArrayList<TradeItem>();
		
		
		items.add(new TradeItem(1, 10, 18));
		items.add(new TradeItem(2, 20, 18));
		items.add(new TradeItem(3, 30, 18)); 
		items.add(new TradeItem(4, 40, 18)); 
		items.add(new TradeItem(5, 50, 18));
		 
		
		tradeItemDAO.batchSave(items);
	}

	@Test
	void testGetTradeItemsWithTradeId() {
		
		Set<TradeItem> items = tradeItemDAO.getTradeItemsWithTradeId(18);
		
		System.out.println(items);
	}

}
