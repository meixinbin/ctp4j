package com.ctp.trader.dto;

import java.io.Serializable;

public class InstrumentDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4585791127274661112L;

	
	/**主键*/
	private Long id;
		
	//~~ properties fields 
		
	/**合约代码*/
	private String instrumentID;
		
	/**交易所代码*/
	private String exchangeID;
		
	/**合约在交易所的代码*/
	private String exchangeInstID;
		
	/**合约名称*/
	private String instrumentName;
		
	/**产品代码*/
	private String productID;
		
	/**产品类型*/
	private Character productClass;
		
	/**交割年份*/
	private Integer deliveryYear;
		
	/**交割月*/
	private Integer deliveryMonth;
		
	/**市价单最大下单量*/
	private Integer maxMarketOrderVolume;
		
	/**市价单最小下单量*/
	private Integer minMarketOrderVolume;
		
	/**限价单最大下单量*/
	private Integer maxLimitOrderVolume;
		
	/**限价单最小下单量*/
	private Integer minLimitOrderVolume;
		
	/**合约数量乘数*/
	private Integer volumeMultiple;
		
	/**最小变动价位*/
	private Double priceTick;
		
	/**创建日*/
	private String createDate;
		
	/**上市日*/
	private String openDate;
		
	/**到期日*/
	private String expireDate;
		
	/**开始交割日*/
	private String startDelivDate;
		
	/**结束交割日*/
	private String endDelivDate;
		
	/**合约生命周期状态*/
	private Character instLifePhase;
		
	/**当前是否交易*/
	private Integer isTrading;
		
	/**持仓类型*/
	private Character positionType;
		
	/**持仓日期类型*/
	private Character positionDateType;
		
	/**多头保证金率*/
	private Double longMarginRatio;
		
	/**空头保证金率*/
	private Double shortMarginRatio;
		
	/**是否使用大额单边保证金算法*/
	private Character maxMarginSideAlgorithm;
		
	/**基础商品代码*/
	private String underlyingInstrID;
		
	/**执行价*/
	private Double strikePrice;
		
	/**期权类型*/
	private Character optionsType;
		
	/**合约基础商品乘数*/
	private Double underlyingMultiple;
		
	/**组合类型*/
	private Character combinationType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
	}

	public String getExchangeID() {
		return exchangeID;
	}

	public void setExchangeID(String exchangeID) {
		this.exchangeID = exchangeID;
	}

	public String getExchangeInstID() {
		return exchangeInstID;
	}

	public void setExchangeInstID(String exchangeInstID) {
		this.exchangeInstID = exchangeInstID;
	}

	public String getInstrumentName() {
		return instrumentName;
	}

	public void setInstrumentName(String instrumentName) {
		this.instrumentName = instrumentName;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public Character getProductClass() {
		return productClass;
	}

	public void setProductClass(Character productClass) {
		this.productClass = productClass;
	}

	public Integer getDeliveryYear() {
		return deliveryYear;
	}

	public void setDeliveryYear(Integer deliveryYear) {
		this.deliveryYear = deliveryYear;
	}

	public Integer getDeliveryMonth() {
		return deliveryMonth;
	}

	public void setDeliveryMonth(Integer deliveryMonth) {
		this.deliveryMonth = deliveryMonth;
	}

	public Integer getMaxMarketOrderVolume() {
		return maxMarketOrderVolume;
	}

	public void setMaxMarketOrderVolume(Integer maxMarketOrderVolume) {
		this.maxMarketOrderVolume = maxMarketOrderVolume;
	}

	public Integer getMinMarketOrderVolume() {
		return minMarketOrderVolume;
	}

	public void setMinMarketOrderVolume(Integer minMarketOrderVolume) {
		this.minMarketOrderVolume = minMarketOrderVolume;
	}

	public Integer getMaxLimitOrderVolume() {
		return maxLimitOrderVolume;
	}

	public void setMaxLimitOrderVolume(Integer maxLimitOrderVolume) {
		this.maxLimitOrderVolume = maxLimitOrderVolume;
	}

	public Integer getMinLimitOrderVolume() {
		return minLimitOrderVolume;
	}

	public void setMinLimitOrderVolume(Integer minLimitOrderVolume) {
		this.minLimitOrderVolume = minLimitOrderVolume;
	}

	public Integer getVolumeMultiple() {
		return volumeMultiple;
	}

	public void setVolumeMultiple(Integer volumeMultiple) {
		this.volumeMultiple = volumeMultiple;
	}

	public Double getPriceTick() {
		return priceTick;
	}

	public void setPriceTick(Double priceTick) {
		this.priceTick = priceTick;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getStartDelivDate() {
		return startDelivDate;
	}

	public void setStartDelivDate(String startDelivDate) {
		this.startDelivDate = startDelivDate;
	}

	public String getEndDelivDate() {
		return endDelivDate;
	}

	public void setEndDelivDate(String endDelivDate) {
		this.endDelivDate = endDelivDate;
	}

	public Character getInstLifePhase() {
		return instLifePhase;
	}

	public void setInstLifePhase(Character instLifePhase) {
		this.instLifePhase = instLifePhase;
	}

	public Integer getIsTrading() {
		return isTrading;
	}

	public void setIsTrading(Integer isTrading) {
		this.isTrading = isTrading;
	}

	public Character getPositionType() {
		return positionType;
	}

	public void setPositionType(Character positionType) {
		this.positionType = positionType;
	}

	public Character getPositionDateType() {
		return positionDateType;
	}

	public void setPositionDateType(Character positionDateType) {
		this.positionDateType = positionDateType;
	}

	public Double getLongMarginRatio() {
		return longMarginRatio;
	}

	public void setLongMarginRatio(Double longMarginRatio) {
		this.longMarginRatio = longMarginRatio;
	}

	public Double getShortMarginRatio() {
		return shortMarginRatio;
	}

	public void setShortMarginRatio(Double shortMarginRatio) {
		this.shortMarginRatio = shortMarginRatio;
	}

	public Character getMaxMarginSideAlgorithm() {
		return maxMarginSideAlgorithm;
	}

	public void setMaxMarginSideAlgorithm(Character maxMarginSideAlgorithm) {
		this.maxMarginSideAlgorithm = maxMarginSideAlgorithm;
	}

	public String getUnderlyingInstrID() {
		return underlyingInstrID;
	}

	public void setUnderlyingInstrID(String underlyingInstrID) {
		this.underlyingInstrID = underlyingInstrID;
	}

	public Double getStrikePrice() {
		return strikePrice;
	}

	public void setStrikePrice(Double strikePrice) {
		this.strikePrice = strikePrice;
	}

	public Character getOptionsType() {
		return optionsType;
	}

	public void setOptionsType(Character optionsType) {
		this.optionsType = optionsType;
	}

	public Double getUnderlyingMultiple() {
		return underlyingMultiple;
	}

	public void setUnderlyingMultiple(Double underlyingMultiple) {
		this.underlyingMultiple = underlyingMultiple;
	}

	public Character getCombinationType() {
		return combinationType;
	}

	public void setCombinationType(Character combinationType) {
		this.combinationType = combinationType;
	}
}
