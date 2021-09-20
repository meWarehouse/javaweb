package com.kc.bookstore.web;

import java.util.List;

public class Page<T> {
	// 当前第几页
	private Integer pageNo;
	// 当前页的List
	private List<T> list;
	// 每页显示的记录条数
	private int pageSize = 3;
	// 一共有多少条记录
	private int totalItemNumber;

	public Page(int pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageNo() {
		
		if(pageNo < 0 ) {
			pageNo = 1;
		}else if(pageNo >= getTotalPageNumber()) {
			pageNo = getTotalPageNumber();
		}
		
		return pageNo;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = (int) totalItemNumber;
	}

	//获取总页数
	public int getTotalPageNumber() {
		
		int totalPageNumber = (int)(totalItemNumber / pageSize);
		if(totalItemNumber % pageSize != 0) {
			totalPageNumber++;
		}
		
		return totalPageNumber;
		
	}
	
	
	// 判断有无下一页
	public boolean isHasNext() {
		if(getPageNo() < getTotalPageNumber() ) {
			return true;
		}
		
		return false;
	}
	
	//判断有无上一页
	public boolean isHasPrev() {
		if(getPageNo() > 1) {
			return true;
		}
		return false;
	}
	
	
	//返回上一页
	public int getPrevPage() {
		if(isHasPrev()) {
			return getPageNo() - 1;
		}
		return getPageNo();
	}
	
	//下一页
	public int getNextPage() {
		if(isHasNext()) {
			return getPageNo() + 1;
		}
		return getPageNo();
	}
	

}
