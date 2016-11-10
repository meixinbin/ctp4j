package com.ctp.strategy;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;
import org.joda.time.Period;

import com.ctp.data.entity.MarketData;
import com.ctp.data.entity.OHLCData15Minute;
import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCData5Minute;
import com.ctp.data.entity.TradeSignalRecord;
import com.ctp.data.service.OHLCDataService;
import com.ctp.data.service.TradeSignalRecordService;
import com.ctp.md.vo.PositionInfoVO;
import com.ctp.ta4j.strategy.extra.My018Strategy;
import com.ctp.trader.dto.InvestorPositionDTO;
import com.ctp.trader.dto.TradingAccountDTO;
import com.ctp.trader.service.InvestorPositionService;
import com.ctp.trader.service.TraderService;
import com.ctp.trader.service.TradingAccountService;
import com.itqy8.ctp.CThostFtdcDepthMarketDataField;
import com.itqy8.framework.util.SpringPropertyResourceReader;

import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.Strategy;
import eu.verdelhan.ta4j.Tick;
import eu.verdelhan.ta4j.TimeSeries;
import eu.verdelhan.ta4j.TradingRecord;

public class Strategy018 implements MarketTradeTrategy{

	private TradeSignalRecordService tradeSignalRecordService;
	private OHLCDataService oHLCDataService;
	private TradingAccountService tradingAccountService;
	private TraderService traderService;
	private InvestorPositionService investorPositionService;
	private TradingAccountDTO taDto = new TradingAccountDTO();
	private TradingRecord tr = new TradingRecord();
	private String brokerID = SpringPropertyResourceReader.getProperty("ctp.brokerId");
	private String investorID = SpringPropertyResourceReader.getProperty("ctp.userid");
	/**
	 * 每天程序启动的时候执行
	 * 
	 * @author meixinbin 2016-6-21 上午8:47:07
	 */
	public void init(){
//		String brokerID = SpringPropertyResourceReader.getProperty("ctp.brokerId");
//		String investorID = SpringPropertyResourceReader.getProperty("ctp.userid");
//		String instrumentID = "rb1610";
//		List<InvestorPositionDTO> ls = this.investorPositionService.getList(brokerID, instrumentID, investorID);
//		if(ls!=null){
//			for(InvestorPositionDTO dto:ls){
//				if(dto.getPosiDirection()=='2'){
//					piv.setBK(piv.getYDBK()+dto.getPosition());
//				}else if(dto.getPosiDirection()=='3'){
//					piv.setYDSK(piv.getYDSK()+dto.getPosition());
//				}
//			}
//		}
		
		taDto = tradingAccountService.getTradingAccount(brokerID,investorID);
	}
	
	public PositionInfoVO getPiv(){
		String instrumentID = "rb1610";
		PositionInfoVO piv = new PositionInfoVO();
		List<InvestorPositionDTO> ls = this.investorPositionService.getList(brokerID, instrumentID, investorID);
		if(ls!=null){
			for(InvestorPositionDTO dto:ls){
				if(dto.getPosiDirection()=='2'){
					piv.setBK(piv.getYDBK()+dto.getPosition());
				}else if(dto.getPosiDirection()=='3'){
					piv.setYDSK(piv.getYDSK()+dto.getPosition());
				}
			}
		}
		return piv;
	}
	
