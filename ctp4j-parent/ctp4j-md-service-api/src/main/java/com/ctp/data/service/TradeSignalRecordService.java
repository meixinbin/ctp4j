package com.ctp.data.service;

import com.ctp.data.entity.TradeSignalRecord;

public interface TradeSignalRecordService {

	/**
	 * 保存交易记录
	 * @param tradeSignalRecord
	 * @author meixinbin 2016-8-12 下午5:38:38
	 */
	public void save(TradeSignalRecord tradeSignalRecord);
	
	/**
	 * 获取信号数据
	 * @param strategyCode
	 * @param endTime
	 * @return
	 * @author meixinbin 2016-8-16 下午3:50:35
	 */
	public TradeSignalRecord getTradeSignalRecord(String strategyCode,long endTime);
}
