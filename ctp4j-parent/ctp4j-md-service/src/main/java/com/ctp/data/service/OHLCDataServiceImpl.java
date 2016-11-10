package com.ctp.data.service;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

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

/**
 * tick 数据，1分钟数据，30分钟数据为基础数据
 * @author meixinbin
 * @2016-10-17
 */
@Service("oHLCDataService")
public class OHLCDataServiceImpl implements OHLCDataService{

	@Resource(name="oHLCDataDao")
	private OHLCDataDao oHLCDataDao;
	@Resource(name="marketDataDao")
	private MarketDataDao marketDataDao;
	private Core core = new Core();
	
	@Override
	public void save(OHLCDataItem data) {
		this.oHLCDataDao.save(data);
	}

	
	/**
	 * 添加最新单位K线数据
	 * @param data
	 * @author meixinbin 2016-7-11 下午2:40:45
	 */
	@Override
	public void addOHLCData1Minute(MarketData data) {
		OHLCData1Minute ohlcData = (OHLCData1Minute) this.getOHLCData1Minute(data.getInstrumentID(), data.getId());
		if(ohlcData!=null){
			ohlcData.setTradingDay(Integer.parseInt(data.getTradingDay()));
			this.oHLCDataDao.save(ohlcData);
		}
	}
	
