package com.ctp.trader.entity;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 投资者持仓
 * 
 * @author meixinbin
 * @2016-6-12
 */
@Document
public class InvestorPosition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1288111289005636828L;
	@Id
	private Long id;
	// /合约代码
	private String instrumentID;
	// /经纪公司代码
	private String brokerID;
	// /投资者代码
	private String investorID;
	// /持仓多空方向
	private char posiDirection;
	// /投机套保标志
	private char hedgeFlag;
	// /持仓日期
	private char positionDate;
	// /上日持仓
	private int ydPosition;
	// /今日持仓
	private int position;
	// /多头冻结
	private int longFrozen;
	// /空头冻结
	private int shortFrozen;
	// /开仓冻结金额
	private double longFrozenAmount;
	// /开仓冻结金额
	private double shortFrozenAmount;
	// /开仓量
	private int openVolume;
	// /平仓量
	private int closeVolume;
	// /开仓金额
	private double openAmount;
	// /平仓金额
	private double closeAmount;
	// /持仓成本
	private double positionCost;
	// /上次占用的保证金
	private double preMargin;
	// /占用的保证金
	private double useMargin;
	// /冻结的保证金
	private double frozenMargin;
	// /冻结的资金
	private double frozenCash;
	// /冻结的手续费
	private double frozenCommission;
	// /资金差额
	private double cashIn;
	// /手续费
	private double commission;
	// /平仓盈亏
	private double closeProfit;
	// /持仓盈亏
	private double positionProfit;
	// /上次结算价
	private double preSettlementPrice;
	// /本次结算价
	private double settlementPrice;
	// /交易日
	private String tradingDay;
	// /结算编号
	private String settlementID;
	// /开仓成本
	private double openCost;
	// /交易所保证金
	private double exchangeMargin;
	// /组合成交形成的持仓
	private int combPosition;
	// /组合多头冻结
	private double combLongFrozen;
	// /组合空头冻结
	private double combShortFrozen;
	// /逐日盯市平仓盈亏
	private double closeProfitByDate;
	// /逐笔对冲平仓盈亏
	private double closeProfitByTrade;
	// /今日持仓
	private double todayPosition;
	// /保证金率
	private double marginRateByMoney;
	// /保证金率(按手数)
	private double marginRateByVolume;
	// /执行冻结
	private double strikeFrozen;
	// /执行冻结金额
	private double strikeFrozenAmount;
	// /放弃执行冻结
	private double abandonFrozen;

	public String getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(String instrumentID) {
		this.instrumentID = instrumentID;
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

	public char getPosiDirection() {
		return posiDirection;
	}

	public void setPosiDirection(char posiDirection) {
		this.posiDirection = posiDirection;
	}

	public char getHedgeFlag() {
		return hedgeFlag;
	}

	public void setHedgeFlag(char hedgeFlag) {
		this.hedgeFlag = hedgeFlag;
	}

	public char getPositionDate() {
		return positionDate;
	}

	public void setPositionDate(char positionDate) {
		this.positionDate = positionDate;
	}

	public int getYdPosition() {
		return ydPosition;
	}

	public void setYdPosition(int ydPosition) {
		this.ydPosition = ydPosition;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getLongFrozen() {
		return longFrozen;
	}

	public void setLongFrozen(int longFrozen) {
		this.longFrozen = longFrozen;
	}

	public int getShortFrozen() {
		return shortFrozen;
	}

	public void setShortFrozen(int shortFrozen) {
		this.shortFrozen = shortFrozen;
	}

	public double getLongFrozenAmount() {
		return longFrozenAmount;
	}

	public void setLongFrozenAmount(double longFrozenAmount) {
		this.longFrozenAmount = longFrozenAmount;
	}

	public double getShortFrozenAmount() {
		return shortFrozenAmount;
	}

	public void setShortFrozenAmount(double shortFrozenAmount) {
		this.shortFrozenAmount = shortFrozenAmount;
	}

	public int getOpenVolume() {
		return openVolume;
	}

	public void setOpenVolume(int openVolume) {
		this.openVolume = openVolume;
	}

	public int getCloseVolume() {
		return closeVolume;
	}

	public void setCloseVolume(int closeVolume) {
		this.closeVolume = closeVolume;
	}

	public double getOpenAmount() {
		return openAmount;
	}

	public void setOpenAmount(double openAmount) {
		this.openAmount = openAmount;
	}

	public double getCloseAmount() {
		return closeAmount;
	}

	public void setCloseAmount(double closeAmount) {
		this.closeAmount = closeAmount;
	}

	public double getPositionCost() {
		return positionCost;
	}

	public void setPositionCost(double positionCost) {
		this.positionCost = positionCost;
	}

	public double getPreMargin() {
		return preMargin;
	}

	public void setPreMargin(double preMargin) {
		this.preMargin = preMargin;
	}

	public double getUseMargin() {
		return useMargin;
	}

	public void setUseMargin(double useMargin) {
		this.useMargin = useMargin;
	}

	public double getFrozenMargin() {
		return frozenMargin;
	}

	public void setFrozenMargin(double frozenMargin) {
		this.frozenMargin = frozenMargin;
	}

	public double getFrozenCash() {
		return frozenCash;
	}

	public void setFrozenCash(double frozenCash) {
		this.frozenCash = frozenCash;
	}

	public double getFrozenCommission() {
		return frozenCommission;
	}

	public void setFrozenCommission(double frozenCommission) {
		this.frozenCommission = frozenCommission;
	}

	public double getCashIn() {
		return cashIn;
	}

	public void setCashIn(double cashIn) {
		this.cashIn = cashIn;
	}

	public double getCommission() {
		return commission;
	}

	public void setCommission(double commission) {
		this.commission = commission;
	}

	public double getCloseProfit() {
		return closeProfit;
	}

	public void setCloseProfit(double closeProfit) {
		this.closeProfit = closeProfit;
	}

	public double getPositionProfit() {
		return positionProfit;
	}

	public void setPositionProfit(double positionProfit) {
		this.positionProfit = positionProfit;
	}

	public double getPreSettlementPrice() {
		return preSettlementPrice;
	}

	public void setPreSettlementPrice(double preSettlementPrice) {
		this.preSettlementPrice = preSettlementPrice;
	}

	public double getSettlementPrice() {
		return settlementPrice;
	}

	public void setSettlementPrice(double settlementPrice) {
		this.settlementPrice = settlementPrice;
	}

	public String getTradingDay() {
		return tradingDay;
	}

	public void setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
	}

	public String getSettlementID() {
		return settlementID;
	}

	public void setSettlementID(String settlementID) {
		this.settlementID = settlementID;
	}

	public double getOpenCost() {
		return openCost;
	}

	public void setOpenCost(double openCost) {
		this.openCost = openCost;
	}

	public double getExchangeMargin() {
		return exchangeMargin;
	}

	public void setExchangeMargin(double exchangeMargin) {
		this.exchangeMargin = exchangeMargin;
	}

	public int getCombPosition() {
		return combPosition;
	}

	public void setCombPosition(int combPosition) {
		this.combPosition = combPosition;
	}

	public double getCombLongFrozen() {
		return combLongFrozen;
	}

	public void setCombLongFrozen(double combLongFrozen) {
		this.combLongFrozen = combLongFrozen;
	}

	public double getCombShortFrozen() {
		return combShortFrozen;
	}

	public void setCombShortFrozen(double combShortFrozen) {
		this.combShortFrozen = combShortFrozen;
	}

	public double getCloseProfitByDate() {
		return closeProfitByDate;
	}

	public void setCloseProfitByDate(double closeProfitByDate) {
		this.closeProfitByDate = closeProfitByDate;
	}

	public double getCloseProfitByTrade() {
		return closeProfitByTrade;
	}

	public void setCloseProfitByTrade(double closeProfitByTrade) {
		this.closeProfitByTrade = closeProfitByTrade;
	}

	public double getTodayPosition() {
		return todayPosition;
	}

	public void setTodayPosition(double todayPosition) {
		this.todayPosition = todayPosition;
	}

	public double getMarginRateByMoney() {
		return marginRateByMoney;
	}

	public void setMarginRateByMoney(double marginRateByMoney) {
		this.marginRateByMoney = marginRateByMoney;
	}

	public double getMarginRateByVolume() {
		return marginRateByVolume;
	}

	public void setMarginRateByVolume(double marginRateByVolume) {
		this.marginRateByVolume = marginRateByVolume;
	}

	public double getStrikeFrozen() {
		return strikeFrozen;
	}

	public void setStrikeFrozen(double strikeFrozen) {
		this.strikeFrozen = strikeFrozen;
	}

	public double getStrikeFrozenAmount() {
		return strikeFrozenAmount;
	}

	public void setStrikeFrozenAmount(double strikeFrozenAmount) {
		this.strikeFrozenAmount = strikeFrozenAmount;
	}

	public double getAbandonFrozen() {
		return abandonFrozen;
	}

	public void setAbandonFrozen(double abandonFrozen) {
		this.abandonFrozen = abandonFrozen;
	}

	@Override
	public String toString() {
		return "InvestorPositionDTO [instrumentID=" + instrumentID + ", brokerID=" + brokerID + ", investorID=" + investorID + ", posiDirection=" + posiDirection + ", hedgeFlag=" + hedgeFlag + ", positionDate=" + positionDate + ", ydPosition=" + ydPosition + ", position=" + position + ", longFrozen=" + longFrozen + ", shortFrozen=" + shortFrozen + ", longFrozenAmount=" + longFrozenAmount + ", shortFrozenAmount=" + shortFrozenAmount + ", openVolume=" + openVolume + ", closeVolume=" + closeVolume + ", openAmount=" + openAmount + ", closeAmount=" + closeAmount + ", positionCost=" + positionCost + ", preMargin=" + preMargin + ", useMargin=" + useMargin + ", frozenMargin=" + frozenMargin + ", frozenCash=" + frozenCash + ", frozenCommission=" + frozenCommission + ", cashIn=" + cashIn + ", commission=" + commission + ", closeProfit=" + closeProfit + ", positionProfit=" + positionProfit + ", preSettlementPrice=" + preSettlementPrice + ", settlementPrice=" + settlementPrice + ", tradingDay="
				+ tradingDay + ", settlementID=" + settlementID + ", openCost=" + openCost + ", exchangeMargin=" + exchangeMargin + ", combPosition=" + combPosition + ", combLongFrozen=" + combLongFrozen + ", combShortFrozen=" + combShortFrozen + ", closeProfitByDate=" + closeProfitByDate + ", closeProfitByTrade=" + closeProfitByTrade + ", todayPosition=" + todayPosition + ", marginRateByMoney=" + marginRateByMoney + ", marginRateByVolume=" + marginRateByVolume + ", strikeFrozen=" + strikeFrozen + ", strikeFrozenAmount=" + strikeFrozenAmount + ", abandonFrozen=" + abandonFrozen + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
