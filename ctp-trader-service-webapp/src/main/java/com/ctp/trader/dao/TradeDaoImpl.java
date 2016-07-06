package com.ctp.trader.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ctp.trader.entity.Trade;

public class TradeDaoImpl implements TradeDao{
	
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(Trade trade) {
		this.mongoTemplate.save(trade);
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Trade getTradeByOrderRef(String orderRef) {
		List<Trade> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("orderRef").is(orderRef)), Trade.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

	@Override
	public Trade getLatestTrade(String brokerID, String investorID, String instrumentID, char offsetFlag, char direction) {
		List<Trade> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("investorID").is(investorID).and("instrumentID").is(instrumentID).and("offsetFlag").is(offsetFlag).and("direction").is(direction)).with(new Sort(Direction.DESC, "tradeDateTime")), Trade.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}
}
