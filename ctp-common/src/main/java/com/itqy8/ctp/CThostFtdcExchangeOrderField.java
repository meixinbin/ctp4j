/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.itqy8.ctp;

public class CThostFtdcExchangeOrderField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcExchangeOrderField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcExchangeOrderField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ctpJNI.delete_CThostFtdcExchangeOrderField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setOrderPriceType(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_OrderPriceType_set(swigCPtr, this, value);
  }

  public char getOrderPriceType() {
    return ctpJNI.CThostFtdcExchangeOrderField_OrderPriceType_get(swigCPtr, this);
  }

  public void setDirection(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_Direction_set(swigCPtr, this, value);
  }

  public char getDirection() {
    return ctpJNI.CThostFtdcExchangeOrderField_Direction_get(swigCPtr, this);
  }

  public void setCombOffsetFlag(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_CombOffsetFlag_set(swigCPtr, this, value);
  }

  public String getCombOffsetFlag() {
    return ctpJNI.CThostFtdcExchangeOrderField_CombOffsetFlag_get(swigCPtr, this);
  }

  public void setCombHedgeFlag(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_CombHedgeFlag_set(swigCPtr, this, value);
  }

  public String getCombHedgeFlag() {
    return ctpJNI.CThostFtdcExchangeOrderField_CombHedgeFlag_get(swigCPtr, this);
  }

  public void setLimitPrice(double value) {
    ctpJNI.CThostFtdcExchangeOrderField_LimitPrice_set(swigCPtr, this, value);
  }

  public double getLimitPrice() {
    return ctpJNI.CThostFtdcExchangeOrderField_LimitPrice_get(swigCPtr, this);
  }

  public void setVolumeTotalOriginal(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_VolumeTotalOriginal_set(swigCPtr, this, value);
  }

  public int getVolumeTotalOriginal() {
    return ctpJNI.CThostFtdcExchangeOrderField_VolumeTotalOriginal_get(swigCPtr, this);
  }

  public void setTimeCondition(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_TimeCondition_set(swigCPtr, this, value);
  }

  public char getTimeCondition() {
    return ctpJNI.CThostFtdcExchangeOrderField_TimeCondition_get(swigCPtr, this);
  }

  public void setGTDDate(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_GTDDate_set(swigCPtr, this, value);
  }

  public String getGTDDate() {
    return ctpJNI.CThostFtdcExchangeOrderField_GTDDate_get(swigCPtr, this);
  }

  public void setVolumeCondition(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_VolumeCondition_set(swigCPtr, this, value);
  }

  public char getVolumeCondition() {
    return ctpJNI.CThostFtdcExchangeOrderField_VolumeCondition_get(swigCPtr, this);
  }

  public void setMinVolume(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_MinVolume_set(swigCPtr, this, value);
  }

  public int getMinVolume() {
    return ctpJNI.CThostFtdcExchangeOrderField_MinVolume_get(swigCPtr, this);
  }

  public void setContingentCondition(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_ContingentCondition_set(swigCPtr, this, value);
  }

  public char getContingentCondition() {
    return ctpJNI.CThostFtdcExchangeOrderField_ContingentCondition_get(swigCPtr, this);
  }

  public void setStopPrice(double value) {
    ctpJNI.CThostFtdcExchangeOrderField_StopPrice_set(swigCPtr, this, value);
  }

  public double getStopPrice() {
    return ctpJNI.CThostFtdcExchangeOrderField_StopPrice_get(swigCPtr, this);
  }

  public void setForceCloseReason(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_ForceCloseReason_set(swigCPtr, this, value);
  }

  public char getForceCloseReason() {
    return ctpJNI.CThostFtdcExchangeOrderField_ForceCloseReason_get(swigCPtr, this);
  }

  public void setIsAutoSuspend(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_IsAutoSuspend_set(swigCPtr, this, value);
  }

  public int getIsAutoSuspend() {
    return ctpJNI.CThostFtdcExchangeOrderField_IsAutoSuspend_get(swigCPtr, this);
  }

  public void setBusinessUnit(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_BusinessUnit_set(swigCPtr, this, value);
  }

  public String getBusinessUnit() {
    return ctpJNI.CThostFtdcExchangeOrderField_BusinessUnit_get(swigCPtr, this);
  }

  public void setRequestID(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_RequestID_set(swigCPtr, this, value);
  }

  public int getRequestID() {
    return ctpJNI.CThostFtdcExchangeOrderField_RequestID_get(swigCPtr, this);
  }

  public void setOrderLocalID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_OrderLocalID_set(swigCPtr, this, value);
  }

  public String getOrderLocalID() {
    return ctpJNI.CThostFtdcExchangeOrderField_OrderLocalID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return ctpJNI.CThostFtdcExchangeOrderField_ExchangeID_get(swigCPtr, this);
  }

  public void setParticipantID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_ParticipantID_set(swigCPtr, this, value);
  }

  public String getParticipantID() {
    return ctpJNI.CThostFtdcExchangeOrderField_ParticipantID_get(swigCPtr, this);
  }

  public void setClientID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_ClientID_set(swigCPtr, this, value);
  }

  public String getClientID() {
    return ctpJNI.CThostFtdcExchangeOrderField_ClientID_get(swigCPtr, this);
  }

  public void setExchangeInstID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_ExchangeInstID_set(swigCPtr, this, value);
  }

  public String getExchangeInstID() {
    return ctpJNI.CThostFtdcExchangeOrderField_ExchangeInstID_get(swigCPtr, this);
  }

  public void setTraderID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_TraderID_set(swigCPtr, this, value);
  }

  public String getTraderID() {
    return ctpJNI.CThostFtdcExchangeOrderField_TraderID_get(swigCPtr, this);
  }

  public void setInstallID(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_InstallID_set(swigCPtr, this, value);
  }

  public int getInstallID() {
    return ctpJNI.CThostFtdcExchangeOrderField_InstallID_get(swigCPtr, this);
  }

  public void setOrderSubmitStatus(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_OrderSubmitStatus_set(swigCPtr, this, value);
  }

  public char getOrderSubmitStatus() {
    return ctpJNI.CThostFtdcExchangeOrderField_OrderSubmitStatus_get(swigCPtr, this);
  }

  public void setNotifySequence(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_NotifySequence_set(swigCPtr, this, value);
  }

  public int getNotifySequence() {
    return ctpJNI.CThostFtdcExchangeOrderField_NotifySequence_get(swigCPtr, this);
  }

  public void setTradingDay(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_TradingDay_set(swigCPtr, this, value);
  }

  public String getTradingDay() {
    return ctpJNI.CThostFtdcExchangeOrderField_TradingDay_get(swigCPtr, this);
  }

  public void setSettlementID(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_SettlementID_set(swigCPtr, this, value);
  }

  public int getSettlementID() {
    return ctpJNI.CThostFtdcExchangeOrderField_SettlementID_get(swigCPtr, this);
  }

  public void setOrderSysID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_OrderSysID_set(swigCPtr, this, value);
  }

  public String getOrderSysID() {
    return ctpJNI.CThostFtdcExchangeOrderField_OrderSysID_get(swigCPtr, this);
  }

  public void setOrderSource(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_OrderSource_set(swigCPtr, this, value);
  }

  public char getOrderSource() {
    return ctpJNI.CThostFtdcExchangeOrderField_OrderSource_get(swigCPtr, this);
  }

  public void setOrderStatus(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_OrderStatus_set(swigCPtr, this, value);
  }

  public char getOrderStatus() {
    return ctpJNI.CThostFtdcExchangeOrderField_OrderStatus_get(swigCPtr, this);
  }

  public void setOrderType(char value) {
    ctpJNI.CThostFtdcExchangeOrderField_OrderType_set(swigCPtr, this, value);
  }

  public char getOrderType() {
    return ctpJNI.CThostFtdcExchangeOrderField_OrderType_get(swigCPtr, this);
  }

  public void setVolumeTraded(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_VolumeTraded_set(swigCPtr, this, value);
  }

  public int getVolumeTraded() {
    return ctpJNI.CThostFtdcExchangeOrderField_VolumeTraded_get(swigCPtr, this);
  }

  public void setVolumeTotal(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_VolumeTotal_set(swigCPtr, this, value);
  }

  public int getVolumeTotal() {
    return ctpJNI.CThostFtdcExchangeOrderField_VolumeTotal_get(swigCPtr, this);
  }

  public void setInsertDate(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_InsertDate_set(swigCPtr, this, value);
  }

  public String getInsertDate() {
    return ctpJNI.CThostFtdcExchangeOrderField_InsertDate_get(swigCPtr, this);
  }

  public void setInsertTime(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_InsertTime_set(swigCPtr, this, value);
  }

  public String getInsertTime() {
    return ctpJNI.CThostFtdcExchangeOrderField_InsertTime_get(swigCPtr, this);
  }

  public void setActiveTime(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_ActiveTime_set(swigCPtr, this, value);
  }

  public String getActiveTime() {
    return ctpJNI.CThostFtdcExchangeOrderField_ActiveTime_get(swigCPtr, this);
  }

  public void setSuspendTime(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_SuspendTime_set(swigCPtr, this, value);
  }

  public String getSuspendTime() {
    return ctpJNI.CThostFtdcExchangeOrderField_SuspendTime_get(swigCPtr, this);
  }

  public void setUpdateTime(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_UpdateTime_set(swigCPtr, this, value);
  }

  public String getUpdateTime() {
    return ctpJNI.CThostFtdcExchangeOrderField_UpdateTime_get(swigCPtr, this);
  }

  public void setCancelTime(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_CancelTime_set(swigCPtr, this, value);
  }

  public String getCancelTime() {
    return ctpJNI.CThostFtdcExchangeOrderField_CancelTime_get(swigCPtr, this);
  }

  public void setActiveTraderID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_ActiveTraderID_set(swigCPtr, this, value);
  }

  public String getActiveTraderID() {
    return ctpJNI.CThostFtdcExchangeOrderField_ActiveTraderID_get(swigCPtr, this);
  }

  public void setClearingPartID(String value) {
    ctpJNI.CThostFtdcExchangeOrderField_ClearingPartID_set(swigCPtr, this, value);
  }

  public String getClearingPartID() {
    return ctpJNI.CThostFtdcExchangeOrderField_ClearingPartID_get(swigCPtr, this);
  }

  public void setSequenceNo(int value) {
    ctpJNI.CThostFtdcExchangeOrderField_SequenceNo_set(swigCPtr, this, value);
  }

  public int getSequenceNo() {
    return ctpJNI.CThostFtdcExchangeOrderField_SequenceNo_get(swigCPtr, this);
  }

  public CThostFtdcExchangeOrderField() {
    this(ctpJNI.new_CThostFtdcExchangeOrderField(), true);
  }

}
