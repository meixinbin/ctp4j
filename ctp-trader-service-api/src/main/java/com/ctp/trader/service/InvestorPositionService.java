package com.ctp.trader.service;

import java.util.List;

import com.ctp.trader.dto.InvestorPositionDTO;

public interface InvestorPositionService {

	/**
	 * 获取合约的持仓信息
	 * @param instrumentId
	 * @return
	 * @author meixinbin 2016-6-24 上午10:39:36
	 */
	public List<InvestorPositionDTO> getList(String brokerID, String instrumentID, String investorID); 
}
