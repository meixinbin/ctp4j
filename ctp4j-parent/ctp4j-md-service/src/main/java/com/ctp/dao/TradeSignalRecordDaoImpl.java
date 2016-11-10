package com.ctp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ctp.data.entity.TradeSignalRecord;

@Repository("tradeSignalRecordDao")
public class TradeSignalRecordDaoImpl implements TradeSignalRecordDao{
	
	@Resource(name="mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(TradeSignalRecord tradeSignalRecord) {
		this.mongoTemplate.save(tradeSignalRecord);
	}

	@Override
	public TradeSignalRecord getTradeSignalRecord(String strategyCode, long endTime) {
		List<TradeSignalRecord> ls =  this.mongoTemplate.find(new Query().addCriteria(Criteria.where("strategyCode").is(strategyCode).and("ohlcdTime").lte(endTime)), TradeSignalRecord.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}
