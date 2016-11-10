package com.ctp.trader.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ctp.trader.entity.TradingAccount;

public class TradingAccountDaoImpl implements TradingAccountDao{
	
	private MongoTemplate mongoTemplate;
	
	
	@Override
	public void save(TradingAccount ta) {
		mongoTemplate.save(ta);
	}


	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}



	@Override
	public TradingAccount get(String brokerID, String accountID) {
		List<TradingAccount> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("brokerID").is(brokerID).and("accountID").is(accountID)), TradingAccount.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}

}
