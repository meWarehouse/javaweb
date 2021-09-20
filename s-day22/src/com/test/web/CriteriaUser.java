package com.test.web;

public class CriteriaUser {

	private String idCard;
	private String name;

	private int pageNo;
	
	

	public CriteriaUser(String idCard, String name, int pageNo) {
		super();
		this.idCard = idCard;
		this.name = name;
		this.pageNo = pageNo;
	}

	public CriteriaUser(int pageNo) {
		this.pageNo = pageNo;
	}

	public String getIdCard() {
		if(idCard == null) {
			idCard = "%%";
		}else {
			idCard = "%"+idCard+"%";
		}
		
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		
		if(name == null) {
			name = "%%";
		}else {
			name = "%"+name+"%";
		}
		
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

}
