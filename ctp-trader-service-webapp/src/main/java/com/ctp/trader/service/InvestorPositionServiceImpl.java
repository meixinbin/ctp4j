package com.ctp.trader.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ctp.trader.dao.InvestorPositionDao;
import com.ctp.trader.dto.InvestorPositionDTO;
import com.ctp.trader.entity.InvestorPosition;
import com.ctp.trader.service.InvestorPositionService;

public class InvestorPositionServiceImpl implements InvestorPositionService{

	private InvestorPositionDao investorPositionDao;
	
	@Override
	public List<InvestorPositionDTO> getList(String brokerID, String instrumentID, String investorID) {
		List<InvestorPosition> ls = this.investorPositionDao.getInvestorPosition(brokerID, instrumentID, investorID);
		if(ls!=null){
			List<InvestorPositionDTO> dtols = new ArrayList<InvestorPositionDTO>();
			for(InvestorPosition ip:ls){
				InvestorPositionDTO dto = new InvestorPositionDTO();
				try {
					BeanUtils.copyProperties(dto, ip);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				dtols.add(dto);
			}
			return dtols;
		}
		return null;
	}

	public void setInvestorPositionDao(InvestorPositionDao investorPositionDao) {
		this.investorPositionDao = investorPositionDao;
	}

}
