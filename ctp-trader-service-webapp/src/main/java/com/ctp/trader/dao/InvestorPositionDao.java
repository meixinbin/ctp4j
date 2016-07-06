package com.ctp.trader.dao;

import java.util.List;

import com.ctp.trader.entity.InvestorPosition;

public interface InvestorPositionDao {
	
	public void save(InvestorPosition investorPosition);
	
	public List<InvestorPosition> getInvestorPosition(String brokerID,String instrumentID,String investorID);
	
	public InvestorPosition getInvestorPosition(String brokerID,String instrumentID,String investorID,char posiDirection,char positionDate);
}
