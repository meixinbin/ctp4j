package com.ctp.ta4j.strategy.extra;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ctp.data.entity.OHLCDataItem;
import com.ctp.data.service.OHLCDataService;
import com.ctp.ta4j.strategy.extra.indicators.candles.My018BuyIndicator;
import com.ctp.ta4j.strategy.extra.indicators.candles.My018SelIndicator;
import com.itqy8.framework.util.SpringUtil;

import eu.verdelhan.ta4j.Rule;
import eu.verdelhan.ta4j.Strategy;
import eu.verdelhan.ta4j.TimeSeries;
import eu.verdelhan.ta4j.trading.rules.BooleanIndicatorRule;

public class My018Strategy<T extends OHLCDataItem> {
	
	
	public Strategy buildStrategy(TimeSeries series,String instrumentId,Class<T> clazz) {
		OHLCDataService oHLCDataService = (OHLCDataService) SpringUtil.getBean("oHLCDataService");
		if (series == null) {
			throw new IllegalArgumentException("Series cannot be null");
		}
		My018BuyIndicator<T> bi = new My018BuyIndicator<T>(series,instrumentId,clazz,oHLCDataService);
		
		My018SelIndicator<T> ti = new My018SelIndicator<T>(series,instrumentId,clazz,oHLCDataService);
		//底部形态已经形成，买进
		Rule entryRule = new BooleanIndicatorRule(bi);
		Rule exitRule = new BooleanIndicatorRule(ti);
		return new Strategy(entryRule, exitRule);
	}
	
	public static void main(String[] args) {
		Calendar cal2 = Calendar.getInstance();
        cal2.setTimeInMillis(System.currentTimeMillis());
        cal2.set(Calendar.HOUR_OF_DAY, 0);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        cal2.set(Calendar.MILLISECOND, 0);
		System.out.println(new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS").format(new Date(1466341200000L)));
	}
}
