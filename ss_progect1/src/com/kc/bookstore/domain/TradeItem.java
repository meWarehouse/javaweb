package com.kc.bookstore.domain;

public class TradeItem {

	private Integer tradeItemId;

	// 和 TradeItem 关联的 Book
	private Book book;

	private int quantity;

	// 和 TradeItem 关联的 Book 的 bookId
	private Integer bookId;

	private Integer tradeId;

	public TradeItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public TradeItem( Integer bookId,int quantity, Integer tradeId) {
		super();
		this.quantity = quantity;
		this.bookId = bookId;
		this.tradeId = tradeId;
	}



	public Integer getTradeItemId() {
		return tradeItemId;
	}

	public void setTradeItemId(Integer tradeItemId) {
		this.tradeItemId = tradeItemId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getTradeId() {
		return tradeId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}



	@Override
	public String toString() {
		return "TradeItem [quantity=" + quantity + ", bookId=" + bookId + ", tradeId=" + tradeId + "]";
	}

	

}
