package com.ctp.trader.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Trade implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8179393511435080274L;

	@Id
	private Long id;
	
	private String brokerID;
	
	private String investorID;
	
	private String instrumentID;
	
	private String orderRef;
	
	private String userID;
	
	private String exchangeID;
	
	private String tradeID;
	
	private char direction;
	
	private String orderSysID;
	
	private String participantID;
	
	private String clientID;
	
	private char tradingRole;
	
	private String exchangeInstID;
	
	private char offsetFlag;
	
	private char hedgeFlag;
	
	private double price;
	
	private int volume;
	
	private String tradeDate;
	
	private String tradeTime;
	
	private String tradeType;
	
	private char priceSource;
	
	private String traderID;
	
	private String orderLocalID;
	
	private String clearingPartID;
	
	private String businessUnit;
	
	private int sequenceNo;
	
	private String tradingDay;
	
	private int settlementID;
	
	private int brokerOrderSeq;
	
	private char tradeSource;

	private long tradeDateTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBrokerID() {
		return brokerID;
	}

	public void setBrokerID(String brokerID) {
		this.brokerID = brokerID;
	}

	public String getInvestorID() {
		return investorID;
	}

	public void setInvestorID(String investorID) {
		this.investorID = investorID;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public String getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getExchangeID() {
		return exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}

	public String getTradeID() {
		return tradeID;
	}

	public void setTradeID(String tradeID) {
		this.tradeID = tradeID;
	}

	public char getDirection() {
		return direction;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public String getOrderSysID() {
		return orderSysID;
	}

	public void setOrderSysID(String orderSysID) {
		this.orderSysID = orderSysID;
	}

	public String getParticipantID() {
		return participantID;
	}

	public void setParticipantID(String participantID) {
		this.participantID = participantID;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public char getTradingRole() {
		return tradingRole;
	}

	public void setTradingRole(char tradingRole) {
		this.tradingRole = tradingRole;
	}

	public String getExchangeInstID() {
		return exchangeInstID;
	}

	public void setExchangeInstID(String exchangeInstID) {
		this.exchangeInstID = exchangeInstID;
	}

	public char getOffsetFlag() {
		return offsetFlag;
	}

	public void setOffsetFlag(char offsetFlag) {
		this.offsetFlag = offsetFlag;
	}

	public char getHedgeFlag() {
		return hedgeFlag;
	}

	public void setHedgeFlag(char hedgeFlag) {
		this.hedgeFlag = hedgeFlag;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(String tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeType() {
		return tradeType;
	}

	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}

	public char getPriceSource() {
		return priceSource;
	}

	public void setPriceSource(char priceSource) {
		this.priceSource = priceSource;
	}

	public String getTraderID() {
		return traderID;
	}

	public void setTraderID(String traderID) {
		this.traderID = traderID;
	}

	public String getOrderLocalID() {
		return orderLocalID;
	}

	public void setOrderLocalID(String orderLocalID) {
		this.orderLocalID = orderLocalID;
	}

	public String getClearingPartID() {
		return clearingPartID;
	}

	public void setClearingPartID(String clearingPartID) {
		this.clearingPartID = clearingPartID;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public int getSequenceNo() {
		return sequenceNo;
	}

	public void setSequenceNo(int sequenceNo) {
		this.sequenceNo = sequenceNo;
	}

	public String getTradingDay() {
		return tradingDay;
	}

	public void setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
	}

	public int getSettlementID() {
		return settlementID;
	}

	public void setSettlementID(int settlementID) {
		this.settlementID = settlementID;
	}

	public int getBrokerOrderSeq() {
		return brokerOrderSeq;
	}

	public void setBrokerOrderSeq(int brokerOrderSeq) {
		this.brokerOrderSeq = brokerOrderSeq;
	}

	public char getTradeSource() {
		return tradeSource;
	}

	public void setTradeSource(char tradeSource) {
		this.tradeSource = tradeSource;
	}

	public long getTradeDateTime() {
		return tradeDateTime;
	}

	public void setTradeDateTime(long tradeDateTime) {
		this.tradeDateTime = tradeDateTime;
	}

}
