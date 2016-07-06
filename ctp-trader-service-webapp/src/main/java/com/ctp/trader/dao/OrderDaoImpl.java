package com.ctp.trader.dao;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ctp.trader.entity.Order;

public class OrderDaoImpl implements OrderDao{
	
	private MongoTemplate mongoTemplate;
	
	@Override
	public void save(Order order) {
		this.mongoTemplate.save(order);
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Order getOrderByOrderRef(String orderRef) {
		List<Order> ls = this.mongoTemplate.find(new Query().addCriteria(Criteria.where("orderRef").is(orderRef)), Order.class);
		if(ls!=null && ls.size()>0){
			return ls.get(0);
		}
		return null;
	}
}
