package com.ctp.service;

import com.ctp.strategy.MarketTradeTrategy;
import com.itqy8.ctp.CThostFtdcDepthMarketDataField;
import com.itqy8.ctp.CThostFtdcForQuoteRspField;
import com.itqy8.ctp.CThostFtdcMdApi;
import com.itqy8.ctp.CThostFtdcMdSpi;
import com.itqy8.ctp.CThostFtdcReqUserLoginField;
import com.itqy8.ctp.CThostFtdcRspInfoField;
import com.itqy8.ctp.CThostFtdcRspUserLoginField;
import com.itqy8.ctp.CThostFtdcSpecificInstrumentField;
import com.itqy8.ctp.CThostFtdcUserLogoutField;
import com.itqy8.framework.util.SpringPropertyResourceReader;
import com.itqy8.framework.util.SpringUtil;

public class MyMdSpi extends CThostFtdcMdSpi{

	private CThostFtdcMdApi mdApi;
	private MarketTradeTrategy marketTradeTrategy;
	
	public MyMdSpi(CThostFtdcMdApi mdApi){
		this.mdApi = mdApi;
		this.marketTradeTrategy = (MarketTradeTrategy) SpringUtil.getBean("marketTradeTrategy");
	}
	
	@Override
	public synchronized void delete() {
	}

	@Override
	public void OnFrontConnected() {
		System.out.println("行情前置连接成功");
		System.out.println("用户登录中...");
		String brokerid = SpringPropertyResourceReader.getProperty("ctp.brokerId");
		String password = SpringPropertyResourceReader.getProperty("ctp.password");
		String userid = SpringPropertyResourceReader.getProperty("ctp.userid");
		CThostFtdcReqUserLoginField userLoginField = new CThostFtdcReqUserLoginField ();
		userLoginField.setBrokerID(brokerid);
		userLoginField.setUserID(userid);
		userLoginField.setPassword(password);
		mdApi.ReqUserLogin(userLoginField, 1);
	}

	@Override
	public void OnFrontDisconnected(int nReason) {
		System.out.println("行情前置连接断开");
	}

	@Override
	public void OnHeartBeatWarning(int nTimeLapse) {
	}

	@Override
	public void OnRspUserLogin(CThostFtdcRspUserLoginField pRspUserLogin, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		if(pRspInfo.getErrorID()==0){
			System.out.println("用户登录成功");
		}
//		List<String> insls = instrumentService.getInstrumentIds().getResult();
		String[] str = {"rb1610"};
//		str = insls.toArray(str);
		this.mdApi.SubscribeMarketData(str, str.length);
	}

	@Override
	public void OnRspUserLogout(CThostFtdcUserLogoutField pUserLogout, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
	}

	@Override
	public void OnRspError(CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("===========OnRspError========");
	}

	@Override
	public void OnRspSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("===========OnRspSubMarketData========");
	}

	@Override
	public void OnRspUnSubMarketData(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("===========OnRspUnSubMarketData========");
	}

	@Override
	public void OnRspSubForQuoteRsp(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("===========OnRspSubForQuoteRsp========");
	}

	@Override
	public void OnRspUnSubForQuoteRsp(CThostFtdcSpecificInstrumentField pSpecificInstrument, CThostFtdcRspInfoField pRspInfo, int nRequestID, boolean bIsLast) {
		System.out.println("===========OnRspUnSubForQuoteRsp========");
	}

	@Override
	public void OnRtnDepthMarketData(CThostFtdcDepthMarketDataField pDepthMarketData) {
		this.marketTradeTrategy.trade(pDepthMarketData);
	}

	@Override
	public void OnRtnForQuoteRsp(CThostFtdcForQuoteRspField pForQuoteRsp) {
		System.out.println("===========call back========");
	}

}
