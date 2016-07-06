package com.ctp.data.entity;



public abstract class OHLCDataItem extends AbstractDocument{

	private static final long serialVersionUID = 1L;

	/**时间*/
	private String dateTimeStr;
	
	/**合约代码*/
	private String instrumentId;
	
	/**开盘价*/
	private Double openPrice;
		
	/**最高价*/
	private Double highPrice;
		
	/**最低价*/
	private Double lowPrice;
	
	/**收盘价*/
	private Double closePrice;
	
	/**成交量*/
	private Double volume;
	
	/**持仓量*/
	private Double openInterest;

	/*public Long getPriceTime() {
		return priceTime;
	}

	public void setPriceTime(Long priceTime) {
		this.priceTime = priceTime;
	}
*/
	public Double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(Double openPrice) {
		this.openPrice = openPrice;
	}

	public Double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(Double closePrice) {
		this.closePrice = closePrice;
	}

	public Double getVolume() {
		return volume;
	}

	public void setVolume(Double volume) {
		this.volume = volume;
	}

	public String getInstrumentId() {
		return instrumentId;
	}

	public void setInstrumentId(String instrumentId) {
		this.instrumentId = instrumentId;
	}
	
	public abstract long[] timePeriod(long now);

	public abstract <T> Class<? extends OHLCDataItem> getSubClass();

	public Double getOpenInterest() {
		return openInterest;
	}

	public void setOpenInterest(Double openInterest) {
		this.openInterest = openInterest;
	}

	public String getDateTimeStr() {
		return dateTimeStr;
	}

	public void setDateTimeStr(String dateTimeStr) {
		this.dateTimeStr = dateTimeStr;
	}
}
