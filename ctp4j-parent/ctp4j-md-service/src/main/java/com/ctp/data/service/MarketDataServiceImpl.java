package com.ctp.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctp.dao.MarketDataDao;
import com.ctp.data.entity.MarketData;

@Service("marketDataService")
public class MarketDataServiceImpl implements MarketDataService{

	@Resource(name="marketDataDao")
	private MarketDataDao marketDataDao;

	@Override
	public void save(MarketData marketData) {
		this.marketDataDao.save(marketData);
	}

	@Override
	public List<MarketData> getList(String instrumentId, long start, long end) {
		return this.marketDataDao.getList(instrumentId, start, end);
	}

	@Override
	public List<MarketData> getList(String instrumentId, long start, long end, int count) {
		return this.marketDataDao.getList(instrumentId, start, end, count);
	}

	@Override
	public MarketData findOne(String instrumentId, long id) {
		return this.marketDataDao.findOne(instrumentId, id);
	}

	@Override
	public MarketData getLast(String instrumentId, long lastTime) {
		return this.marketDataDao.getLast(instrumentId, lastTime);
	}

	public void setMarketDataDao(MarketDataDao marketDataDao) {
		this.marketDataDao = marketDataDao;
	}
	
}
