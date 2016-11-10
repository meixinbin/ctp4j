package com.ctp.trader.service;

/**
 * 触发交易API回调
 * @author meixinbin
 * @2016-6-14
 */
public interface TraderApiTriggerService {

	public void qryInvestorPosition(String brokerID,String instrumentID,String investorID);
	
	public void qryInvestorPositionDetail(String brokerID, String instrumentID, String investorID);
	
	
	public void qryTradingAccount(String brokerID, String investorID);
	
}
