package com.kc.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.Set;

import org.junit.jupiter.api.Test;

import com.kc.bookstore.dao.TradeDAO;
import com.kc.bookstore.dao.impl.TradeDAOImpl;
import com.kc.bookstore.domain.Trade;

class TreadDAOTest {

	private TradeDAO tradeDAO = new TradeDAOImpl();
		
	
	@Test
	void testInsertTrade() {
		
		Trade trade = new Trade();
		
		trade.setUserId(3);
		trade.setTradeTime(new Date(new java.util.Date().getTime()));
		
		tradeDAO.insert(trade);
		
	}

	@Test
	void testGetTradesWithUserId() {
		
		
		Set<Trade> tradesWithUserId = tradeDAO.getTradesWithUserId(1);
		System.out.println(tradesWithUserId);
	}

}
