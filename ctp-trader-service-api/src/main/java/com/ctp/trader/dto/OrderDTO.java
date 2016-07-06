package com.ctp.trader.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1438139740398567424L;

	// /经纪公司代码
	private String brokerID;
	// /投资者代码
	private String investorID;
	// /合约代码
	private String instrumentID;

	private String exchangeID;

	// /报单引用
	private String orderRef;
	// /用户代码
	private String userID;
	// /报单价格条件
	private char orderPriceType;
	/**
	 * 买卖方向 买 #define THOST_FTDC_D_Buy '0' 卖 #define THOST_FTDC_D_Sell '1'
	 */
	private char direction;
	// /组合开平标志
	private String combOffsetFlag;
	// /组合投机套保标志
	private String combHedgeFlag;
	// /价格
	private double limitPrice;
	// /数量
	private int volumeTotalOriginal;
	// /有效期类型
	private char timeCondition;
	/**
	 * 成交量类型 
	 * 任何数量 
	 * #define THOST_FTDC_VC_AV '1' 
	 * 最小数量
	 *  #define THOST_FTDC_VC_MV '2' 
	 *  全部数量 #define THOST_FTDC_VC_CV '3'
	 */
	private char volumeCondition;
	// /最小成交量
	private int minVolume;
	// /触发条件
	private char contingentCondition;

	// /强平原因
	private char forceCloseReason;
	// /自动挂起标志
	private int isAutoSuspend;
	// /用户强评标志
	private int userForceClose;
	// /止损价
	private double stopPrice;

	// /请求编号
	private int requestID;

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

	public char getVolumeCondition() {
		return volumeCondition;
	}

	public void setVolumeCondition(char volumeCondition) {
		this.volumeCondition = volumeCondition;
	}

	public char getForceCloseReason() {
		return forceCloseReason;
	}

	public void setForceCloseReason(char forceCloseReason) {
		this.forceCloseReason = forceCloseReason;
	}

	public int getIsAutoSuspend() {
		return isAutoSuspend;
	}

	public void setIsAutoSuspend(int isAutoSuspend) {
		this.isAutoSuspend = isAutoSuspend;
	}

	public int getUserForceClose() {
		return userForceClose;
	}

	public void setUserForceClose(int userForceClose) {
		this.userForceClose = userForceClose;
	}

	public char getDirection() {
		return direction;
	}

	public void setOrderPriceType(char orderPriceType) {
		this.orderPriceType = orderPriceType;
	}

	public char getContingentCondition() {
		return contingentCondition;
	}

	public void setContingentCondition(char contingentCondition) {
		this.contingentCondition = contingentCondition;
	}

	public int getRequestID() {
		return requestID;
	}

	public int getMinVolume() {
		return minVolume;
	}

	public void setMinVolume(int minVolume) {
		this.minVolume = minVolume;
	}

	public char getOrderPriceType() {
		return orderPriceType;
	}

	public void setDirection(char direction) {
		this.direction = direction;
	}

	public char getTimeCondition() {
		return timeCondition;
	}

	public void setTimeCondition(char timeCondition) {
		this.timeCondition = timeCondition;
	}

	public double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}

	public double getStopPrice() {
		return stopPrice;
	}

	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}

	public String getCombOffsetFlag() {
		return combOffsetFlag;
	}

	public void setCombOffsetFlag(String combOffsetFlag) {
		this.combOffsetFlag = combOffsetFlag;
	}

	public String getCombHedgeFlag() {
		return combHedgeFlag;
	}

	public void setCombHedgeFlag(String combHedgeFlag) {
		this.combHedgeFlag = combHedgeFlag;
	}

	public int getVolumeTotalOriginal() {
		return volumeTotalOriginal;
	}

	public void setVolumeTotalOriginal(int volumeTotalOriginal) {
		this.volumeTotalOriginal = volumeTotalOriginal;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}

	public String getExchangeID() {
		return exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}
}
