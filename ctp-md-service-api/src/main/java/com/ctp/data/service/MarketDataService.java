package com.ctp.data.service;

import java.util.List;

import com.ctp.data.entity.MarketData;

public interface MarketDataService {

public void save(MarketData marketData);
	
	public List<MarketData> getList(String instrumentId,long start,long end);
	
	public List<MarketData> getList(String instrumentId,long start,long end,int count);
	public MarketData findOne(String instrumentId,long id);
	
	public MarketData getLast(String instrumentId,long lastTime);
}
