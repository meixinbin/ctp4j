package com.ctp.ta4j.strategy.extra.indicators.candles;

import java.util.Calendar;

import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCDataItem;
import com.ctp.data.service.OHLCDataService;
import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.Tick;
import eu.verdelhan.ta4j.TimeSeries;
import eu.verdelhan.ta4j.indicators.CachedIndicator;

public class My018BuyIndicator<T extends OHLCDataItem> extends CachedIndicator<Boolean> {

	private int nn;// 查询当日的K线个数;
	private double hh;// 昨日最高价
	private double ll;// 昨日最低价
	private double cc;// 昨天的收盘价
	private double oo;// 今天开盘价
	private String instrumentId;
	private OHLCDataService oHLCDataService;
	private Class<T> clazz;

	public My018BuyIndicator(TimeSeries series, String instrumentId, Class<T> clazz, OHLCDataService oHLCDataService) {
		super(series);
		this.clazz = clazz;
		this.instrumentId = instrumentId;
		this.oHLCDataService = oHLCDataService;
	}

	@Override
	protected Boolean calculate(int index) {
		Tick tk = this.getTimeSeries().getTick(index);
		long begin = tk.getBeginTime().getMillis();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(begin);
		cal.add(Calendar.DATE, -1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTimeInMillis(begin);
		cal2.set(Calendar.HOUR_OF_DAY, 0);
		cal2.set(Calendar.MINUTE, 0);
		cal2.set(Calendar.SECOND, 0);
		cal2.set(Calendar.MILLISECOND, 0);
		OHLCData1Day yd = this.oHLCDataService.getYdData(instrumentId, cal.getTimeInMillis());
		OHLCData1Day today = this.oHLCDataService.getById(instrumentId, cal2.getTimeInMillis());
		this.nn = this.oHLCDataService.getKLine(clazz, instrumentId, cal2.getTimeInMillis());
		if (yd != null && today != null) {
			this.hh = yd.getHighPrice();
			this.ll = yd.getLowPrice();
			this.cc = yd.getClosePrice();
			this.oo = today.getOpenPrice();
			double cfj = Math.max(hh - cc, cc -       ll) * 0.5;
			double aa = oo + cfj;
			if (tk.getMaxPrice().isGreaterThan(Decimal.valueOf(aa)) && nn > 1) {
				return true;
			}
		}
		return false;
	}

}
