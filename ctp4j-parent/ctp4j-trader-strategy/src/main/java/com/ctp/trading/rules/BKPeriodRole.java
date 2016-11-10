package com.ctp.trading.rules;

import eu.verdelhan.ta4j.TradingRecord;
import eu.verdelhan.ta4j.trading.rules.AbstractRule;

public class BKPeriodRole  extends AbstractRule{

	private int kline;
	
	public BKPeriodRole(int kline){
		this.kline = kline;
	}
	@Override
	public boolean isSatisfied(int index, TradingRecord tradingRecord) {
		int  i = tradingRecord.getLastEntry().getIndex();
		if(index-i>kline){
			return true;
		}
		return false;
	}

}
