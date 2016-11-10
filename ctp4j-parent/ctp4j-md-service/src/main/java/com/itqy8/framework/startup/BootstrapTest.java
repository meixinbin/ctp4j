package com.itqy8.framework.startup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ctp.data.service.CsvTicksLoader;
import com.ctp.data.service.OHLCDataService;
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
		CsvTicksLoader.main(null);
		OHLCDataService oHLCDataService = (OHLCDataService) SpringUtil.getBean("oHLCDataService");
		SequenceService sequenceService = (SequenceService) SpringUtil.getBean("sequenceService");
		System.out.println(sequenceService.generate("TTTT"));
		System.out.println(oHLCDataService.getYdOHLCData("rb1610"));
		System.out.println("----------------provider service started successfully------------");
	}

}
