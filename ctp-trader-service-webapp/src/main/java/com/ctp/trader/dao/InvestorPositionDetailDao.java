package com.ctp.trader.dao;

import java.util.List;

import com.ctp.trader.entity.InvestorPositionDetail;

public interface InvestorPositionDetailDao {


	public void save(InvestorPositionDetail investorPositionDetail);
	
	public List<InvestorPositionDetail> getInvestorPositionDetail(String brokerID,String instrumentID,String investorID);
	
	public InvestorPositionDetail getInvestorPositionDetail(String brokerID,String instrumentID,String investorID,String tradeID);
	
	/**
	 * 获取最新一条持仓明细
	 * @param brokerID
	 * @param instrumentID
	 * @param investorID
	 * @return
	 * @author meixinbin 2016-6-21 下午1:44:21
	 */
	public InvestorPositionDetail getLatestPositionDetail(String brokerID,String instrumentID,String investorID,String direction);
}
