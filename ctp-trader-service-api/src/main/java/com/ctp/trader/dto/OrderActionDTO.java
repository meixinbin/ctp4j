package com.ctp.trader.dto;

import java.io.Serializable;

public class OrderActionDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9112805285066899048L;

	private String brokerID;
	
	private String investorID;
	
	private String instrumentID;
	
	private String userID;
	
	private int orderActionRef;
	
	private String orderRef;
	
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

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getOrderActionRef() {
		return orderActionRef;
	}

	public void setOrderActionRef(int orderActionRef) {
		this.orderActionRef = orderActionRef;
	}

	public String getOrderRef() {
		return orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public int getRequestID() {
		return requestID;
	}

	public void setRequestID(int requestID) {
		this.requestID = requestID;
	}
	
	
}
