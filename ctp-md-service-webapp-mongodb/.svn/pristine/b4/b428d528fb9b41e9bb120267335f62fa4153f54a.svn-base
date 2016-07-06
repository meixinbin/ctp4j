package com.itqy8.framework.startup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ctp.service.MyMdSpi;
import com.ctp.trader.service.InstrumentService;
import com.google.common.util.concurrent.AbstractIdleService;
import com.itqy8.ctp.CThostFtdcMdApi;
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
		System.loadLibrary("mdctp");
		String frontAddr = "tcp://180.168.146.187:10010";
//		String frontAddr = "tcp://180.168.146.187:10031";
		CThostFtdcMdApi mdApi = CThostFtdcMdApi.CreateFtdcMdApi();
		MyMdSpi pSpi = new MyMdSpi(mdApi);
		pSpi.setInstrumentService((InstrumentService) SpringUtil.getBean("instrumentService"));
		mdApi.RegisterSpi(pSpi);
		mdApi.RegisterFront(frontAddr);
		mdApi.Init();
		mdApi.Join();
		System.out.println("----------------provider service started successfully------------");
	}

}
