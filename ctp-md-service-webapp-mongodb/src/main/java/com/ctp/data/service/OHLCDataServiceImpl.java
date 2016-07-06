package com.ctp.data.service;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ctp.dao.MarketDataDao;
import com.ctp.dao.OHLCDataDao;
import com.ctp.data.entity.MarketData;
import com.ctp.data.entity.OHLCData10Minute;
import com.ctp.data.entity.OHLCData15Minute;
import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCData1Hour;
import com.ctp.data.entity.OHLCData1Minute;
import com.ctp.data.entity.OHLCData30Minute;
import com.ctp.data.entity.OHLCData5Minute;
import com.ctp.data.entity.OHLCDataItem;
import com.ctp.util.TimeDateUtils;
import com.tictactec.ta.lib.Core;
import com.tictactec.ta.lib.MInteger;
import com.tictactec.ta.lib.RetCode;

public class OHLCDataServiceImpl implements OHLCDataService{

	private OHLCDataDao oHLCDataDao;
	private MarketDataDao marketDataDao;
	private Core core = new Core();
	
	@Override
	public void addOHLCData(MarketData data) {
		OHLCData1Minute ohlcData = (OHLCData1Minute) this.getLastOHLCData(data.getInstrumentID(), data.getId(), 60000);
		if(ohlcData!=null){
			this.oHLCDataDao.save(ohlcData);
		}
	}
	public void addAllOHLCData(MarketData md){
		//判断时间是否有效
		long id = md.getId();
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date(id));
		c1.set(Calendar.HOUR, 9);
		c1.set(Calendar.MINUTE, 0);
		c1.set(Calendar.SECOND, 0);
		c1.set(Calendar.MILLISECOND, 0);
		Calendar c2 = Calendar.getInstance();
		c2.set(Calendar.HOUR, 11);
		c2.set(Calendar.MINUTE, 30);
		c2.set(Calendar.SECOND, 0);
		c2.set(Calendar.MILLISECOND, 0);
		
