package com.itqy8.framework.startup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ctp.service.TraderApiWrap;
import com.ctp.service.TraderSpi;
import com.ctp.trader.service.InstrumentService;
import com.google.common.util.concurrent.AbstractIdleService;
import com.itqy8.ctp.CThostFtdcTraderApi;
import com.itqy8.ctp.THOST_TE_RESUME_TYPE;
import com.itqy8.framework.util.SpringUtil;

public class Bootstrap extends AbstractIdleService {

	
	private ClassPathXmlApplicationContext context;
	public static void main(String[] args) {
		try {
			InputStream input = Bootstrap.class.getClassLoader().getResourceAsStream("config/log4j.properties");
			Properties prop = new Properties();
			prop.load(input);
			PropertyConfigurator.configure(prop);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: Unable to load config/log4j.properties");
		}
		Bootstrap bootstrap = new Bootstrap();
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
		System.loadLibrary("traderctp");
//		String frontAddr = "tcp://ctp24-front2.financial-trading-platform.com:41205";
		String frontAddr = "tcp://180.168.146.187:10000";
//		String frontAddr = "tcp://180.168.146.187:10030";
		CThostFtdcTraderApi traderApi = CThostFtdcTraderApi.CreateFtdcTraderApi("/opt");
		traderApi.SubscribePrivateTopic(THOST_TE_RESUME_TYPE.THOST_TERT_QUICK);
		traderApi.SubscribePublicTopic(THOST_TE_RESUME_TYPE.THOST_TERT_RESUME);
		TraderSpi pSpi = new TraderSpi(traderApi);
//		pSpi.setInstrumentService((InstrumentService) SpringUtil.getBean("instrumentService"));
		traderApi.RegisterSpi(pSpi);
		traderApi.RegisterFront(frontAddr);
		traderApi.Init();
		TraderApiWrap.setTraderApi(traderApi);
		//初始化数据
		pSpi.init();
		traderApi.Join();
		System.out.println("----------------provider service started successfully------------");
		
		
	}

}
