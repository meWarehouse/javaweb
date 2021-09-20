package com.kc.bookstore.service;

import java.util.Set;

import com.kc.bookstore.dao.BookDAO;
import com.kc.bookstore.dao.TradeDAO;
import com.kc.bookstore.dao.TradeItemDAO;
import com.kc.bookstore.dao.UserDAO;
import com.kc.bookstore.dao.impl.BookDAOImpl;
import com.kc.bookstore.dao.impl.TradeDAOImpl;
import com.kc.bookstore.dao.impl.TradeItemDAOImpl;
import com.kc.bookstore.dao.impl.UserDAOImpl;
import com.kc.bookstore.domain.Trade;
import com.kc.bookstore.domain.TradeItem;
import com.kc.bookstore.domain.User;

public class UserService {

	private UserDAO userDAO = new UserDAOImpl();
	
	public User getUserByUserName(String username) {
		return userDAO.getUser(username);
		
	}

	private TradeDAO tradeDAO = new TradeDAOImpl();
	private TradeItemDAO tradeItemDAO = new TradeItemDAOImpl();
	private BookDAO bookDAO = new BookDAOImpl();
	
	public User getUserWithTrades(String username) {
		
//		调用 UserDAO 的方法获取 User 对象
		User user = userDAO.getUser(username);
		if(user == null) {
			return null;
		}
		
//		调用 TradeDAO 的方法获取 Trade 的集合，把其装配为 User 的属性
		Integer userId = user.getUserId();
		
		
//		调用 TradeItemDAO 的方法获取每一个 Trade 中的 TradeItem 的集合，并把其装配为 Trade 的属性
		Set<Trade> trades = tradeDAO.getTradesWithUserId(userId);
		
		if(trades != null) {
			for(Trade trade : trades) {
				int treadId = trade.getTradeId();
				Set<TradeItem> items = tradeItemDAO.getTradeItemsWithTradeId(treadId);
				
				if(items != null) {
					for(TradeItem item : items) {
						item.setBook(bookDAO.getBook(item.getBookId()));
					}
					trade.setItems(items);
				}
				
			}
		}
		
		user.setTrades(trades);
		
		return user;
	}
	
}
