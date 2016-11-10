package com.ctp.data.service;

import java.util.List;

import com.ctp.data.entity.MarketData;

/**
 * 行情数据接口
 * @author meixinbin
 * @2016-7-11
 */
public interface MarketDataService {

	/**
	 * 保存行情数据
	 * @param marketData
	 * @author meixinbin 2016-7-11 下午2:33:35
	 */
	public void save(MarketData marketData);
	
	/**
	 * 获取行情数据列表
	 * @param instrumentId 合约代码
	 * @param start 开始时间
	 * @param end 结束时间
	 * @return
	 * @author meixinbin 2016-7-11 下午2:34:16
	 */
	public List<MarketData> getList(String instrumentId,long start,long end);
	
	/**
	 * 获取行情数据列表
	 * @param instrumentId
	 * @param start
	 * @param end
	 * @param count
	 * @return
	 * @author meixinbin 2016-7-11 下午2:35:00
	 */
	public List<MarketData> getList(String instrumentId,long start,long end,int count);
	
	/**
	 * 查询一条行情信息
	 * @param instrumentId
	 * @param id
	 * @return
	 * @author meixinbin 2016-7-11 下午2:35:14
	 */
	public MarketData findOne(String instrumentId,long id);
	
	/**
	 * 获取最新行情信息
	 * @param instrumentId
	 * @param lastTime
	 * @return
	 * @author meixinbin 2016-7-11 下午2:35:47
	 */
	public MarketData getLast(String instrumentId,long lastTime);
}
