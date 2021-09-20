package com.kc.session;

public class Customer {

	private String name;
	private String address;
	private String cardtype;
	private String card;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String address, String cardtype, String card) {
		super();
		this.name = name;
		this.address = address;
		this.cardtype = cardtype;
		this.card = card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

}
