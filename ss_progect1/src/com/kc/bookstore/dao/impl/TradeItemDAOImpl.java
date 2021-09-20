package com.kc.bookstore.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.kc.bookstore.dao.TradeItemDAO;
import com.kc.bookstore.domain.TradeItem;

public class TradeItemDAOImpl extends BaseDAO<TradeItem> implements TradeItemDAO{

	@Override
	public void batchSave(Collection<TradeItem> items) {
		
		//INSERT INTO tradeitem(bookid,quantity,tradeid) VALUES(1,10,18);
		String sql = "INSERT INTO tradeitem(bookid,quantity,tradeid) VALUES(?,?,?)";
		
		Object[][] args = new Object[items.size()][3];
		
		ArrayList<TradeItem> tradeItems = new ArrayList<TradeItem>(items);
		
		for(int i = 0;i < items.size();i++) {
			args[i][0] = tradeItems.get(i).getBookId();
			args[i][1] = tradeItems.get(i).getQuantity();
			args[i][2] = tradeItems.get(i).getTradeId();
		}
		
		batch(sql, args);
		
	}

	@Override
	public Set<TradeItem> getTradeItemsWithTradeId(Integer tradeId) {
		
		String sql = "SELECT * FROM tradeitem WHERE tradeId = ?";
		
		return new HashSet<TradeItem>(queryForList(sql, tradeId));
	}

}
