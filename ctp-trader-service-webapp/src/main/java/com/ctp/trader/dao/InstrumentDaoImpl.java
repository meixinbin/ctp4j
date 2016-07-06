package com.ctp.trader.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ctp.trader.entity.Instrument;
import com.itqy8.framework.dao.BaseDaoImpl;

/**
 * 
 * @author meixinbin
 *
 */
public class InstrumentDaoImpl extends BaseDaoImpl implements InstrumentDao{

	private static final long serialVersionUID = 1L;

	private MongoTemplate mongoTemplate;
	
	
	@Override
	public List<Instrument> getInstrumentList() {
		List<Instrument> ls = this.mongoTemplate.findAll(Instrument.class);
		return ls;
	}

	@Override
	public void save(Instrument ins) {
		mongoTemplate.save(ins);
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Instrument getInstrument(String instrumentId) {
		List<Instrument> ls = this.mongoTemplate.find(new Query(Criteria.where("instrumentID").is(instrumentId)), Instrument.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}
