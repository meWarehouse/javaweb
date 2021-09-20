package com.kc.bookstore.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import com.kc.bookstore.dao.AccountDAO;
import com.kc.bookstore.dao.BookDAO;
import com.kc.bookstore.dao.TradeDAO;
import com.kc.bookstore.dao.TradeItemDAO;
import com.kc.bookstore.dao.UserDAO;
import com.kc.bookstore.dao.impl.AccountDAOImpl;
import com.kc.bookstore.dao.impl.BookDAOImpl;
import com.kc.bookstore.dao.impl.TradeDAOImpl;
import com.kc.bookstore.dao.impl.TradeItemDAOImpl;
import com.kc.bookstore.dao.impl.UserDAOImpl;
import com.kc.bookstore.domain.Book;
import com.kc.bookstore.domain.ShoppingCart;
import com.kc.bookstore.domain.ShoppingCartItem;
import com.kc.bookstore.domain.Trade;
import com.kc.bookstore.domain.TradeItem;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;
import com.sun.org.apache.regexp.internal.recompile;

public class BookService {

	private BookDAO bookDAO = new BookDAOImpl();
	
	public Page<Book> getPage(CriteriaBook criteriaBook){
		return bookDAO.getPage(criteriaBook);
	}

	public Book getBook(int id) {
	
		return bookDAO.getBook(id);
	}

	public boolean addToCart(int id, ShoppingCart shoppinCart) {
		
		Book book = bookDAO.getBook(id);
		
		
		
		if(book != null) {
			shoppinCart.addBook(book);
			System.out.println("---shoppinCart.getClass():"+shoppinCart.getClass());
			return true;
		}
		return false;
		
	}

	public void removeItemFromShoppingCart(ShoppingCart sc, int id) {
		
		sc.removeItem(id);
		
	}

	public void clearShoppingCart(ShoppingCart sc) {
		sc.clear();
	}

	public void updateItemQuantity(ShoppingCart sc, int id, int quantity) {
		
		sc.updateItemQuantity(id, quantity);
		
		
	}

	private AccountDAO accountDAO = new AccountDAOImpl();
	private TradeDAO tradeDAO = new TradeDAOImpl();
	private TradeItemDAO tradeItemDAO  =new TradeItemDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();
	
	public void cash(ShoppingCart shoppingCart, String username, String accountid) {
		
		//1.更新 mybooks 数据表中的相关记录 salesamount,storenumber
		bookDAO.batchUpdataStoreNumberAndsalesAmount(shoppingCart.getItems());
		
		//int i  = 10 /0;
		
		//2.更新 account 数据表的 balance
		accountDAO.updateBalance(Integer.parseInt(accountid),shoppingCart.getTotalMoney());
		
		
		//3.向 tradeitem 数据表插入一条记录
		Trade trade = new Trade();
		trade.setTradeTime(new Date(new java.util.Date().getTime()));
		trade.setUserId(userDAO.getUser(username).getUserId());
		tradeDAO.insert(trade);
		
		//4.向 tradeitem 数据表中插入 n 条记录
		Collection<TradeItem> items = new ArrayList<>();
		
		for(ShoppingCartItem sci : shoppingCart.getItems()) {
			
			TradeItem tradeItem = new TradeItem();
			tradeItem.setBookId(sci.getBook().getId());
			tradeItem.setQuantity(sci.getQuantity());
			tradeItem.setTradeId(trade.getTradeId());//使用 BaseDAO 中的 insert 方法 返回 tradeid
			
			items.add(tradeItem);
			
		}
		
		tradeItemDAO.batchSave(items);
		
		//5.清空购物车
		shoppingCart.clear();
		
	}

	
	
}
