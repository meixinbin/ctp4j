package com.ctp.data.service;

import java.util.List;

import com.ctp.data.entity.MarketData;
import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCDataItem;

public interface OHLCDataService {

	public void save(OHLCDataItem data);
	
	public void addOHLCData(MarketData data);
	
	public void addAllOHLCData(MarketData data);
	
	
	public <T extends OHLCDataItem> void  add(Class<T> clazz,String instrumentId,long now);
	
	public OHLCDataItem getYdOHLCData(String instrumentId);
	
	/**
	 * 获取最新K线数据
	 * @param instrumentId
	 * @param timeUnits
	 * @return
	 * @author meixinbin 2016-6-2 下午2:16:02
	 */
	OHLCDataItem getLastOHLCData(String instrumentId,long now,int timePeriod);
	
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end);
	
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end,int count);
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,int count);
	public <T extends OHLCDataItem> List<T> getLatestList(Class<T> clazz, String instrumentId, int count);
	public <T extends OHLCDataItem> int  getKLine(Class<T> clazz,String instrumentId,long time);
	
	public OHLCData1Day getById(String instrumentId,long id);
	
	public OHLCData1Day getYdData(String instrumentId,long id);
	
}
