package com.ctp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ctp.data.entity.MarketData;

@Repository("marketDataDao")
public class MarketDataDaoImpl implements MarketDataDao{

	@Resource(name="mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	/**
	 * 保存行情数据
	 * 
	 * @param marketData
	 * @author meixinbin 2016-7-11 下午1:43:28
	 */
	@Override
	public void save(MarketData marketData) {
		this.mongoTemplate.save(marketData);
	}
	
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
	public List<MarketData> getList(String instrumentId,long start,long end){
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentID").is(instrumentId).and("id").gte(start).lte(end)).with(new Sort(Sort.Direction.ASC, "id")), MarketData.class);
	}
	
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
	@Override
	public MarketData getLast(String instrumentId, long lastTime) {
		List<MarketData> ls =  mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentID").is(instrumentId).and("id").is(lastTime)).limit(1), MarketData.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}
	
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
	public List<MarketData> getList(String instrumentId,long start,long end,int count){
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentID").is(instrumentId).and("id").gte(start).lte(end)).limit(count).with(new Sort(Sort.Direction.ASC, "id")), MarketData.class);
	}
	
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	
	/**
	 * 根据行情时间戳查询行情信息
	 * 
	 * @param instrumentId
	 *            合约代码
	 * @param id
	 * @return
	 * @author meixinbin 2016-7-11 下午1:45:58
	 */
	public MarketData findOne(String instrumentId,long id){
		List<MarketData> ls =  this.mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentID").is(instrumentId).and("id").is(id)),MarketData.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}
