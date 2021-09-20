package com.kc.bookstore.dao.impl;


import java.sql.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.kc.bookstore.dao.TradeDAO;
import com.kc.bookstore.domain.Trade;

public class TradeDAOImpl extends BaseDAO<Trade> implements TradeDAO{

	@Override
	public void insert(Trade trade) {
		String sql = "INSERT INTO trade (userid,tradetime) VALUES(?,?)";
		//long tradeId = insert(sql, trade.getUserId(),trade.getTradeTime());
		//trade.setTradeId((int)tradeId);
		
		long tradeId = insert(sql, trade.getUserId(),trade.getTradeTime());
		
		trade.setTradeId((int)tradeId);
		
	}

	@Override
	public Set<Trade> getTradesWithUserId(Integer userId) {
	
		String sql = "SELECT * FROM trade WHERE userId = ? ORDER BY tradeTime DESC";
		
//		return new HashSet<>(queryForList(sql, userId));
		
		return new LinkedHashSet<Trade>(queryForList(sql, userId));
	}

}
