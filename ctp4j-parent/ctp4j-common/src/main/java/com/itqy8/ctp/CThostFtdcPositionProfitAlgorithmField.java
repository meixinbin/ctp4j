/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.itqy8.ctp;

public class CThostFtdcPositionProfitAlgorithmField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcPositionProfitAlgorithmField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcPositionProfitAlgorithmField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ctpJNI.delete_CThostFtdcPositionProfitAlgorithmField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    ctpJNI.CThostFtdcPositionProfitAlgorithmField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return ctpJNI.CThostFtdcPositionProfitAlgorithmField_BrokerID_get(swigCPtr, this);
  }

  public void setAccountID(String value) {
    ctpJNI.CThostFtdcPositionProfitAlgorithmField_AccountID_set(swigCPtr, this, value);
  }

  public String getAccountID() {
    return ctpJNI.CThostFtdcPositionProfitAlgorithmField_AccountID_get(swigCPtr, this);
  }

  public void setAlgorithm(char value) {
    ctpJNI.CThostFtdcPositionProfitAlgorithmField_Algorithm_set(swigCPtr, this, value);
  }

  public char getAlgorithm() {
    return ctpJNI.CThostFtdcPositionProfitAlgorithmField_Algorithm_get(swigCPtr, this);
  }

  public void setMemo(String value) {
    ctpJNI.CThostFtdcPositionProfitAlgorithmField_Memo_set(swigCPtr, this, value);
  }

  public String getMemo() {
    return ctpJNI.CThostFtdcPositionProfitAlgorithmField_Memo_get(swigCPtr, this);
  }

  public void setCurrencyID(String value) {
    ctpJNI.CThostFtdcPositionProfitAlgorithmField_CurrencyID_set(swigCPtr, this, value);
  }

  public String getCurrencyID() {
    return ctpJNI.CThostFtdcPositionProfitAlgorithmField_CurrencyID_get(swigCPtr, this);
  }

  public CThostFtdcPositionProfitAlgorithmField() {
    this(ctpJNI.new_CThostFtdcPositionProfitAlgorithmField(), true);
  }

}
