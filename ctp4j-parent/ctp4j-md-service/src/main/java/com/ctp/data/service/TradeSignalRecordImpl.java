package com.ctp.data.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ctp.dao.TradeSignalRecordDao;
import com.ctp.data.entity.TradeSignalRecord;
import com.itqy8.sequence.service.SequenceService;

@Service("tradeSignalRecordService")
public class TradeSignalRecordImpl implements TradeSignalRecordService{

	@Resource(name="sequenceService")
	private SequenceService sequenceService;
	@Resource(name="tradeSignalRecordDao")
	private TradeSignalRecordDao tradeSignalRecordDao;
	
	@Override
	public void save(TradeSignalRecord tradeSignalRecord) {
//		tradeSignalRecord.setId(this.sequenceService.generate(TradeSignalRecord.class.getName()).getResult());
		tradeSignalRecord.setId(System.currentTimeMillis());
		this.tradeSignalRecordDao.save(tradeSignalRecord);
	}


	@Override
	public TradeSignalRecord getTradeSignalRecord(String strategyCode, long endTime) {
		return this.tradeSignalRecordDao.getTradeSignalRecord(strategyCode, endTime);
	}

}
