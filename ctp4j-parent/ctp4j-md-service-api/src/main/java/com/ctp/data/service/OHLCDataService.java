package com.ctp.data.service;

import java.util.List;

import com.ctp.data.entity.MarketData;
import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCDataItem;

public interface OHLCDataService {

	/**
	 * 保存K线数据
	 * @param data
	 * @author meixinbin 2016-7-11 下午2:36:37
	 */
	public void save(OHLCDataItem data);
	
	/**
	 * 添加最新单位K线数据
	 * @param data
	 * @author meixinbin 2016-7-11 下午2:40:45
	 */
	public void addOHLCData1Minute(MarketData data);
	
	/**
	 * 添加所有预定义时间段的K线数据
	 * @param data
	 * @author meixinbin 2016-7-11 下午2:41:16
	 */
	public void addAllOHLCData(MarketData data);
	
	/**
	 * 添加K线数据
	 * @param clazz
	 * @param instrumentId
	 * @param now
	 * @author meixinbin 2016-7-11 下午2:42:02
	 */
	public <T extends OHLCDataItem> void  addOHLCData(Class<T> clazz,String instrumentId,long now);
	
	public OHLCDataItem getYdOHLCData(String instrumentId);
	
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end);
	
	
	/**
	 * 获取最新的K线数据
	 * @param clazz
	 * @param instrumentId
	 * @param count
	 * @return
	 * @author meixinbin 2016-7-11 下午2:29:06
	 */
	public <T extends OHLCDataItem> List<T> getLatestList(Class<T> clazz, String instrumentId, int count);
	
	/**
	 * 获取当日走的K线个数
	 * @param clazz
	 * @param instrumentId
	 * @param time
	 * @return
	 * @author meixinbin 2016-8-16 上午10:30:50
	 */
	public <T extends OHLCDataItem> int  getKLineOfDay(Class<T> clazz,String instrumentId,long time);
	
	public OHLCData1Day getById(String instrumentId,long id);
	
	/**
	 * 获取指定时间之前的K线序列
	 * @param clazz
	 * @param instrumentId
	 * @param time
	 * @param count
	 * @return
	 * @author meixinbin 2016-8-16 上午10:16:23
	 */
	public <T extends OHLCDataItem> List<T> getBeforeData(Class<T> clazz,String instrumentId, long time,int count);
	
}
