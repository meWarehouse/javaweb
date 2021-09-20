package com.kc.bookstore.domain;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class Trade {
	// Trade 对象对应的 id
	private Integer tradeId;

	// 交易的时间
	private Date tradeTime;

	// Trade 关联的多个 TradeItem
	private Set<TradeItem> items = new LinkedHashSet<TradeItem>();

	// 和 Trade 关联的 User 的 userId
	private Integer userId;

	public Integer getTradeId() {
		return tradeId;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public Set<TradeItem> getItems() {
		return items;
	}

	public void setItems(Set<TradeItem> items) {
		this.items = items;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeTime=" + tradeTime + ", userId=" + userId + "]\n";
	}

	
	

}
