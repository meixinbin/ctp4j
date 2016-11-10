package com.ctp.trading.rules;

import eu.verdelhan.ta4j.TradingRecord;
import eu.verdelhan.ta4j.trading.rules.AbstractRule;

public class SKPeriodRole  extends AbstractRule{

	private int kline;
	
	public SKPeriodRole(int kline){
		this.kline = kline;
	}
	@Override
	public boolean isSatisfied(int index, TradingRecord tradingRecord) {
		int  i = tradingRecord.getLastExit().getIndex();
		if(index-i>kline){
			return true;
		}
		return false;
	}

}
