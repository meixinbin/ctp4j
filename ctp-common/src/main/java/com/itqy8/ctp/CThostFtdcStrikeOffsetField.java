/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.itqy8.ctp;

public class CThostFtdcStrikeOffsetField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcStrikeOffsetField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcStrikeOffsetField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ctpJNI.delete_CThostFtdcStrikeOffsetField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setInstrumentID(String value) {
    ctpJNI.CThostFtdcStrikeOffsetField_InstrumentID_set(swigCPtr, this, value);
  }

  public String getInstrumentID() {
    return ctpJNI.CThostFtdcStrikeOffsetField_InstrumentID_get(swigCPtr, this);
  }

  public void setInvestorRange(char value) {
    ctpJNI.CThostFtdcStrikeOffsetField_InvestorRange_set(swigCPtr, this, value);
  }

  public char getInvestorRange() {
    return ctpJNI.CThostFtdcStrikeOffsetField_InvestorRange_get(swigCPtr, this);
  }

  public void setBrokerID(String value) {
    ctpJNI.CThostFtdcStrikeOffsetField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return ctpJNI.CThostFtdcStrikeOffsetField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorID(String value) {
    ctpJNI.CThostFtdcStrikeOffsetField_InvestorID_set(swigCPtr, this, value);
  }

  public String getInvestorID() {
    return ctpJNI.CThostFtdcStrikeOffsetField_InvestorID_get(swigCPtr, this);
  }

  public void setOffset(double value) {
    ctpJNI.CThostFtdcStrikeOffsetField_Offset_set(swigCPtr, this, value);
  }

  public double getOffset() {
    return ctpJNI.CThostFtdcStrikeOffsetField_Offset_get(swigCPtr, this);
  }

  public CThostFtdcStrikeOffsetField() {
    this(ctpJNI.new_CThostFtdcStrikeOffsetField(), true);
  }

}
