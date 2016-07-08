package com.itqy8.framework.startup;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.google.common.util.concurrent.AbstractIdleService;

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
		System.out.println("----------------provider service started successfully------------");
	}

}
