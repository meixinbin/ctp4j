package com.ctp.data.entity;

/**
 * 交易信号记录
 * @author meixinbin
 * @2016-8-16
 */
public class TradeSignalRecord extends AbstractDocument{

	/**
	 * 
	 */
	private static final long serialVersionUID = 868160538474908768L;

	/**合约代码*/
	private String instrumentID;
	
	/**
	 * 交易策略代码
	 */
	private String strategyCode;
	
	/**
	 * K线时间
	 */
	private long ohlcdTime;
	

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public long getOhlcdTime() {
		return ohlcdTime;
	}

	public void setOhlcdTime(long ohlcdTime) {
		this.ohlcdTime = ohlcdTime;
	}

	public String getStrategyCode() {
		return strategyCode;
	}

	public void setStrategyCode(String strategyCode) {
		this.strategyCode = strategyCode;
	}

	
}
