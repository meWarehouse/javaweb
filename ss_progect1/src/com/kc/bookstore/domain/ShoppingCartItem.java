package com.kc.bookstore.domain;

/**
 * 封装了购物车中的商品, 包含对商品的引用以及购物车中该商品的数量
 *
 */
public class ShoppingCartItem {

	private Book book;//书
	private int quantity;//购买对应的书的的数量

	public ShoppingCartItem(Book book) {
		this.book = book;
		this.quantity = 1;
	}

	public Book getBook() {
		return book;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 返回该商品在购物车中的总金额 book.getPrice() * quantity
	 * 
	 * @return
	 */
	public float getItemMoney() {
		return book.getPrice() * quantity;
	}

	/**
	 * 使商品数量 + 1
	 */
	public void increment() {
		quantity++;
	}

}
