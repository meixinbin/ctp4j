package com.itqy8.framework.startup;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ta4jexamples.analysis.TotalProfitAmount;

import com.ctp.data.entity.OHLCData1Day;
import com.ctp.data.entity.OHLCData1Minute;
import com.ctp.data.entity.OHLCData30Minute;
import com.ctp.data.service.OHLCDataService;
import com.ctp.ta4j.strategy.extra.My018Strategy;
import com.ctp.trader.dto.OrderDTO;
import com.ctp.trader.service.TraderService;
import com.google.common.util.concurrent.AbstractIdleService;
import com.itqy8.framework.util.SpringUtil;

import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.Strategy;
import eu.verdelhan.ta4j.Tick;
import eu.verdelhan.ta4j.TimeSeries;
import eu.verdelhan.ta4j.Trade;
import eu.verdelhan.ta4j.TradingRecord;
import eu.verdelhan.ta4j.analysis.criteria.AverageProfitableTradesCriterion;
import eu.verdelhan.ta4j.analysis.criteria.BuyAndHoldCriterion;
import eu.verdelhan.ta4j.analysis.criteria.LinearTransactionCostCriterion;
import eu.verdelhan.ta4j.analysis.criteria.MaximumDrawdownCriterion;
import eu.verdelhan.ta4j.analysis.criteria.RewardRiskRatioCriterion;
import eu.verdelhan.ta4j.analysis.criteria.TotalProfitCriterion;
import eu.verdelhan.ta4j.analysis.criteria.VersusBuyAndHoldCriterion;

public class BootstrapTest extends AbstractIdleService {

	
	private ClassPathXmlApplicationContext context;
	public static void main(String[] args) {
		try {
			InputStream input = BootstrapTest.class.getClassLoader().getResourceAsStream("config/log4j.properties");
			Properties prop = new Properties();
			prop.load(input);
			PropertyConfigurator.configure(prop);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: Unable to load config/log4j.properties");
		}
		BootstrapTest bootstrap = new BootstrapTest();
		bootstrap.startAsync();
		try {
			Object lock = new Object();
			synchronized (lock) {
				while (true) {
					lock.wait();
				}
			}
		} catch (InterruptedException ex) {
			System.err.println("ignoreinterruption");
		}
	}

	@Override
	protected void shutDown() throws Exception {
		context.stop();
		System.out.println("-------------service stopped successfully-------------");
	}
	@Override
	protected void startUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:config/spring/*.xml");
		context.start();
		//
		context.registerShutdownHook();
		
		TraderService tservice =	(TraderService) SpringUtil.getBean("traderService");
		OrderDTO pInputOrder = new OrderDTO();
		pInputOrder.setBrokerID("9999");
		pInputOrder.setInvestorID("057794");
		pInputOrder.setInstrumentID("rb1610");
		pInputOrder.setVolumeCondition('1');//成交量类型：任何数量
		pInputOrder.setMinVolume(1);/// 最小成交量：1
		pInputOrder.setForceCloseReason('0');/// 强平原因：非强平
		pInputOrder.setIsAutoSuspend(0);/// 自动挂起标志：否
		pInputOrder.setUserForceClose(0);///用户强评标志：否
		pInputOrder.setDirection('1');
		pInputOrder.setOrderPriceType('2');
		pInputOrder.setTimeCondition('3');
		pInputOrder.setLimitPrice(2388);
//		pInputOrder.setStopPrice(2440);
		pInputOrder.setCombOffsetFlag("3");
		pInputOrder.setCombHedgeFlag("1");
		pInputOrder.setVolumeTotalOriginal(1);
		pInputOrder.setTimeCondition('1');
		pInputOrder.setContingentCondition('1');
//		tservice.orderInsert(pInputOrder);
//		tservice.sp("rb1610", "", 2391, '2',3);
		TimeSeries ts=new TimeSeries("rb1610",Period.days(1));
		//
		OHLCDataService oHLCDataService = (OHLCDataService) SpringUtil.getBean("oHLCDataService");
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(System.currentTimeMillis());
		cal.add(Calendar.DAY_OF_MONTH, -50);
		List<OHLCData1Day> ls = oHLCDataService.getLatestList(OHLCData1Day.class, "rb1610", 300);
		for(OHLCData1Day o:ls){
			ts.addTick(new Tick(new DateTime(o.getId()), Decimal.valueOf(o.getOpenPrice()), Decimal.valueOf(o.getHighPrice()), Decimal.valueOf(o.getLowPrice()), Decimal.valueOf(o.getClosePrice()),Decimal.valueOf(o.getVolume())));
		}
//		Strategy strategy = KLineShapeStrategy.buildStrategy(ts);
		My018Strategy<OHLCData1Day> strategy18 = new My018Strategy<OHLCData1Day>();
		Strategy strategy = strategy18.buildStrategy(ts, "rb1610", OHLCData1Day.class);
		// Running the strategy
        TradingRecord tradingRecord = ts.run(strategy);
        System.out.println("Number of trades for the strategy: " + tradingRecord.getTradeCount());
        List<Trade> tradels = tradingRecord.getTrades();
        for(Trade t:tradels){
        	System.out.println("买入信号："+new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(ts.getTick(t.getEntry().getIndex()).getEndTime().getMillis())));
        	System.out.println("卖出信号："+new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date(ts.getTick(t.getExit().getIndex()).getEndTime().getMillis())));
        }
     // Total profit
        TotalProfitCriterion totalProfit = new TotalProfitCriterion();
        TotalProfitAmount totalProfitAmount = new TotalProfitAmount();
        System.out.println("Total profit: " + totalProfit.calculate(ts, tradingRecord));
        System.out.println("Total TotalProfitAmount: " + totalProfitAmount.calculate(ts, tradingRecord));
     // Profitable trades ratio
        System.out.println("Profitable trades ratio: " + new AverageProfitableTradesCriterion().calculate(ts, tradingRecord));
     // Maximum drawdown
        System.out.println("Maximum drawdown: " + new MaximumDrawdownCriterion().calculate(ts, tradingRecord));
     // 风险报酬率
        System.out.println("Reward-risk ratio: " + new RewardRiskRatioCriterion().calculate(ts, tradingRecord));
        // Total transaction cost
        System.out.println("Total transaction cost (from $1000): " + new LinearTransactionCostCriterion(2300, 0.0009).calculate(ts, tradingRecord));
        // Buy-and-hold
        System.out.println("Buy-and-hold: " + new BuyAndHoldCriterion().calculate(ts, tradingRecord));
        // Total profit vs buy-and-hold
        System.out.println("Custom strategy profit vs buy-and-hold strategy profit: " + new VersusBuyAndHoldCriterion(totalProfit).calculate(ts, tradingRecord));
//        BuyAndSellSignalsToChart.main(null);
		System.out.println("----------------provider service started successfully------------");
		
	}

}
