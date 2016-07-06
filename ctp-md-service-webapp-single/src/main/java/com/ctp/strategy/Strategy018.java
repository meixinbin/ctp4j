package com.ctp.strategy;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.Period;

import com.ctp.data.entity.MarketData;
import com.ctp.data.entity.OHLCData15Minute;
import com.ctp.data.service.MarketDataService;
import com.ctp.data.service.OHLCDataService;
import com.ctp.md.vo.PositionInfoVO;
import com.ctp.ta4j.strategy.extra.My018Strategy;
import com.ctp.trader.dto.InvestorPositionDTO;
import com.ctp.trader.dto.TradingAccountDTO;
import com.ctp.trader.service.InvestorPositionService;
import com.ctp.trader.service.TraderService;
import com.ctp.trader.service.TradingAccountService;
import com.itqy8.ctp.CThostFtdcDepthMarketDataField;
import com.itqy8.framework.util.SpringPropertyResourceReader;

import eu.verdelhan.ta4j.Strategy;
import eu.verdelhan.ta4j.TimeSeries;
import eu.verdelhan.ta4j.TradingRecord;

public class Strategy018 implements MarketTradeTrategy{

	private MarketDataService marketDataService;
	private OHLCDataService oHLCDataService;
	private TradingAccountService tradingAccountService;
	private TraderService traderService;
	private InvestorPositionService investorPositionService;
	private TradingAccountDTO taDto = new TradingAccountDTO();
	private PositionInfoVO piv = new PositionInfoVO();
	private TradingRecord tr = new TradingRecord();
	
	/**
	 * 每天程序启动的时候执行
	 * 
	 * @author meixinbin 2016-6-21 上午8:47:07
	 */
	public void init(){
		String brokerID = SpringPropertyResourceReader.getProperty("ctp.brokerId");
		String investorID = SpringPropertyResourceReader.getProperty("ctp.userid");
		String instrumentID = "rb1610";
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
		
		taDto = tradingAccountService.getTradingAccount(brokerID,investorID);
	}
	@Override
	public void trade(CThostFtdcDepthMarketDataField pDepthMarketData) {
		long start = System.currentTimeMillis();
		MarketData md = new MarketData();
		try {
			BeanUtils.copyProperties(md, pDepthMarketData);
			md.setId(new SimpleDateFormat("yyyyMMddHH:mm:ss:SSS").parse(md.getTradingDay()+md.getUpdateTime()+":"+md.getUpdateMillisec()).getTime());
		} catch (IllegalAccessException | InvocationTargetException | ParseException e) {
			e.printStackTrace();
		}
//		this.oHLCDataService.addAllOHLCData(md);
//		long[] time = TimeDateUtils.timePeriod(md.getId(), 24*60*60*1000);
		My018Strategy<OHLCData15Minute> strategy18 = new My018Strategy<OHLCData15Minute>();
		TimeSeries ts = new TimeSeries(Period.minutes(15));
		Strategy strategy = strategy18.buildStrategy(ts, "rb1610", OHLCData15Minute.class);
        if(strategy.shouldEnter(ts.getEnd())){
        	//买平开
        	if(this.piv.getSK()>0){
				this.traderService.bp(pDepthMarketData.getInstrumentID(), pDepthMarketData.getExchangeID(), pDepthMarketData.getAskPrice1(), '1', 1);
				this.piv.setSK(0);
			}
        	if(piv.getBK()==0 && piv.getYDBK()==0){
				this.traderService.bk(pDepthMarketData.getInstrumentID(), pDepthMarketData.getExchangeID(), pDepthMarketData.getAskPrice1(), '1', 1);
				this.piv.setBK(1);
			}
        }
        
        if(strategy.shouldExit(ts.getEnd())){
        	//卖平开
        	if(piv.getYDBK()>0 || piv.getBK()>0){
				//平仓
				this.traderService.sp(pDepthMarketData.getInstrumentID(), pDepthMarketData.getExchangeID(), pDepthMarketData.getBidPrice1(), '1', piv.getYDSK()+piv.getBK());
				this.piv.setBK(0);
				this.piv.setYDSK(0);
				System.out.println("发生一次交易");
			}
        	this.traderService.sk(pDepthMarketData.getInstrumentID(), pDepthMarketData.getExchangeID(), pDepthMarketData.getAskPrice1(), '1',1);
			this.piv.setSK(1);
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
	public void setMarketDataService(MarketDataService marketDataService) {
		this.marketDataService = marketDataService;
	}
	public void setInvestorPositionService(InvestorPositionService investorPositionService) {
		this.investorPositionService = investorPositionService;
	}
}