	@Override
	public void trade(CThostFtdcDepthMarketDataField pDepthMarketData) {
		MarketData md = new MarketData();
		try {
			BeanUtils.copyProperties(md, pDepthMarketData);
			md.setId(new SimpleDateFormat("yyyyMMddHH:mm:ss:SSS").parse(md.getTradingDay()+md.getUpdateTime()+":"+md.getUpdateMillisec()).getTime());
		} catch (IllegalAccessException | InvocationTargetException | ParseException e) {
			e.printStackTrace();
		}
//		this.oHLCDataService.addAllOHLCData(md);
//		long[] time = TimeDateUtils.timePeriod(md.getId(), 24*60*60*1000);
		My018Strategy<OHLCData1Day> strategy18 = new My018Strategy<OHLCData1Day>();
		TimeSeries ts = new TimeSeries(Period.days(1));
		List<OHLCData1Day>  ls = this.oHLCDataService.getLatestList(OHLCData1Day.class, "rb1610", 10);
		for(OHLCData1Day o:ls){
			ts.addTick(new Tick(new DateTime(o.getId()), Decimal.valueOf(o.getOpenPrice()), Decimal.valueOf(o.getHighPrice()), Decimal.valueOf(o.getLowPrice()), Decimal.valueOf(o.getClosePrice()),Decimal.valueOf(o.getVolume())));
		}
		Strategy strategy = strategy18.buildStrategy(ts, "rb1610", OHLCData1Day.class);
		System.out.println("---------------------------------------------------");
        if(strategy.shouldEnter(ts.getEnd())){
        	System.out.println("shouldEnter");
        	TradeSignalRecord tsr = tradeSignalRecordService.getTradeSignalRecord(Strategy018.class.getSimpleName(), ts.getLastTick().getEndTime().getMillis());
        	if(tsr==null){
        		TradeSignalRecord tradeSignalRecord = new TradeSignalRecord();
        		tradeSignalRecord.setInstrumentID("rb1610");
        		tradeSignalRecord.setOhlcdTime( ts.getLastTick().getEndTime().getMillis());
        		tradeSignalRecord.setStrategyCode(Strategy018.class.getSimpleName());
        		this.tradeSignalRecordService.save(tradeSignalRecord);
        		PositionInfoVO piv = this.getPiv();
        		System.out.println(piv.getBK());
        		System.out.println(piv.getSK());
        		System.out.println(piv.getYDBK());
        		System.out.println(piv.getYDSK());
        		//买平开
            	if(piv.getSK()>0){
    				this.traderService.bp(pDepthMarketData.getInstrumentID(), pDepthMarketData.getExchangeID(), pDepthMarketData.getAskPrice1(), '2', 1);
    			}
            	if(piv.getBK()==0 && piv.getYDBK()==0){
    				this.traderService.bk(pDepthMarketData.getInstrumentID(), pDepthMarketData.getExchangeID(), pDepthMarketData.getAskPrice1(), '2', 1);
    			}
        	}
        }
        
        if(strategy.shouldExit(ts.getEnd())){
        	System.out.println("shouldExit");
        	TradeSignalRecord tsr = tradeSignalRecordService.getTradeSignalRecord(Strategy018.class.getSimpleName(), ts.getLastTick().getEndTime().getMillis());
        	if(tsr==null){
        		TradeSignalRecord tradeSignalRecord = new TradeSignalRecord();
        		tradeSignalRecord.setInstrumentID("rb1610");
        		tradeSignalRecord.setOhlcdTime( ts.getLastTick().getEndTime().getMillis());
        		tradeSignalRecord.setStrategyCode(Strategy018.class.getSimpleName());
        		this.tradeSignalRecordService.save(tradeSignalRecord);
        		PositionInfoVO piv = this.getPiv();
        		//卖平开
            	if(piv.getYDBK()>0 || piv.getBK()>0){
    				//平仓
    				this.traderService.sp(pDepthMarketData.getInstrumentID(), pDepthMarketData.getExchangeID(), pDepthMarketData.getBidPrice1(), '2', piv.getYDSK()+piv.getBK());
    			}
            	this.traderService.sk(pDepthMarketData.getInstrumentID(), pDepthMarketData.getExchangeID(), pDepthMarketData.getAskPrice1(), '2',1);
        	}
        }
	}
	public void setTraderService(TraderService traderService) {
		this.traderService = traderService;
	}
	public void setoHLCDataService(OHLCDataService oHLCDataService) {
		this.oHLCDataService = oHLCDataService;
	}
	public void setTradingAccountService(TradingAccountService tradingAccountService) {
		this.tradingAccountService = tradingAccountService;
	}
	public void setInvestorPositionService(InvestorPositionService investorPositionService) {
		this.investorPositionService = investorPositionService;
	}
	public void setTradeSignalRecordService(TradeSignalRecordService tradeSignalRecordService) {
		this.tradeSignalRecordService = tradeSignalRecordService;
	}
}
