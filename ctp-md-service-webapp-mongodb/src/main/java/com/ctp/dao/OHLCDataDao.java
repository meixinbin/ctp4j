package com.ctp.dao;

import java.util.List;

import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCDataItem;

public interface OHLCDataDao {

	/**
	 * 
	 * @param data
	 * @author meixinbin 2016-6-6 下午2:23:42
	 */
	public void save(OHLCDataItem data);
	
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end);
	
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end,int count);
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,int count);
	public <T extends OHLCDataItem> T findOne(Class<T> clazz,String instrumentId,long id);
	
	public <T> int  getBarLength(Class<T> clazz,String instrumentID,long time);
	
	/**
	 * 
	 * @param instrumentId
	 * @param id
	 * @return
	 * @author meixinbin 2016-7-5 上午11:09:06
	 */
	public OHLCData1Day getById(String instrumentId, long id);
	
	public <T extends OHLCDataItem> List<T> getAfterList(Class<T> clazz,String instrumentId,long start);
	
	
	public OHLCData1Day getYdData(String instrumentId, long id);
}
