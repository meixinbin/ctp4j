package com.ctp.trader.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ctp.trader.entity.InvestorPositionDetail;

public class InvestorPositionDetailDaoImpl implements InvestorPositionDetailDao{
	private MongoTemplate mongoTemplate;
	@Override
	public void save(InvestorPositionDetail investorPosition) {
		this.mongoTemplate.save(investorPosition);
	}

	@Override
	public List<InvestorPositionDetail> getInvestorPositionDetail(String brokerID, String instrumentID, String investorID) {
		List<InvestorPositionDetail> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID)), InvestorPositionDetail.class);
		return ls;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public InvestorPositionDetail getInvestorPositionDetail(String brokerID, String instrumentID, String investorID, String tradeID) {
		List<InvestorPositionDetail> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID).and("tradeID").is(tradeID)), InvestorPositionDetail.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

	@Override
	public InvestorPositionDetail getLatestPositionDetail(String brokerID, String instrumentID, String investorID,String direction) {
		List<InvestorPositionDetail> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("instrumentID").is(instrumentID).and("investorID").is(investorID).and("direction").is(direction)).with(new Sort(Direction.DESC,"openDate")), InvestorPositionDetail.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}
