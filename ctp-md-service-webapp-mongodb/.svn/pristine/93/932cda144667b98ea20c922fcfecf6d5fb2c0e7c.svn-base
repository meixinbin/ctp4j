package com.ctp.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.ctp.data.entity.MarketData;

public class MarketDataDaoImpl implements MarketDataDao{

	private MongoTemplate mongoTemplate;
	
	@Override
	public MarketData getLast(String instrumentId, long lastTime) {
		List<MarketData> ls =  mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentID").is(instrumentId).and("id").lt(lastTime)).limit(1).with(new Sort(Sort.Direction.ASC, "id")), MarketData.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}
	
	public List<MarketData> getList(String instrumentId,long start,long end){
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentID").is(instrumentId).and("id").gte(start).lte(end)).with(new Sort(Sort.Direction.ASC, "id")), MarketData.class);
	}
	public List<MarketData> getList(String instrumentId,long start,long end,int count){
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentID").is(instrumentId).and("id").gte(start).lte(end)).limit(count).with(new Sort(Sort.Direction.ASC, "id")), MarketData.class);
	}
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	@Override
	public void save(MarketData marketData) {
		this.mongoTemplate.save(marketData);
	}
	
	public MarketData findOne(String instrumentId,long id){
		List<MarketData> ls =  this.mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentID").is(instrumentId).and("id").is(id)),MarketData.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}
