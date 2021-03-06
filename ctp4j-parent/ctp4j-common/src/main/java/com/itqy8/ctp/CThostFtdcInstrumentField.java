/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.itqy8.ctp;

public class CThostFtdcInstrumentField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcInstrumentField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcInstrumentField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ctpJNI.delete_CThostFtdcInstrumentField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInstrumentID(String value) {
    ctpJNI.CThostFtdcInstrumentField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return ctpJNI.CThostFtdcInstrumentField_InstrumentID_get(swigCPtr, this);
  }

  public void setExchangeID(String value) {
    ctpJNI.CThostFtdcInstrumentField_ExchangeID_set(swigCPtr, this, value);
  }

  public String getExchangeID() {
    return ctpJNI.CThostFtdcInstrumentField_ExchangeID_get(swigCPtr, this);
  }

  public void setInstrumentName(String value) {
    ctpJNI.CThostFtdcInstrumentField_InstrumentName_set(swigCPtr, this, value);
  }

  public String getInstrumentName() {
    return ctpJNI.CThostFtdcInstrumentField_InstrumentName_get(swigCPtr, this);
  }

  public void setExchangeInstID(String value) {
    ctpJNI.CThostFtdcInstrumentField_ExchangeInstID_set(swigCPtr, this, value);
  }

  public String getExchangeInstID() {
    return ctpJNI.CThostFtdcInstrumentField_ExchangeInstID_get(swigCPtr, this);
  }

  public void setProductID(String value) {
    ctpJNI.CThostFtdcInstrumentField_ProductID_set(swigCPtr, this, value);
  }

  public String getProductID() {
    return ctpJNI.CThostFtdcInstrumentField_ProductID_get(swigCPtr, this);
  }

  public void setProductClass(char value) {
    ctpJNI.CThostFtdcInstrumentField_ProductClass_set(swigCPtr, this, value);
  }

  public char getProductClass() {
    return ctpJNI.CThostFtdcInstrumentField_ProductClass_get(swigCPtr, this);
  }

  public void setDeliveryYear(int value) {
    ctpJNI.CThostFtdcInstrumentField_DeliveryYear_set(swigCPtr, this, value);
  }

  public int getDeliveryYear() {
    return ctpJNI.CThostFtdcInstrumentField_DeliveryYear_get(swigCPtr, this);
  }

  public void setDeliveryMonth(int value) {
    ctpJNI.CThostFtdcInstrumentField_DeliveryMonth_set(swigCPtr, this, value);
  }

  public int getDeliveryMonth() {
    return ctpJNI.CThostFtdcInstrumentField_DeliveryMonth_get(swigCPtr, this);
  }

  public void setMaxMarketOrderVolume(int value) {
    ctpJNI.CThostFtdcInstrumentField_MaxMarketOrderVolume_set(swigCPtr, this, value);
  }

  public int getMaxMarketOrderVolume() {
    return ctpJNI.CThostFtdcInstrumentField_MaxMarketOrderVolume_get(swigCPtr, this);
  }

  public void setMinMarketOrderVolume(int value) {
    ctpJNI.CThostFtdcInstrumentField_MinMarketOrderVolume_set(swigCPtr, this, value);
  }

  public int getMinMarketOrderVolume() {
    return ctpJNI.CThostFtdcInstrumentField_MinMarketOrderVolume_get(swigCPtr, this);
  }

  public void setMaxLimitOrderVolume(int value) {
    ctpJNI.CThostFtdcInstrumentField_MaxLimitOrderVolume_set(swigCPtr, this, value);
  }

  public int getMaxLimitOrderVolume() {
    return ctpJNI.CThostFtdcInstrumentField_MaxLimitOrderVolume_get(swigCPtr, this);
  }

  public void setMinLimitOrderVolume(int value) {
    ctpJNI.CThostFtdcInstrumentField_MinLimitOrderVolume_set(swigCPtr, this, value);
  }

  public int getMinLimitOrderVolume() {
    return ctpJNI.CThostFtdcInstrumentField_MinLimitOrderVolume_get(swigCPtr, this);
  }

  public void setVolumeMultiple(int value) {
    ctpJNI.CThostFtdcInstrumentField_VolumeMultiple_set(swigCPtr, this, value);
  }

  public int getVolumeMultiple() {
    return ctpJNI.CThostFtdcInstrumentField_VolumeMultiple_get(swigCPtr, this);
  }

  public void setPriceTick(double value) {
    ctpJNI.CThostFtdcInstrumentField_PriceTick_set(swigCPtr, this, value);
  }

  public double getPriceTick() {
    return ctpJNI.CThostFtdcInstrumentField_PriceTick_get(swigCPtr, this);
  }

  public void setCreateDate(String value) {
    ctpJNI.CThostFtdcInstrumentField_CreateDate_set(swigCPtr, this, value);
  }

  public String getCreateDate() {
    return ctpJNI.CThostFtdcInstrumentField_CreateDate_get(swigCPtr, this);
  }

  public void setOpenDate(String value) {
    ctpJNI.CThostFtdcInstrumentField_OpenDate_set(swigCPtr, this, value);
  }

  public String getOpenDate() {
    return ctpJNI.CThostFtdcInstrumentField_OpenDate_get(swigCPtr, this);
  }

  public void setExpireDate(String value) {
    ctpJNI.CThostFtdcInstrumentField_ExpireDate_set(swigCPtr, this, value);
  }

  public String getExpireDate() {
    return ctpJNI.CThostFtdcInstrumentField_ExpireDate_get(swigCPtr, this);
  }

  public void setStartDelivDate(String value) {
    ctpJNI.CThostFtdcInstrumentField_StartDelivDate_set(swigCPtr, this, value);
  }

  public String getStartDelivDate() {
    return ctpJNI.CThostFtdcInstrumentField_StartDelivDate_get(swigCPtr, this);
  }

  public void setEndDelivDate(String value) {
    ctpJNI.CThostFtdcInstrumentField_EndDelivDate_set(swigCPtr, this, value);
  }

  public String getEndDelivDate() {
    return ctpJNI.CThostFtdcInstrumentField_EndDelivDate_get(swigCPtr, this);
  }

  public void setInstLifePhase(char value) {
    ctpJNI.CThostFtdcInstrumentField_InstLifePhase_set(swigCPtr, this, value);
  }

  public char getInstLifePhase() {
    return ctpJNI.CThostFtdcInstrumentField_InstLifePhase_get(swigCPtr, this);
  }

  public void setIsTrading(int value) {
    ctpJNI.CThostFtdcInstrumentField_IsTrading_set(swigCPtr, this, value);
  }

  public int getIsTrading() {
    return ctpJNI.CThostFtdcInstrumentField_IsTrading_get(swigCPtr, this);
  }

  public void setPositionType(char value) {
    ctpJNI.CThostFtdcInstrumentField_PositionType_set(swigCPtr, this, value);
  }

  public char getPositionType() {
    return ctpJNI.CThostFtdcInstrumentField_PositionType_get(swigCPtr, this);
  }

  public void setPositionDateType(char value) {
    ctpJNI.CThostFtdcInstrumentField_PositionDateType_set(swigCPtr, this, value);
  }

  public char getPositionDateType() {
    return ctpJNI.CThostFtdcInstrumentField_PositionDateType_get(swigCPtr, this);
  }

  public void setLongMarginRatio(double value) {
    ctpJNI.CThostFtdcInstrumentField_LongMarginRatio_set(swigCPtr, this, value);
  }

  public double getLongMarginRatio() {
    return ctpJNI.CThostFtdcInstrumentField_LongMarginRatio_get(swigCPtr, this);
  }

  public void setShortMarginRatio(double value) {
    ctpJNI.CThostFtdcInstrumentField_ShortMarginRatio_set(swigCPtr, this, value);
  }

  public double getShortMarginRatio() {
    return ctpJNI.CThostFtdcInstrumentField_ShortMarginRatio_get(swigCPtr, this);
  }

  public void setMaxMarginSideAlgorithm(char value) {
    ctpJNI.CThostFtdcInstrumentField_MaxMarginSideAlgorithm_set(swigCPtr, this, value);
  }

  public char getMaxMarginSideAlgorithm() {
    return ctpJNI.CThostFtdcInstrumentField_MaxMarginSideAlgorithm_get(swigCPtr, this);
  }

  public void setUnderlyingInstrID(String value) {
    ctpJNI.CThostFtdcInstrumentField_UnderlyingInstrID_set(swigCPtr, this, value);
  }

  public String getUnderlyingInstrID() {
    return ctpJNI.CThostFtdcInstrumentField_UnderlyingInstrID_get(swigCPtr, this);
  }

  public void setStrikePrice(double value) {
    ctpJNI.CThostFtdcInstrumentField_StrikePrice_set(swigCPtr, this, value);
  }

  public double getStrikePrice() {
    return ctpJNI.CThostFtdcInstrumentField_StrikePrice_get(swigCPtr, this);
  }

  public void setOptionsType(char value) {
    ctpJNI.CThostFtdcInstrumentField_OptionsType_set(swigCPtr, this, value);
  }

  public char getOptionsType() {
    return ctpJNI.CThostFtdcInstrumentField_OptionsType_get(swigCPtr, this);
  }

  public void setUnderlyingMultiple(double value) {
    ctpJNI.CThostFtdcInstrumentField_UnderlyingMultiple_set(swigCPtr, this, value);
  }

  public double getUnderlyingMultiple() {
    return ctpJNI.CThostFtdcInstrumentField_UnderlyingMultiple_get(swigCPtr, this);
  }

  public void setCombinationType(char value) {
    ctpJNI.CThostFtdcInstrumentField_CombinationType_set(swigCPtr, this, value);
  }

  public char getCombinationType() {
    return ctpJNI.CThostFtdcInstrumentField_CombinationType_get(swigCPtr, this);
  }

  public CThostFtdcInstrumentField() {
    this(ctpJNI.new_CThostFtdcInstrumentField(), true);
  }

}