	private OHLCDataItem getOHLCData1Minute(String instrumentId,long now) {
		long[] tp = TimeDateUtils.timePeriod(now, 60000);
		List<MarketData> ls = this.marketDataDao.getList(instrumentId, tp[0], tp[1]);
		if(ls!=null && ls.size()>0){
			OHLCData1Minute item = new OHLCData1Minute();
			item.setId(tp[0]);
			item.setInstrumentId(instrumentId);
			item.setDateTimeStr(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(new Date(tp[0])));
			item.setEndTime(tp[1]);
			int len = ls.size();
			if(len==1){
				MarketData md = ls.get(0);
				if(md!=null){
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
			double [] lowprices = new double[len];
			MInteger outBegIdx = new MInteger();
			MInteger outNBElement = new MInteger();
			MInteger outBegIdx2 = new MInteger();
			MInteger outNBElement2 = new MInteger();
			for(int i=0;i<len;i++){
				lowprices[i]=ls.get(i).getLastPrice();
			}
			//最高价
			double[] highestPriceOutReal = new double[1];
			
			//最低价
			double[] lowestPriceOutReal = new double[1];
			item.setId(tp[0]);
			item.setOpenPrice(ls.get(0).getLastPrice());
			item.setClosePrice(ls.get(lowprices.length-1).getLastPrice());
			item.setVolume(Double.valueOf(ls.get(len-1).getVolume()-ls.get(0).getVolume()));
			//最高价
			RetCode rc= core.max(0, len-1, lowprices, len, outBegIdx, outNBElement, highestPriceOutReal);
			if(RetCode.Success==rc){
				item.setHighPrice(highestPriceOutReal[0]);
			}else{
				System.out.println(rc);
				return null;
			}
			//最低价
			RetCode lowestRc= core.min(0, len-1, lowprices, len, outBegIdx2, outNBElement2, lowestPriceOutReal);
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
	
	public void addAllOHLCData(MarketData md){
			md.setDateTimeStr(md.getTradingDay()+" "+md.getUpdateTime()+":"+md.getUpdateMillisec());
			this.marketDataDao.save(md);
	        this.addOHLCData1Minute(md);
	        this.addOHLCData(OHLCData5Minute.class, md.getInstrumentID(), md.getId());
	        this.addOHLCData(OHLCData10Minute.class, md.getInstrumentID(), md.getId());
	        this.addOHLCData(OHLCData15Minute.class, md.getInstrumentID(), md.getId());
	        this.addOHLCData(OHLCData30Minute.class, md.getInstrumentID(), md.getId());
	        this.addOHLCData(OHLCData1Hour.class, md.getInstrumentID(), md.getId());
	        this.addOHLCData(OHLCData1Day.class, md.getInstrumentID(), md.getId());
	}
	
	/**
	 * 获取最新的K线数据
	 * @param clazz
	 * @param instrumentId
	 * @param count
	 * @return
	 * @author meixinbin 2016-7-11 下午2:29:06
	 */
	@Override
	public <T extends OHLCDataItem> List<T> getLatestList(Class<T> clazz, String instrumentId, int count) {
		List<T> ls = this.oHLCDataDao.getLatestList(clazz, instrumentId, count);
		Collections.reverse(ls);
		return ls;
	}
	
	public <T extends OHLCDataItem>T getLastOHCLData(Class<T> clazz,String instrumentId,long now) {
		T item = null;
		try {
			item = clazz.newInstance();
			item.setInstrumentId(instrumentId);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		//如果是获取日K线则直接从ticket 数据中获取最新的那条记录
		if(item instanceof OHLCData1Day){
			MarketData md = this.marketDataDao.getLast(instrumentId, now);
			if(md!=null){
				try {
				item.setId(new SimpleDateFormat("yyyyMMdd").parse(md.getTradingDay()).getTime());
				item.setInstrumentId(instrumentId);
				item.setHighPrice(md.getHighestPrice());
				item.setLowPrice(md.getLowestPrice());
				item.setOpenPrice(md.getOpenPrice());
				item.setClosePrice(md.getLastPrice());
				item.setDateTimeStr(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(now));
				item.setEndTime(new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS").parse(md.getTradingDay() + " 15:00:00:0").getTime());
				item.setVolume(md.getVolume().doubleValue());
				item.setOpenInterest(md.getOpenInterest());
				item.setTradingDay(Integer.parseInt(md.getTradingDay()));
				return item;
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		long[] tp = item.timePeriod(now);
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
			item.setDateTimeStr(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS").format(new Date(tp[0])));
			double [] prices = new double[len];
			double [] lowprices = new double[len];
			MInteger outBegIdx = new MInteger();
			MInteger outNBElement = new MInteger();
			double[] volume =new double[len];
			double[] totalVolume =new double[1];
			for(int i=0;i<len;i++){
				prices[i]=ls.get(i).getHighPrice();
				lowprices[i]=ls.get(i).getLowPrice();
				volume[i]=ls.get(i).getVolume();
			}
			//最高价
			double[] highestPriceOutReal = new double[1];
			
			//最低价
			double[] lowestPriceOutReal = new double[1];
			
			item.setId(tp[0]);
			item.setEndTime(tp[1]);
			item.setOpenPrice(ls.get(0).getOpenPrice());
			item.setClosePrice(ls.get(len-1).getClosePrice());
			//最高价
			RetCode rc= core.max(0, len-1, prices, len, outBegIdx, outNBElement, highestPriceOutReal);
			if(RetCode.Success==rc){
				item.setHighPrice(highestPriceOutReal[0]);
			}else{
				System.out.println(rc);
				return null;
			}
			//最低价
			RetCode lowestRc= core.min(0, len-1, lowprices, len, outBegIdx, outNBElement, lowestPriceOutReal);
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
	public <T extends OHLCDataItem> void  addOHLCData(Class<T> clazz,String instrumentId,long now) {
		OHLCDataItem item= this.getLastOHCLData(clazz,instrumentId,now);
		if(item!=null){
			this.oHLCDataDao.save(item);
		}
	}

	@Override
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz, String instrumentId, long start, long end) {
		return this.oHLCDataDao.getList(clazz, instrumentId, start, end);
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
	
	/**
	 * 获取当日走的K线个数
	 * @param clazz
	 * @param instrumentId
	 * @param time
	 * @return
	 * @author meixinbin 2016-8-16 上午10:30:50
	 */
	@Override
	public <T extends OHLCDataItem> int   getKLineOfDay(Class<T> clazz, String instrumentId,long time) {
		OHLCData1Day day = new OHLCData1Day();
		List<T> ls =  this.oHLCDataDao.getAfterList(clazz,instrumentId,day.timePeriod(time)[0]);
		if(ls!=null){
			return ls.size();
		}
		return 0;
	}
	
	
	@Override
	public OHLCData1Day getById(String instrumentId, long id) {
		return this.oHLCDataDao.getById(instrumentId, id);
	}
	/**
	 * 获取指定时间之前的K线序列
	 * @param clazz
	 * @param instrumentId
	 * @param time
	 * @param count
	 * @return
	 * @author meixinbin 2016-8-16 上午10:16:23
	 */
	public <T extends OHLCDataItem> List<T> getBeforeData(Class<T> clazz,String instrumentId, long time,int count){
		T item = null;
		try {
			item = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		long endTime = item.timePeriod(time)[1];
		return this.oHLCDataDao.getBeforeData(clazz,instrumentId, endTime, count);
	}

}
