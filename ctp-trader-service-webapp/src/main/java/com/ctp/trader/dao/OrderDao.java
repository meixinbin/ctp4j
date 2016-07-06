package com.ctp.trader.dao;

import com.ctp.trader.entity.Order;

public interface OrderDao {
	
	public void save(Order order);
	
	public Order getOrderByOrderRef(String orderRef);
}
