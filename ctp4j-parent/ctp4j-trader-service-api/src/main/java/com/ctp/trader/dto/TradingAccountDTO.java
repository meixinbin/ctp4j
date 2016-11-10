package com.ctp.trader.dto;

import java.io.Serializable;

public class TradingAccountDTO implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 14002166219928034L;

	private Long id;
	// /经纪公司代码
	private String brokerID;
	// /投资者帐号
	private String accountID;
	// /上次质押金额
	private double preMortgage;
	// /上次信用额度
	private double preCredit;
	// /上次存款额
	private double preDeposit;
	// /上次结算准备金
	private double preBalance;
	// /上次占用的保证金
	private double preMargin;
	// /利息基数
	private double interestBase;
	// /利息收入
	private double interest;
	// /入金金额
	private double deposit;
	// /出金金额
	private double withdraw;
	// /冻结的保证金
	private double frozenMargin;
	// /冻结的资金
	private double frozenCash;
	// /冻结的手续费
	private double frozenCommission;
	// /当前保证金总额
	private double currMargin;
	// /资金差额
	private double cashIn;
	// /手续费
	private double commission;
	// /平仓盈亏
	private double closeProfit;
	// /持仓盈亏
	private double positionProfit;
	// /期货结算准备金
	private double balance;
	// /可用资金
	private double available;
	// /可取资金
	private double withdrawQuota;
	// /基本准备金
	private double reserve;
	// /交易日
	private String tradingDay;
	// /结算编号
	private int SettlementID;
	// /信用额度
	private double credit;
	// /质押金额
	private double mortgage;
	// /交易所保证金
	private double exchangeMargin;
	// /投资者交割保证金
	private double deliveryMargin;
	// /交易所交割保证金
	private double exchangeDeliveryMargin;
	// /保底期货结算准备金
	private double reserveBalance;
	// /币种代码
	private String currencyID;
	// /上次货币质入金额
	private double preFundMortgageIn;
	// /上次货币质出金额
	private double preFundMortgageOut;
	// /货币质入金额
	private double fundMortgageIn;
	// /货币质出金额
	private double fundMortgageOut;
	// /货币质押余额
	private double fundMortgageAvailable;
	// /可质押货币金额
	private double mortgageableFund;
	// /特殊产品占用保证金
	private double specProductMargin;
	// /特殊产品冻结保证金
	private double specProductFrozenMargin;
	// /特殊产品手续费
	private double specProductCommission;
	// /特殊产品冻结手续费
	private double specProductFrozenCommission;
	// /特殊产品持仓盈亏
	private double specProductPositionProfit;
	// /特殊产品平仓盈亏
	private double specProductCloseProfit;
	// /根据持仓盈亏算法计算的特殊产品持仓盈亏
	private double specProductPositionProfitByAlg;
	// /特殊产品交易所保证金
	private double specProductExchangeMargin;
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
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public double getPreMortgage() {
		return preMortgage;
	}
	public void setPreMortgage(double preMortgage) {
		this.preMortgage = preMortgage;
	}
	public double getPreCredit() {
		return this.preCredit;
	}
	public void setPreCredit(double preCredit) {
		this.preCredit = preCredit;
	}
	public double getPreDeposit() {
		return preDeposit;
	}
	public void setPreDeposit(double preDeposit) {
		this.preDeposit = preDeposit;
	}
	public double getPreBalance() {
		return preBalance;
	}
	public void setPreBalance(double preBalance) {
		this.preBalance = preBalance;
	}
	public double getPreMargin() {
		return preMargin;
	}
	public void setPreMargin(double preMargin) {
		this.preMargin = preMargin;
	}
	public double getInterestBase() {
		return interestBase;
	}
	public void setInterestBase(double interestBase) {
		this.interestBase = interestBase;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public double getDeposit() {
		return deposit;
	}
	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	public double getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
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
	public double getCurrMargin() {
		return currMargin;
	}
	public void setCurrMargin(double currMargin) {
		this.currMargin = currMargin;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAvailable() {
		return available;
	}
	public void setAvailable(double available) {
		this.available = available;
	}
	public double getWithdrawQuota() {
		return withdrawQuota;
	}
	public void setWithdrawQuota(double withdrawQuota) {
		this.withdrawQuota = withdrawQuota;
	}
	public double getReserve() {
		return reserve;
	}
	public void setReserve(double reserve) {
		this.reserve = reserve;
	}
	public String getTradingDay() {
		return tradingDay;
	}
	public void setTradingDay(String tradingDay) {
		this.tradingDay = tradingDay;
	}
	public int getSettlementID() {
		return SettlementID;
	}
	public void setSettlementID(int settlementID) {
		SettlementID = settlementID;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public double getMortgage() {
		return mortgage;
	}
	public void setMortgage(double mortgage) {
		this.mortgage = mortgage;
	}
	public double getExchangeMargin() {
		return exchangeMargin;
	}
	public void setExchangeMargin(double exchangeMargin) {
		this.exchangeMargin = exchangeMargin;
	}
	public double getDeliveryMargin() {
		return deliveryMargin;
	}
	public void setDeliveryMargin(double deliveryMargin) {
		this.deliveryMargin = deliveryMargin;
	}
	public double getExchangeDeliveryMargin() {
		return exchangeDeliveryMargin;
	}
	public void setExchangeDeliveryMargin(double exchangeDeliveryMargin) {
		this.exchangeDeliveryMargin = exchangeDeliveryMargin;
	}
	public double getReserveBalance() {
		return reserveBalance;
	}
	public void setReserveBalance(double reserveBalance) {
		this.reserveBalance = reserveBalance;
	}
	public String getCurrencyID() {
		return currencyID;
	}
	public void setCurrencyID(String currencyID) {
		this.currencyID = currencyID;
	}
	public double getPreFundMortgageIn() {
		return preFundMortgageIn;
	}
	public void setPreFundMortgageIn(double preFundMortgageIn) {
		this.preFundMortgageIn = preFundMortgageIn;
	}
	public double getPreFundMortgageOut() {
		return preFundMortgageOut;
	}
	public void setPreFundMortgageOut(double preFundMortgageOut) {
		this.preFundMortgageOut = preFundMortgageOut;
	}
	public double getFundMortgageIn() {
		return fundMortgageIn;
	}
	public void setFundMortgageIn(double fundMortgageIn) {
		this.fundMortgageIn = fundMortgageIn;
	}
	public double getFundMortgageOut() {
		return fundMortgageOut;
	}
	public void setFundMortgageOut(double fundMortgageOut) {
		this.fundMortgageOut = fundMortgageOut;
	}
	public double getFundMortgageAvailable() {
		return fundMortgageAvailable;
	}
	public void setFundMortgageAvailable(double fundMortgageAvailable) {
		this.fundMortgageAvailable = fundMortgageAvailable;
	}
	public double getMortgageableFund() {
		return mortgageableFund;
	}
	public void setMortgageableFund(double mortgageableFund) {
		this.mortgageableFund = mortgageableFund;
	}
	public double getSpecProductMargin() {
		return specProductMargin;
	}
	public void setSpecProductMargin(double specProductMargin) {
		this.specProductMargin = specProductMargin;
	}
	public double getSpecProductFrozenMargin() {
		return specProductFrozenMargin;
	}
	public void setSpecProductFrozenMargin(double specProductFrozenMargin) {
		this.specProductFrozenMargin = specProductFrozenMargin;
	}
	public double getSpecProductCommission() {
		return specProductCommission;
	}
	public void setSpecProductCommission(double specProductCommission) {
		this.specProductCommission = specProductCommission;
	}
	public double getSpecProductFrozenCommission() {
		return specProductFrozenCommission;
	}
	public void setSpecProductFrozenCommission(double specProductFrozenCommission) {
		this.specProductFrozenCommission = specProductFrozenCommission;
	}
	public double getSpecProductPositionProfit() {
		return specProductPositionProfit;
	}
	public void setSpecProductPositionProfit(double specProductPositionProfit) {
		this.specProductPositionProfit = specProductPositionProfit;
	}
	public double getSpecProductCloseProfit() {
		return specProductCloseProfit;
	}
	public void setSpecProductCloseProfit(double specProductCloseProfit) {
		this.specProductCloseProfit = specProductCloseProfit;
	}
	public double getSpecProductPositionProfitByAlg() {
		return specProductPositionProfitByAlg;
	}
	public void setSpecProductPositionProfitByAlg(double specProductPositionProfitByAlg) {
		this.specProductPositionProfitByAlg = specProductPositionProfitByAlg;
	}
	public double getSpecProductExchangeMargin() {
		return specProductExchangeMargin;
	}
	public void setSpecProductExchangeMargin(double specProductExchangeMargin) {
		this.specProductExchangeMargin = specProductExchangeMargin;
	}

}
