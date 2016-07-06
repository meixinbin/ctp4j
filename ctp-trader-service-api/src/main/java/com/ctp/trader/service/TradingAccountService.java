package com.ctp.trader.service;

import com.ctp.trader.dto.TradingAccountDTO;

public interface TradingAccountService {

	/**
	 * 查询资金账户
	 * @param brokerID
	 * @param investorID
	 * @return
	 * @author meixinbin 2016-6-13 下午4:59:19
	 */
	public TradingAccountDTO getTradingAccount(String brokerID,String investorID);
}
