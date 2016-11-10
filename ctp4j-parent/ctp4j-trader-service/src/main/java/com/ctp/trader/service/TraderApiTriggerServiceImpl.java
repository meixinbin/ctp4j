package com.ctp.trader.service;

import com.ctp.service.TraderApiWrap;
import com.itqy8.ctp.CThostFtdcQryInvestorPositionDetailField;
import com.itqy8.ctp.CThostFtdcQryInvestorPositionField;
import com.itqy8.ctp.CThostFtdcQryTradingAccountField;
import com.itqy8.sequence.service.SequenceService;

public class TraderApiTriggerServiceImpl implements TraderApiTriggerService{

	private SequenceService sequenceService;
	
	@Override
	public void qryInvestorPosition(String brokerID, String instrumentID, String investorID) {
		CThostFtdcQryInvestorPositionField pQryInvestorPosition = new CThostFtdcQryInvestorPositionField();
		pQryInvestorPosition.setBrokerID(brokerID);
		pQryInvestorPosition.setInstrumentID(instrumentID);
		pQryInvestorPosition.setInvestorID(investorID);
		TraderApiWrap.getTraderApi().ReqQryInvestorPosition(pQryInvestorPosition,sequenceService.generate("request_id").getResult().intValue());
	}
	public void qryInvestorPositionDetail(String brokerID, String instrumentID, String investorID) {
		CThostFtdcQryInvestorPositionDetailField pQryInvestorPosition = new CThostFtdcQryInvestorPositionDetailField();
		pQryInvestorPosition.setBrokerID(brokerID);
		pQryInvestorPosition.setInstrumentID(instrumentID);
		pQryInvestorPosition.setInvestorID(investorID);
		TraderApiWrap.getTraderApi().ReqQryInvestorPositionDetail(pQryInvestorPosition,sequenceService.generate("request_id").getResult().intValue());
		
	}
	
	public void qryTradingAccount(String brokerID, String investorID) {
		CThostFtdcQryTradingAccountField tradingAccountField = new CThostFtdcQryTradingAccountField();
		tradingAccountField.setBrokerID(brokerID);
		tradingAccountField.setInvestorID(investorID);
		TraderApiWrap.getTraderApi().ReqQryTradingAccount(tradingAccountField, sequenceService.generate("request_id").getResult().intValue());
	}
	
	
	public void setSequenceService(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}
	

	
}
