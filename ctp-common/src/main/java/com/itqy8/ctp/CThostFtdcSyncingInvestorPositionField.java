/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.itqy8.ctp;

public class CThostFtdcSyncingInvestorPositionField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcSyncingInvestorPositionField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcSyncingInvestorPositionField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ctpJNI.delete_CThostFtdcSyncingInvestorPositionField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInstrumentID(String value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_InstrumentID_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_InvestorID_get(swigCPtr, this);
  }

  public void setPosiDirection(char value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_PosiDirection_set(swigCPtr, this, value);
  }

  public char getPosiDirection() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_PosiDirection_get(swigCPtr, this);
  }

  public void setHedgeFlag(char value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_HedgeFlag_set(swigCPtr, this, value);
  }

  public char getHedgeFlag() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_HedgeFlag_get(swigCPtr, this);
  }

  public void setPositionDate(char value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_PositionDate_set(swigCPtr, this, value);
  }

  public char getPositionDate() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_PositionDate_get(swigCPtr, this);
  }

  public void setYdPosition(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_YdPosition_set(swigCPtr, this, value);
  }

  public int getYdPosition() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_YdPosition_get(swigCPtr, this);
  }

  public void setPosition(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_Position_set(swigCPtr, this, value);
  }

  public int getPosition() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_Position_get(swigCPtr, this);
  }

  public void setLongFrozen(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_LongFrozen_set(swigCPtr, this, value);
  }

  public int getLongFrozen() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_LongFrozen_get(swigCPtr, this);
  }

  public void setShortFrozen(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_ShortFrozen_set(swigCPtr, this, value);
  }

  public int getShortFrozen() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_ShortFrozen_get(swigCPtr, this);
  }

  public void setLongFrozenAmount(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_LongFrozenAmount_set(swigCPtr, this, value);
  }

  public double getLongFrozenAmount() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_LongFrozenAmount_get(swigCPtr, this);
  }

  public void setShortFrozenAmount(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_ShortFrozenAmount_set(swigCPtr, this, value);
  }

  public double getShortFrozenAmount() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_ShortFrozenAmount_get(swigCPtr, this);
  }

  public void setOpenVolume(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_OpenVolume_set(swigCPtr, this, value);
  }

  public int getOpenVolume() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_OpenVolume_get(swigCPtr, this);
  }

  public void setCloseVolume(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseVolume_set(swigCPtr, this, value);
  }

  public int getCloseVolume() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseVolume_get(swigCPtr, this);
  }

  public void setOpenAmount(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_OpenAmount_set(swigCPtr, this, value);
  }

  public double getOpenAmount() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_OpenAmount_get(swigCPtr, this);
  }

  public void setCloseAmount(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseAmount_set(swigCPtr, this, value);
  }

  public double getCloseAmount() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseAmount_get(swigCPtr, this);
  }

  public void setPositionCost(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_PositionCost_set(swigCPtr, this, value);
  }

  public double getPositionCost() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_PositionCost_get(swigCPtr, this);
  }

  public void setPreMargin(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_PreMargin_set(swigCPtr, this, value);
  }

  public double getPreMargin() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_PreMargin_get(swigCPtr, this);
  }

  public void setUseMargin(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_UseMargin_set(swigCPtr, this, value);
  }

  public double getUseMargin() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_UseMargin_get(swigCPtr, this);
  }

  public void setFrozenMargin(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_FrozenMargin_set(swigCPtr, this, value);
  }

  public double getFrozenMargin() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_FrozenMargin_get(swigCPtr, this);
  }

  public void setFrozenCash(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_FrozenCash_set(swigCPtr, this, value);
  }

  public double getFrozenCash() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_FrozenCash_get(swigCPtr, this);
  }

  public void setFrozenCommission(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_FrozenCommission_set(swigCPtr, this, value);
  }

  public double getFrozenCommission() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_FrozenCommission_get(swigCPtr, this);
  }

  public void setCashIn(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CashIn_set(swigCPtr, this, value);
  }

  public double getCashIn() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CashIn_get(swigCPtr, this);
  }

  public void setCommission(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_Commission_set(swigCPtr, this, value);
  }

  public double getCommission() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_Commission_get(swigCPtr, this);
  }

  public void setCloseProfit(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseProfit_set(swigCPtr, this, value);
  }

  public double getCloseProfit() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseProfit_get(swigCPtr, this);
  }

  public void setPositionProfit(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_PositionProfit_set(swigCPtr, this, value);
  }

  public double getPositionProfit() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_PositionProfit_get(swigCPtr, this);
  }

  public void setPreSettlementPrice(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_PreSettlementPrice_set(swigCPtr, this, value);
  }

  public double getPreSettlementPrice() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_PreSettlementPrice_get(swigCPtr, this);
  }

  public void setSettlementPrice(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_SettlementPrice_set(swigCPtr, this, value);
  }

  public double getSettlementPrice() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_SettlementPrice_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_SettlementID_get(swigCPtr, this);
  }

  public void setOpenCost(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_OpenCost_set(swigCPtr, this, value);
  }

  public double getOpenCost() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_OpenCost_get(swigCPtr, this);
  }

  public void setExchangeMargin(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_ExchangeMargin_set(swigCPtr, this, value);
  }

  public double getExchangeMargin() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_ExchangeMargin_get(swigCPtr, this);
  }

  public void setCombPosition(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CombPosition_set(swigCPtr, this, value);
  }

  public int getCombPosition() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CombPosition_get(swigCPtr, this);
  }

  public void setCombLongFrozen(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CombLongFrozen_set(swigCPtr, this, value);
  }

  public int getCombLongFrozen() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CombLongFrozen_get(swigCPtr, this);
  }

  public void setCombShortFrozen(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CombShortFrozen_set(swigCPtr, this, value);
  }

  public int getCombShortFrozen() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CombShortFrozen_get(swigCPtr, this);
  }

  public void setCloseProfitByDate(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseProfitByDate_set(swigCPtr, this, value);
  }

  public double getCloseProfitByDate() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseProfitByDate_get(swigCPtr, this);
  }

  public void setCloseProfitByTrade(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseProfitByTrade_set(swigCPtr, this, value);
  }

  public double getCloseProfitByTrade() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_CloseProfitByTrade_get(swigCPtr, this);
  }

  public void setTodayPosition(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_TodayPosition_set(swigCPtr, this, value);
  }

  public int getTodayPosition() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_TodayPosition_get(swigCPtr, this);
  }

  public void setMarginRateByMoney(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_MarginRateByMoney_set(swigCPtr, this, value);
  }

  public double getMarginRateByMoney() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_MarginRateByMoney_get(swigCPtr, this);
  }

  public void setMarginRateByVolume(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_MarginRateByVolume_set(swigCPtr, this, value);
  }

  public double getMarginRateByVolume() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_MarginRateByVolume_get(swigCPtr, this);
  }

  public void setStrikeFrozen(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_StrikeFrozen_set(swigCPtr, this, value);
  }

  public int getStrikeFrozen() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_StrikeFrozen_get(swigCPtr, this);
  }

  public void setStrikeFrozenAmount(double value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_StrikeFrozenAmount_set(swigCPtr, this, value);
  }

  public double getStrikeFrozenAmount() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_StrikeFrozenAmount_get(swigCPtr, this);
  }

  public void setAbandonFrozen(int value) {
    ctpJNI.CThostFtdcSyncingInvestorPositionField_AbandonFrozen_set(swigCPtr, this, value);
  }

  public int getAbandonFrozen() {
    return ctpJNI.CThostFtdcSyncingInvestorPositionField_AbandonFrozen_get(swigCPtr, this);
  }

  public CThostFtdcSyncingInvestorPositionField() {
    this(ctpJNI.new_CThostFtdcSyncingInvestorPositionField(), true);
  }

}
