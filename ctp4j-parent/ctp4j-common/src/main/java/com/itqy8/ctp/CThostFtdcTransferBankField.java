/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.10
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.itqy8.ctp;

public class CThostFtdcTransferBankField {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected CThostFtdcTransferBankField(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(CThostFtdcTransferBankField obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        ctpJNI.delete_CThostFtdcTransferBankField(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setBankID(String value) {
    ctpJNI.CThostFtdcTransferBankField_BankID_set(swigCPtr, this, value);
  }

  public String getBankID() {
    return ctpJNI.CThostFtdcTransferBankField_BankID_get(swigCPtr, this);
  }

  public void setBankBrchID(String value) {
    ctpJNI.CThostFtdcTransferBankField_BankBrchID_set(swigCPtr, this, value);
  }

  public String getBankBrchID() {
    return ctpJNI.CThostFtdcTransferBankField_BankBrchID_get(swigCPtr, this);
  }

  public void setBankName(String value) {
    ctpJNI.CThostFtdcTransferBankField_BankName_set(swigCPtr, this, value);
  }

  public String getBankName() {
    return ctpJNI.CThostFtdcTransferBankField_BankName_get(swigCPtr, this);
  }

  public void setIsActive(int value) {
    ctpJNI.CThostFtdcTransferBankField_IsActive_set(swigCPtr, this, value);
  }

  public int getIsActive() {
    return ctpJNI.CThostFtdcTransferBankField_IsActive_get(swigCPtr, this);
  }

  public CThostFtdcTransferBankField() {
    this(ctpJNI.new_CThostFtdcTransferBankField(), true);
  }

}
