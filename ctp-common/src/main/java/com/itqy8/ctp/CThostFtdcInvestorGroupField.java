/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.itqy8.ctp;

public class CThostFtdcInvestorGroupField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcInvestorGroupField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcInvestorGroupField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ctpJNI.delete_CThostFtdcInvestorGroupField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBrokerID(String value) {
    ctpJNI.CThostFtdcInvestorGroupField_BrokerID_set(swigCPtr, this, value);
  }

  public String getBrokerID() {
    return ctpJNI.CThostFtdcInvestorGroupField_BrokerID_get(swigCPtr, this);
  }

  public void setInvestorGroupID(String value) {
    ctpJNI.CThostFtdcInvestorGroupField_InvestorGroupID_set(swigCPtr, this, value);
  }

  public String getInvestorGroupID() {
    return ctpJNI.CThostFtdcInvestorGroupField_InvestorGroupID_get(swigCPtr, this);
  }

  public void setInvestorGroupName(String value) {
    ctpJNI.CThostFtdcInvestorGroupField_InvestorGroupName_set(swigCPtr, this, value);
  }

  public String getInvestorGroupName() {
    return ctpJNI.CThostFtdcInvestorGroupField_InvestorGroupName_get(swigCPtr, this);
  }

  public CThostFtdcInvestorGroupField() {
    this(ctpJNI.new_CThostFtdcInvestorGroupField(), true);
  }

}
