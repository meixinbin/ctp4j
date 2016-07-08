package com.ctp.trader.service;

import java.util.List;

import com.ctp.trader.dto.InvestorPositionDTO;
import com.ctp.trader.dto.OrderDTO;

public interface TraderService {

	public void orderInsert(OrderDTO order);
	
	public List<InvestorPositionDTO> qryInvestorPosition(String brokerID,String instrumentID,String investorID);
	
	public InvestorPositionDTO getInvestorPosition(String brokerID, String instrumentID, String investorID, char posiDirection, char positionDate);
	
	/**
	 * 买开
	 * @param instrumentid
	 * @param exchangeid
	 * @param price
	 * @param pricetype
	 * @param volume
	 * @author meixinbin 2016-6-17 下午4:03:29
	 */
	public void bk(String instrumentid,String exchangeid,double price,char pricetype,int volume);
	
	/**
	 * 卖开
	 * @param instrumentid
	 * @param exchangeid
	 * @param price
	 * @param pricetype
	 * @param volume
	 * @author meixinbin 2016-6-17 下午4:04:09
	 */
	public void sk(String instrumentid,String exchangeid,double price,char pricetype,int volume);
	
	/**
	 * 买平
	 * @param instrumentid
	 * @param exchangeid
	 * @param price
	 * @param pricetype
	 * @param volume
	 * @author meixinbin 2016-6-17 下午4:05:15
	 */
	public void bp(String instrumentid,String exchangeid,double price,char pricetype,int volume);
	
	public void yd_bp(String instrumentid, String exchangeid, double price, char pricetype, int volume);
	
	/**
	 * 卖平
	 * @param instrumentid
	 * @param exchangeid
	 * @param price
	 * @param pricetype
	 * @param volume
	 * @author meixinbin 2016-6-17 下午4:05:55
	 */
	public void sp(String instrumentid,String exchangeid,double price,char pricetype,int volume);
	
	public void yd_sp(String instrumentid, String exchangeid, double price, char pricetype, int volume);
	
	public Long getLatestTradeTime(String instrumentID,char offsetFlag,char direction);
	
	
}
