package com.ctp.trader.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.ctp.service.TraderApiWrap;
import com.ctp.trader.dao.InvestorPositionDao;
import com.ctp.trader.dao.TradeDao;
import com.ctp.trader.dto.InvestorPositionDTO;
import com.ctp.trader.dto.OrderDTO;
import com.ctp.trader.entity.InvestorPosition;
import com.ctp.trader.entity.Trade;
import com.itqy8.ctp.CThostFtdcInputOrderField;
import com.itqy8.framework.util.SpringPropertyResourceReader;
import com.itqy8.sequence.service.SequenceService;

public class TraderServiceImpl implements TraderService{

	private InvestorPositionDao investorPositionDao;
	private TradeDao tradeDao;
	private SequenceService sequenceService;
	private String brokerID;
	private String investorID;
	
	public TraderServiceImpl(){
		brokerID = SpringPropertyResourceReader.getProperty("ctp.brokerId");
		investorID = SpringPropertyResourceReader.getProperty("ctp.userid");
	}
	
	@Override
	public void orderInsert(OrderDTO order) {
		CThostFtdcInputOrderField pInputOrder = new CThostFtdcInputOrderField();
		pInputOrder.setBrokerID(order.getBrokerID());
		pInputOrder.setInvestorID(order.getInvestorID());
		pInputOrder.setInstrumentID(order.getInstrumentID());
		pInputOrder.setOrderRef(this.sequenceService.generate("order_ref").getResult()+"");
		pInputOrder.setUserID(order.getUserID());
		
		pInputOrder.setVolumeCondition(order.getVolumeCondition());//成交量类型：任何数量
		pInputOrder.setMinVolume(order.getMinVolume());/// 最小成交量：1
		pInputOrder.setForceCloseReason(order.getForceCloseReason());/// 强平原因：非强平
		pInputOrder.setIsAutoSuspend(order.getIsAutoSuspend());/// 自动挂起标志：否
		pInputOrder.setUserForceClose(order.getUserForceClose());///用户强评标志：否
		pInputOrder.setDirection(order.getDirection());
		
		pInputOrder.setOrderPriceType(order.getOrderPriceType());
		pInputOrder.setTimeCondition(order.getTimeCondition());
		pInputOrder.setLimitPrice(order.getLimitPrice());
		pInputOrder.setStopPrice(order.getStopPrice());
		pInputOrder.setCombOffsetFlag(order.getCombOffsetFlag());
		pInputOrder.setCombHedgeFlag(order.getCombHedgeFlag());
		pInputOrder.setVolumeTotalOriginal(order.getVolumeTotalOriginal());
		pInputOrder.setContingentCondition(order.getContingentCondition());
		pInputOrder.setRequestID(this.sequenceService.generate("request_id").getResult().intValue());
		TraderApiWrap.getTraderApi().ReqOrderInsert(pInputOrder, pInputOrder.getRequestID());
	}
	
	public void qryTrade(){
	}
	
