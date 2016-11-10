package com.ctp.ta4j.strategy.extra.indicators.candles;

import java.util.List;

import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCDataItem;
import com.ctp.data.service.OHLCDataService;

import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.Tick;
import eu.verdelhan.ta4j.TimeSeries;
import eu.verdelhan.ta4j.indicators.CachedIndicator;

public class My018SelIndicator<T extends OHLCDataItem> extends CachedIndicator<Boolean> {

	private int nn;//查询当日的K线个数;
	private double hh;// 昨日最高价
	private double ll;// 昨日最低价
	private double cc;// 昨天的收盘价
	private double oo;//今天开盘价

	private String instrumentId;
    private OHLCDataService oHLCDataService;
    private Class<T > clazz;
	public My018SelIndicator(TimeSeries series,String instrumentId,Class<T> clazz,OHLCDataService oHLCDataService){
		super(series);
		this.clazz = clazz;
		this.instrumentId = instrumentId;
		this.oHLCDataService = oHLCDataService;
	}

	@Override
	protected Boolean calculate(int index) {
		if(index==0){
			return false;
		}
		Tick tk = this.getTimeSeries().getTick(index);
        List<OHLCData1Day> ls = this.oHLCDataService.getBeforeData(OHLCData1Day.class, instrumentId, tk.getEndTime().getMillis(), 2);
        if(ls!=null && ls.size()>1){
        	OHLCData1Day yd = ls.get(0);
    		OHLCData1Day today = ls.get(0);
    		this.nn = this.oHLCDataService.getKLineOfDay(clazz, instrumentId, tk.getEndTime().getMillis());
            if(yd!=null && today!=null){
            	this.hh = yd.getHighPrice();
            	this.ll = yd.getLowPrice();
            	this.cc = yd.getClosePrice();
            	this.oo = today.getOpenPrice();
            	/*if(tk.getMaxPrice().isGreaterThan(tk0.getMaxPrice())){
    				this.oo = 0;
    			}else{
    				this.oo = today.getOpenPrice();
    			}*/
            	this.oo = today.getOpenPrice();
            	double cfj = Math.max(hh - cc, cc - ll) * 0.5;
            	/*if(tk.getMaxPrice().isGreaterThan(tk0.getMaxPrice())){
            		cfj = 0;
    			}*/
            	double bb = oo - cfj;
            	if (tk.getMinPrice().isLessThan(Decimal.valueOf(bb)) && nn > 0) {
        			return true;
        		}
            }
        }
		
		return false;
	}

}
