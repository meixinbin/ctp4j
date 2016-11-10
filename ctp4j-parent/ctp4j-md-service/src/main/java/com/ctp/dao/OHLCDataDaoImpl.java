package com.ctp.dao;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCDataItem;

@Repository("oHLCDataDao")
public class OHLCDataDaoImpl implements OHLCDataDao{
	
	@Resource(name="mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	public <T extends OHLCDataItem> List<T> getList(Class<T> clazz,String instrumentId,long start,long end){
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId).and("id").gte(start).lte(end)).with(new Sort(Sort.Direction.ASC, "id")),clazz);
	}
	
	@Override
	public void save(OHLCDataItem data) {
		this.mongoTemplate.save(data);
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
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId).and("id").gte(start)),clazz);
	}
	
	/**
	 * 获取日K线
	 * @param instrumentId
	 * @param time
	 * @param count
	 * @return
	 * @author meixinbin 2016-8-16 上午10:01:40
	 */
	@Override
	public <T extends OHLCDataItem> List<T> getBeforeData(Class<T> clazz,String instrumentId, long time,int count) {
		List<T> ls = mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId).and("endTime").lt(time)).with(new Sort(Sort.Direction.DESC, "id")).limit(count), clazz);
		if(ls!=null && ls.size()>0){
			Collections.reverse(ls);
			return ls;
		}
		return null;
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
		return mongoTemplate.find(new Query().addCriteria(Criteria.where("instrumentId").is(instrumentId)).limit(count).with(new Sort(Sort.Direction.DESC, "id")), clazz);
	}
	
	
}
