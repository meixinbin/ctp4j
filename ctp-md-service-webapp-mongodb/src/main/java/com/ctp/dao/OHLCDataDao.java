package com.ctp.dao;

import java.util.List;

import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCDataItem;

/**
 * K线数据dao接口
 * @author meixinbin
 * @2016-7-11
 */
public interface OHLCDataDao {

	/**
	 * 保存K线数据
	 * @param data
	 * @author meixinbin 2016-6-6 下午2:23:42
	 */
	public void save(OHLCDataItem data);
	
	/**
	 * 获取一个时间段的K线数据
	 * @param clazz 
	 * @param instrumentId
	 * @param start
	 * @param end
	 * @return
	 * @author meixinbin 2016-7-11 下午2:27:48
	 */
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end);
	
	
	/**
	 * 获取最新的K线数据
	 * @param clazz
	 * @param instrumentId
	 * @param count
	 * @return
	 * @author meixinbin 2016-7-11 下午2:29:06
	 */
	public <T extends OHLCDataItem> List<T> getLatestList(Class<T> clazz,String instrumentId,int count);
	
	/**
	 * 
	 * @param clazz
	 * @param instrumentId
	 * @param id
	 * @return
	 * @author meixinbin 2016-7-11 下午2:29:27
	 */
	public <T extends OHLCDataItem> T findOne(Class<T> clazz,String instrumentId,long id);
	
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
