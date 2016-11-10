package com.ctp.trading.rules;

import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.Indicator;
import eu.verdelhan.ta4j.TradingRecord;
import eu.verdelhan.ta4j.trading.rules.AbstractRule;

/**
 * MA值大于关盘价
 * @author meixinbin
 * @2016-6-8
 */
public class MAGrantThanClosePriceRole extends AbstractRule{

	private Indicator<Decimal> indicator;
	
	public MAGrantThanClosePriceRole(Indicator<Decimal> indicator){
		this.indicator = indicator;
	}
	@Override
	public boolean isSatisfied(int index, TradingRecord tradingRecord) {
		boolean satisfied = indicator.getValue(index).isGreaterThan(indicator.getTimeSeries().getTick(index).getClosePrice());
		int i = tradingRecord.getLastEntry().getIndex();
		if(satisfied && index-i==1){
			return true;
		}
		return false;
	}

	
}
