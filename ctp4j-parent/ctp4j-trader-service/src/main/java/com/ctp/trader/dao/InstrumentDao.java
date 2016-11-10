package com.ctp.trader.dao;

import java.util.List;

import com.ctp.trader.entity.Instrument;

/**
 * 
 * @author meixinbin
 * @version 1.0
 */
public interface InstrumentDao{

	public List<Instrument> getInstrumentList();
	
	
	public void save(Instrument ins);
	
	public Instrument getInstrument(String instrumentId);
}
