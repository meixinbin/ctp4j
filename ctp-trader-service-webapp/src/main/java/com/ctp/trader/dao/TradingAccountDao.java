package com.ctp.trader.dao;

import com.ctp.trader.entity.TradingAccount;

public interface TradingAccountDao {

	public void save(TradingAccount ta);
	
	public TradingAccount get(String brokerID,String accountID);
}
