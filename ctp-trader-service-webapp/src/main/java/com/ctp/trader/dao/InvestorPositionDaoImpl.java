package com.ctp.trader.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ctp.trader.entity.InvestorPosition;

public class InvestorPositionDaoImpl implements InvestorPositionDao{
	
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(InvestorPosition investorPosition) {
		this.mongoTemplate.save(investorPosition);
	}

	@Override
	public List<InvestorPosition> getInvestorPosition(String brokerID, String instrumentID, String investorID) {
		List<InvestorPosition> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID).and("positionDate").is("2")), InvestorPosition.class);
		return ls;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public InvestorPosition getInvestorPosition(String brokerID, String instrumentID, String investorID, char posiDirection, char positionDate) {
		List<InvestorPosition> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID).and("posiDirection").is(posiDirection).and("positionDate").is(positionDate)), InvestorPosition.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}
	
}
