package com.test.web;

import java.util.List;


public class Page<T> {

	private int pageNo;

	private int pageSize = 3;

	private List<T> list;

	private long totalItemNumber;

	public Page(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageNo() {

		if (pageNo >= getTotalPageNumber()) {
			pageNo = getTotalPageNumber();
		}

		if (pageNo <= 0) {
			pageNo = 1;
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getTotalItemNumber() {
		return totalItemNumber;
	}

	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = totalItemNumber;
	}

	public int getTotalPageNumber() {

		int pages = (int) (getTotalItemNumber() / getPageSize());
		if (getTotalItemNumber() / getPageSize() != 0) {
			pages++;
		}
		return pages;
	}
	
	public boolean isHasPrev() {
		if(getPageNo() > 1) {
			return true;
		}
		
		return false;
		
	}

	public boolean isHasNext() {
		if(getPageNo() < getTotalPageNumber() ) {
			return true;
		}
		return false;
		
	}
	
	public int getPrevPage() {
		if(isHasPrev()) {
			return getPageNo() - 1;
		}
		return getPageNo();
	}
	
	public int getNextPage() {
		if(isHasNext()) {
			return getPageNo() + 1;
		}
		return getPageNo();
	}
	
	
	
	
	
	
	

}
