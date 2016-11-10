package com.ctp.strategy;

import com.itqy8.ctp.CThostFtdcDepthMarketDataField;

public interface MarketTradeTrategy {

	/**
	 * 实时接收行情数据，并且计算交易策略
	 * @param pDepthMarketData
	 * @author meixinbin 2016-6-24 下午2:53:44
	 */
	public void trade(CThostFtdcDepthMarketDataField pDepthMarketData);
	
}