	public List<InvestorPositionDTO> qryInvestorPosition(String brokerID,String instrumentID,String investorID){
		List<InvestorPosition> ipls = investorPositionDao.getInvestorPosition(brokerID, instrumentID, investorID);
		if(ipls!=null){
			List<InvestorPositionDTO> dtols = new ArrayList<InvestorPositionDTO>();
			for(InvestorPosition ip:ipls){
				InvestorPositionDTO dto = new InvestorPositionDTO();
				try {
					BeanUtils.copyProperties(dto, ip);
					dtols.add(dto);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			return dtols;
		}
		return null;
	}

	public void setSequenceService(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}

	public void setInvestorPositionDao(InvestorPositionDao investorPositionDao) {
		this.investorPositionDao = investorPositionDao;
	}

	@Override
	public void bk(String instrumentid, String exchangeid, double price, char pricetype, int volume) {
		CThostFtdcInputOrderField pInputOrder = new CThostFtdcInputOrderField();
		pInputOrder.setBrokerID(brokerID);
		pInputOrder.setInvestorID(investorID);
		pInputOrder.setInstrumentID(instrumentid);
		pInputOrder.setOrderRef(this.sequenceService.generate("order_ref").getResult()+"");
		pInputOrder.setUserID(investorID);
		
		pInputOrder.setVolumeCondition('1');//成交量类型：任何数量
		pInputOrder.setMinVolume(1);/// 最小成交量：1
		pInputOrder.setForceCloseReason('0');/// 强平原因：非强平
		pInputOrder.setIsAutoSuspend(0);/// 自动挂起标志：否
		pInputOrder.setUserForceClose(0);///用户强评标志：否
		pInputOrder.setDirection('0');
		
		pInputOrder.setOrderPriceType(pricetype);//报单价格条件
		pInputOrder.setTimeCondition('3');//当日有效
		pInputOrder.setLimitPrice(price);
//		pInputOrder.setStopPrice(order.getStopPrice());
		pInputOrder.setCombOffsetFlag("0");
		pInputOrder.setCombHedgeFlag("1");
		pInputOrder.setVolumeTotalOriginal(volume);
		pInputOrder.setContingentCondition('1');
		pInputOrder.setRequestID(this.sequenceService.generate("request_id").getResult().intValue());
		TraderApiWrap.getTraderApi().ReqOrderInsert(pInputOrder, pInputOrder.getRequestID());
	}

	@Override
	public void sk(String instrumentid, String exchangeid, double price, char pricetype, int volume) {
		CThostFtdcInputOrderField pInputOrder = new CThostFtdcInputOrderField();
		pInputOrder.setBrokerID(brokerID);
		pInputOrder.setInvestorID(investorID);
		pInputOrder.setInstrumentID(instrumentid);
		pInputOrder.setOrderRef(this.sequenceService.generate("order_ref").getResult()+"");
		pInputOrder.setUserID(investorID);
		
		pInputOrder.setVolumeCondition('1');//成交量类型：任何数量
		pInputOrder.setMinVolume(1);/// 最小成交量：1
		pInputOrder.setForceCloseReason('0');/// 强平原因：非强平
		pInputOrder.setIsAutoSuspend(0);/// 自动挂起标志：否
		pInputOrder.setUserForceClose(0);///用户强评标志：否
		pInputOrder.setDirection('1');
		
		pInputOrder.setOrderPriceType(pricetype);
		pInputOrder.setTimeCondition('3');//当日有效
		pInputOrder.setLimitPrice(price);
//		pInputOrder.setStopPrice(order.getStopPrice());
		pInputOrder.setCombOffsetFlag("0");
		pInputOrder.setCombHedgeFlag("1");
		pInputOrder.setVolumeTotalOriginal(volume);
		pInputOrder.setContingentCondition('1');
		pInputOrder.setRequestID(this.sequenceService.generate("request_id").getResult().intValue());
		TraderApiWrap.getTraderApi().ReqOrderInsert(pInputOrder, pInputOrder.getRequestID());
		
	}

	@Override
	public void bp(String instrumentid, String exchangeid, double price, char pricetype, int volume) {
		CThostFtdcInputOrderField pInputOrder = new CThostFtdcInputOrderField();
		pInputOrder.setBrokerID(brokerID);
		pInputOrder.setInvestorID(investorID);
		pInputOrder.setInstrumentID(instrumentid);
		pInputOrder.setOrderRef(this.sequenceService.generate("order_ref").getResult()+"");
		pInputOrder.setUserID(investorID);
		
		pInputOrder.setVolumeCondition('1');//成交量类型：任何数量
		pInputOrder.setMinVolume(1);/// 最小成交量：1
		pInputOrder.setForceCloseReason('0');/// 强平原因：非强平
		pInputOrder.setIsAutoSuspend(0);/// 自动挂起标志：否
		pInputOrder.setUserForceClose(0);///用户强评标志：否
		pInputOrder.setDirection('0');
		
		pInputOrder.setOrderPriceType(pricetype);
		pInputOrder.setTimeCondition('3');//当日有效
		pInputOrder.setLimitPrice(price);
//		pInputOrder.setStopPrice(order.getStopPrice());
		pInputOrder.setCombOffsetFlag("1");
		pInputOrder.setCombHedgeFlag("1");
		pInputOrder.setVolumeTotalOriginal(volume);
		pInputOrder.setContingentCondition('1');
		pInputOrder.setRequestID(this.sequenceService.generate("request_id").getResult().intValue());
		TraderApiWrap.getTraderApi().ReqOrderInsert(pInputOrder, pInputOrder.getRequestID());
	}

	@Override
	public void sp(String instrumentid, String exchangeid, double price, char pricetype, int volume) {
		CThostFtdcInputOrderField pInputOrder = new CThostFtdcInputOrderField();
		pInputOrder.setBrokerID(brokerID);
		pInputOrder.setInvestorID(investorID);
		pInputOrder.setInstrumentID(instrumentid);
		pInputOrder.setOrderRef(this.sequenceService.generate("order_ref").getResult()+"");
		pInputOrder.setUserID(investorID);
		
		pInputOrder.setVolumeCondition('1');//成交量类型：任何数量
		pInputOrder.setMinVolume(1);/// 最小成交量：1
		pInputOrder.setForceCloseReason('0');/// 强平原因：非强平
		pInputOrder.setIsAutoSuspend(0);/// 自动挂起标志：否
		pInputOrder.setUserForceClose(0);///用户强评标志：否
		pInputOrder.setDirection('1');
		
		pInputOrder.setOrderPriceType(pricetype);
		pInputOrder.setTimeCondition('3');//当日有效
		pInputOrder.setLimitPrice(price);
//		pInputOrder.setStopPrice(order.getStopPrice());
		pInputOrder.setCombOffsetFlag("1");
		pInputOrder.setCombHedgeFlag("1");
		pInputOrder.setVolumeTotalOriginal(volume);
		pInputOrder.setContingentCondition('1');
		pInputOrder.setRequestID(this.sequenceService.generate("request_id").getResult().intValue());
		TraderApiWrap.getTraderApi().ReqOrderInsert(pInputOrder, pInputOrder.getRequestID());
	}

	@Override
	public InvestorPositionDTO getInvestorPosition(String brokerID, String instrumentID, String investorID, char posiDirection, char positionDate) {
		InvestorPosition ip = this.investorPositionDao.getInvestorPosition(brokerID, instrumentID, investorID, posiDirection, positionDate);
		if(ip!=null){
			InvestorPositionDTO dto = new InvestorPositionDTO();
			try {
				BeanUtils.copyProperties(dto, ip);
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
			return dto;
		}
		return null;
	}

	@Override
	public Long getLatestTradeTime(String instrumentID, char offsetFlag, char direction) {
		Trade t= this.tradeDao.getLatestTrade(brokerID, investorID, instrumentID, offsetFlag, direction);
		if(t!=null){
			return t.getTradeDateTime();
		}
		return null;
	}

	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}

}
