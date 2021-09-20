package com.kc.bookstore.domain;

import java.sql.Date;

public class Book {

	private Integer id;
	private String author;

	private String title;
	private Float price;

	private Date publishingDate;
	private Integer salesaMount;

	private Integer storeNumber;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public Integer getSalesaMount() {
		return salesaMount;
	}
	public void setSalesaMount(Integer salesaMount) {
		this.salesaMount = salesaMount;
	}

	public Integer getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(Integer storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", price=" + price + ", publishingDate="
				+ publishingDate + ", salesMount=" + salesaMount + ", storeNumber=" + storeNumber + ", remark=" + remark
				+ "]\n\n";
	}

}
