package com.ctp.trader.service;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.ctp.trader.dao.TradingAccountDao;
import com.ctp.trader.dto.TradingAccountDTO;
import com.ctp.trader.entity.TradingAccount;
import com.ctp.trader.service.TradingAccountService;

public class TradingAccountServiceImpl implements TradingAccountService {

	private TradingAccountDao tradingAccountDao;

	@Override
	public TradingAccountDTO getTradingAccount(String brokerID, String investorID) {
		TradingAccountDTO dto = new TradingAccountDTO();
		TradingAccount ta = tradingAccountDao.get(brokerID, investorID);
		if(ta!=null){
			try {
				BeanUtils.copyProperties(dto, ta);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	public void setTradingAccountDao(TradingAccountDao tradingAccountDao) {
		this.tradingAccountDao = tradingAccountDao;
	}

}