		Calendar c3 = Calendar.getInstance();
		c3.set(Calendar.HOUR, 21);
		c3.set(Calendar.MINUTE, 0);
		c3.set(Calendar.SECOND, 0);
		c3.set(Calendar.MILLISECOND, 0);
		Calendar c4 = Calendar.getInstance();
		c4.add(Calendar.DAY_OF_MONTH, 1);
		c4.set(Calendar.HOUR, 2);
		c4.set(Calendar.MINUTE, 30);
		c4.set(Calendar.SECOND, 0);
		c4.set(Calendar.MILLISECOND, 0);
		if((id>=c1.getTimeInMillis() && id<c2.getTimeInMillis()) || (id>c2.getTimeInMillis() && id<c4.getTimeInMillis())){
			md.setDateTimeStr(md.getTradingDay()+" "+md.getUpdateTime()+":"+md.getUpdateMillisec());
			this.addOHLCData(md);
			this.marketDataDao.save(md);
	        this.addOHLCData(md);
	        this.add(OHLCData5Minute.class, md.getInstrumentID(), md.getId());
	        this.add(OHLCData10Minute.class, md.getInstrumentID(), md.getId());
	        this.add(OHLCData15Minute.class, md.getInstrumentID(), md.getId());
	        this.add(OHLCData30Minute.class, md.getInstrumentID(), md.getId());
	        this.add(OHLCData1Hour.class, md.getInstrumentID(), md.getId());
//		        this.oHLCDataService.add(OHLCData2Hour.class, md.getInstrumentID(), md.getId());
	        this.add(OHLCData1Day.class, md.getInstrumentID(), md.getId());
		}
		
		
	}
	@Override
	public OHLCDataItem getLastOHLCData(String instrumentId,long now,int timePeriod) {
		long[] tp = TimeDateUtils.timePeriod(now, timePeriod);
		List<MarketData> ls = this.marketDataDao.getList(instrumentId, tp[0], tp[1]);
		if(ls!=null && ls.size()>0){
			OHLCData1Minute item = new OHLCData1Minute();
			item.setInstrumentId(instrumentId);
			item.setDateTimeStr(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(new Date(tp[1])));
			int len = ls.size();
			if(len==1){
				MarketData md = ls.get(0);
				if(md!=null){
					item.setId(tp[1]);
					item.setOpenPrice(md.getLastPrice());
					item.setHighPrice(md.getLastPrice());
					item.setLowPrice(md.getLastPrice());
					item.setVolume(0d);
					item.setClosePrice(md.getLastPrice());
					item.setOpenInterest(md.getOpenInterest());
					return item;
				}
				return null;
			}
			double [] prices = new double[len];
			MInteger outBegIdx = new MInteger();
			MInteger outNBElement = new MInteger();
			MInteger outBegIdx2 = new MInteger();
			MInteger outNBElement2 = new MInteger();
			for(int i=0;i<len;i++){
				prices[i]=ls.get(i).getLastPrice();
			}
			//最高价
			double[] highestPriceOutReal = new double[1];
			
			//最低价
			double[] lowestPriceOutReal = new double[1];
			item.setId(tp[1]);
			item.setOpenPrice(prices[0]);
			item.setClosePrice(prices[prices.length-1]);
			item.setVolume(Double.valueOf(ls.get(len-1).getVolume()-ls.get(0).getVolume()));
			//最高价
			RetCode rc= core.max(0, len-1, prices, len, outBegIdx, outNBElement, highestPriceOutReal);
			if(RetCode.Success==rc){
				item.setHighPrice(highestPriceOutReal[0]);
			}else{
				System.out.println(rc);
				return null;
			}
			//最低价
			RetCode lowestRc= core.min(0, len-1, prices, len, outBegIdx2, outNBElement2, lowestPriceOutReal);
			if(RetCode.Success == lowestRc){
				item.setLowPrice(lowestPriceOutReal[0]);
			}else{
				System.out.println(lowestRc);
				return null;
			}
			return item;
		}else{
			System.out.println("no data");
		}
		return null;
	}
	@Override
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz, String instrumentId, int count) {
		return this.oHLCDataDao.getList(clazz, instrumentId, count);
	}
	public <T extends OHLCDataItem>T getLastOHCLData(Class<T> clazz,String instrumentId,long now) {
		T item = null;
		try {
			item = clazz.newInstance();
			item.setInstrumentId(instrumentId);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		long[] tp = item.timePeriod(now);
		item.setDateTimeStr(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(new Date(tp[1])));
		List<? extends OHLCDataItem> ls = this.oHLCDataDao.getList(item.getSubClass(), instrumentId, tp[0], tp[1]);
		if(ls!=null && ls.size()>0){
			int len = ls.size();
			if(len==1){
				try {
					BeanUtils.copyProperties(item, ls.get(0));
					return item;
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			double [] prices = new double[len];
			MInteger outBegIdx = new MInteger();
			MInteger outNBElement = new MInteger();
			double[] volume =new double[len];
			double[] totalVolume =new double[1];
			for(int i=0;i<len;i++){
				prices[i]=ls.get(i).getClosePrice();
				volume[i]=ls.get(i).getVolume();
			}
			//最高价
			double[] highestPriceOutReal = new double[1];
			
			//最低价
			double[] lowestPriceOutReal = new double[1];
			
			item.setId(tp[1]);
			item.setOpenPrice(prices[0]);
			item.setClosePrice(prices[prices.length-1]);
			//最高价
			RetCode rc= core.max(0, len-1, prices, len, outBegIdx, outNBElement, highestPriceOutReal);
			if(RetCode.Success==rc){
				item.setHighPrice(highestPriceOutReal[0]);
			}else{
				System.out.println(rc);
				return null;
			}
			//最低价
			RetCode lowestRc= core.min(0, len-1, prices, len, outBegIdx, outNBElement, lowestPriceOutReal);
			if(RetCode.Success == lowestRc){
				item.setLowPrice(lowestPriceOutReal[0]);
			}else{
				System.out.println(lowestRc);
				return null;
			}
			RetCode vrc= core.sum(0, len-1, volume, len, outBegIdx, outNBElement, totalVolume);
			if(RetCode.Success==vrc){
				item.setVolume(totalVolume[0]);
			}else{
				System.out.println(vrc);
				return null;
			}
			item.setOpenInterest(ls.get(len-1).getOpenInterest());
			return item;
		}
		System.out.println("no data");
		return null;
	}
	
	@Override
	public <T extends OHLCDataItem> void  add(Class<T> clazz,String instrumentId,long now) {
		OHLCDataItem item= this.getLastOHCLData(clazz,instrumentId,now);
		if(item!=null){
			this.oHLCDataDao.save(item);
		}
	}

	public void setoHLCDataDao(OHLCDataDao oHLCDataDao) {
		this.oHLCDataDao = oHLCDataDao;
	}

	public void setMarketDataDao(MarketDataDao marketDataDao) {
		this.marketDataDao = marketDataDao;
	}
	
	public static void main(String[] args) {
		Core c = new Core();
		double[] prices = new double[2];
		prices[0]=2090.0;
		prices[1]=2091.0;
		MInteger outBegIdx = new MInteger();
		MInteger outNBElement = new MInteger();
		double[] highestPriceOutReal = new double[1];
		RetCode rc = c.max(0, prices.length-1, prices, prices.length, outBegIdx, outNBElement, highestPriceOutReal);
		if(RetCode.Success==rc){
			System.out.println(highestPriceOutReal[0]);
		}else{
			System.out.println(rc);
		}
		
	}

	@Override
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz, String instrumentId, long start, long end) {
		return this.oHLCDataDao.getList(clazz, instrumentId, start, end);
	}

	@Override
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz, String instrumentId, long start, long end, int count) {
		return this.oHLCDataDao.getList(clazz, instrumentId, start, end,count);
	}

	@Override
	public void save(OHLCDataItem data) {
		this.oHLCDataDao.save(data);
	}
	@Override
	public OHLCDataItem getYdOHLCData(String instrumentId) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(new Date());
		cd.add(Calendar.DAY_OF_MONTH, -1);
		cd.set(Calendar.HOUR_OF_DAY, 0);
		cd.set(Calendar.MINUTE, 0);
		cd.set(Calendar.SECOND, 0);
		cd.set(Calendar.MILLISECOND, 0);
		OHLCData1Day day = this.oHLCDataDao.findOne(OHLCData1Day.class, instrumentId, cd.getTimeInMillis());
		return day;
	}
	
	
	@Override
	public <T extends OHLCDataItem> int   getKLine(Class<T> clazz, String instrumentId,long time) {
		List<T> ls =  this.oHLCDataDao.getAfterList(clazz,instrumentId,time);
		if(ls!=null){
			return ls.size();
		}
		return 0;
	}
	
	
	@Override
	public OHLCData1Day getById(String instrumentId, long id) {
		return this.oHLCDataDao.getById(instrumentId, id);
	}
	@Override
	public OHLCData1Day getYdData(String instrumentId, long id) {
		return this.oHLCDataDao.getYdData(instrumentId, id);
	}

}
