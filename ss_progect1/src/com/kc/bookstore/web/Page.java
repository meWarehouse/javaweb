package com.kc.bookstore.web;

import java.util.List;


public class Page<T> {

	//当前第几页
	private int pageNo;
	
	//当前页的 List
	private List<T> list;
	
	//每页显示多少条记录
	private int pageSize = 3;
	
	//一共有多少条记录
	private int totalItemNumber;

	//构造器中需要对 pageNo 进行初始化
	public Page(int pageNo) {
		super();
		this.pageNo = pageNo;
	}
	
	//需要校验一下 页数是否合法
	public int getPageNo() {
		if(pageNo < 0) {
			pageNo = 1;
		}
		if(pageNo >= getTotalPageNumber()) {
			pageNo = getTotalPageNumber();
		}
		return pageNo;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	//获取总页数
	public int getTotalPageNumber() {
		
		int totalPageNumber = (int) (totalItemNumber / pageSize);
		if(totalItemNumber % pageSize != 0) {
			totalPageNumber++;
		}
		
		
		return totalPageNumber;
	}
	
	
	public void setTotalItemNumber(long totalItemNumber) {
		this.totalItemNumber = (int) totalItemNumber;
	}
	
	//判断有无下一页
	public boolean isHasNext() {
		
		if(getPageNo() < getTotalPageNumber()) {
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
	public int getPervPage() {
		if(isHasPrev()) {
			return getPageNo() - 1 ;
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
