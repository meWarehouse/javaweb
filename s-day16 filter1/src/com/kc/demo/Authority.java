package com.kc.demo;

public class Authority {
	private String displayName;// 权限名
	// 权限对应的 URL 地址：已有权限对应着一个 URL
	private String url;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Authority(String displayName, String url) {
		super();
		this.displayName = displayName;
		this.url = url;
	}

	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

}
