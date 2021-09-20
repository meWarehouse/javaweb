package com.kc.bookstore.dao;

import com.kc.bookstore.domain.Account;

public interface AccountDAO {

	/**
	 * 根据 accountId 获取对应的 Account 对象
	 * @param accountId
	 * @return
	 */
	public abstract Account get(Integer accountId);
	
	/**
	 * 根据传入的 accountId, amount 更新指定的账户余额：扣除 Amount 指定的钱数
	 * @param accountId
	 * @param amount
	 */
	public abstract void updateBalance(Integer accountId,float amount);
	
}
