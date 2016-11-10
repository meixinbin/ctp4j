package com.itqy8.framework.startup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ctp.trader.dto.OrderDTO;
import com.ctp.trader.service.InstrumentService;
import com.ctp.trader.service.TraderService;
import com.google.common.util.concurrent.AbstractIdleService;
import com.itqy8.framework.util.SpringUtil;
import com.itqy8.sequence.service.SequenceService;

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
		SequenceService sequenceService = (SequenceService) SpringUtil.getBean("sequenceService");
		InstrumentService instrumentService = (InstrumentService) SpringUtil.getBean("instrumentService");
		TraderService traderService = (TraderService) SpringUtil.getBean("traderService");
		OrderDTO order = new OrderDTO();
		traderService.orderInsert(order);
		for(String c:instrumentService.getInstrumentIds().getResult()){
			System.out.println(c);
		}
		System.out.println(instrumentService.getInstrumentIds().getResult().size());
//		System.out.println(sequenceService.generate("ttt").getResult());
		System.out.println("----------------provider service started successfully------------");
		
		
	}

}
