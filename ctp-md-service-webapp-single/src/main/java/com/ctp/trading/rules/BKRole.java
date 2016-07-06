package com.ctp.trading.rules;

import eu.verdelhan.ta4j.TradingRecord;
import eu.verdelhan.ta4j.trading.rules.AbstractRule;

/**
 * 上一个K线是否出现买入信号
 * @author meixinbin
 * @2016-6-8
 */
public class BKRole extends AbstractRule{

	@Override
	public boolean isSatisfied(int index, TradingRecord tradingRecord) {
		int i = tradingRecord.getLastEntry().getIndex();
		if(index-i==1){
			return true;
		}
		return false;
	}

	
}
