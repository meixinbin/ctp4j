package com.ctp.service;

import com.itqy8.ctp.CThostFtdcTraderApi;

public class TraderApiWrap {

	private static CThostFtdcTraderApi traderApi;

	private static int maxOrderRef=0;
	
	public static CThostFtdcTraderApi getTraderApi() {
		return traderApi;
	}

	public static void setTraderApi(CThostFtdcTraderApi traderApi) {
		TraderApiWrap.traderApi = traderApi;
	}

	public static int getMaxOrderRef() {
		return maxOrderRef;
	}

	public static void setMaxOrderRef(int maxOrderRef) {
		TraderApiWrap.maxOrderRef = maxOrderRef;
	}
}
