package com.ctp.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCDataItem;

public class OHLCDataDaoImpl implements OHLCDataDao{
	
	private MongoTemplate mongoTemplate;
	
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end){
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId).and("id").gt(start).lte(end)),clazz);
	}
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end,int count){
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId).and("id").gt(start).lte(end)).limit(count).with(new Sort(Sort.Direction.ASC, "id")), clazz);
	}
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,int count){
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId)).limit(count).with(new Sort(Sort.Direction.ASC, "id")), clazz);
	}
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}
	
	@Override
	public void save(OHLCDataItem data) {
		this.mongoTemplate.save(data);
	}
	@Override
	public <T> int getBarLength(Class<T> clazz, String instrumentID, long time) {
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentID).and("id").lt(time)).with(new Sort(Sort.Direction.ASC, "id")), clazz).size();
	}
	@Override
	public <T extends OHLCDataItem> T findOne(Class<T> clazz, String instrumentId, long id) {
		List<T> tls =  mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId).and("id").is(id)),clazz);
		if(tls!=null && tls.size()>0){
			return tls.get(0);
		}
		return null;
	}
	@Override
	public OHLCData1Day getById(String instrumentId, long id) {
		return this.findOne(OHLCData1Day.class, instrumentId, id);
	}
	@Override
	public <T extends OHLCDataItem> List<T> getAfterList(Class<T> clazz, String instrumentId, long start) {
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId).and("id").gt(start)),clazz);
	}
	@Override
	public OHLCData1Day getYdData(String instrumentId, long id) {
		List<OHLCData1Day> ls = mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId).and("id").lte(id)).with(new Sort(Sort.Direction.DESC, "id")).limit(1), OHLCData1Day.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}
	@Override
	public <T extends OHLCDataItem> List<T> getLatestList(Class<T> clazz, String instrumentId, int count) {
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId)).limit(count).with(new Sort(Sort.Direction.DESC, "id")), clazz);
	}
	

}
