package com.ctp.dao;

import java.util.List;

import com.ctp.data.entity.MarketData;

/**
 * 行情数据dao接口
 * 
 * @author meixinbin
 * @2016-7-11
 */
public interface MarketDataDao {

	/**
	 * 保存行情数据
	 * 
	 * @param marketData
	 * @author meixinbin 2016-7-11 下午1:43:28
	 */
	public void save(MarketData marketData);

	/**
	 * 获取一个时间段的行情数据列表
	 * 
	 * @param instrumentId
	 *            合约代码
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @return
	 * @author meixinbin 2016-7-11 下午1:43:50
	 */
	public List<MarketData> getList(String instrumentId, long start, long end);

	/**
	 * 获取一个时间段的行情数据列表
	 * 
	 * @param instrumentId
	 *            合约代码
	 * @param start
	 *            开始时间
	 * @param end
	 *            结束时间
	 * @param count
	 *            最大记录数
	 * @return
	 * @author meixinbin 2016-7-11 下午1:44:55
	 */
	public List<MarketData> getList(String instrumentId, long start, long end, int count);

	/**
	 * 根据行情时间戳查询行情信息
	 * 
	 * @param instrumentId
	 *            合约代码
	 * @param id
	 * @return
	 * @author meixinbin 2016-7-11 下午1:45:58
	 */
	public MarketData findOne(String instrumentId, long id);

	/**
	 * 根据时间查询最新的行情数据
	 * 
	 * @param instrumentId
	 *            合约代码
	 * @param lastTime
	 *            时间
	 * @return
	 * @author meixinbin 2016-7-11 下午1:46:44
	 */
	public MarketData getLast(String instrumentId, long lastTime);

}
