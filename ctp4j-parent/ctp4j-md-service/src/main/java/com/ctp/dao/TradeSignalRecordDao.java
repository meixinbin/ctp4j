package com.ctp.dao;

import com.ctp.data.entity.TradeSignalRecord;

public interface TradeSignalRecordDao {

	/**
	 * 保存
	 * @param tradeRecord
	 * @author meixinbin 2016-8-12 下午5:41:33
	 */
	public void save(TradeSignalRecord tradeSignalRecord);
	
	
	public TradeSignalRecord getTradeSignalRecord(String strategyCode, long endTime);
}
