package com.ctp.trader.dao;

import com.ctp.trader.entity.Trade;

public interface TradeDao {
	
	public void save(Trade trade);
	
	public Trade getTradeByOrderRef(String orderRef);
	
	/**
	 * 根据条件获取最近一次交易
	 * @param brokerID
	 * @param investorID
	 * @param instrumentID
	 * @param offsetFlag
	 * @param direction
	 * @return
	 * @author meixinbin 2016-6-22 下午4:06:09
	 */
	public Trade getLatestTrade(String brokerID,String investorID,String instrumentID,char offsetFlag,char direction);
}
