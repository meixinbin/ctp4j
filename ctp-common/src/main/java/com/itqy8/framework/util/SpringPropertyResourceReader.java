package com.itqy8.framework.util;

/**
 * 读取properties文件中的内容
 * @author meixinbin
 * 2013-6-9下午09:43:42
 */
import java.lang.reflect.Method;  
import java.util.Properties;  
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;  
import org.springframework.beans.factory.config.PropertyResourceConfigurer;  
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.AbstractApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
import org.springframework.core.io.support.PropertiesLoaderSupport;  

public class SpringPropertyResourceReader {  
    private static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("config/spring/propertyFileConfigurer.xml");  
    private static AbstractApplicationContext abstractContext = (AbstractApplicationContext) applicationContext;  
    private static Properties properties=new Properties();  
    static{  
        try{  
            // get the names of BeanFactoryPostProcessor  
            String[] postProcessorNames = abstractContext.getBeanNamesForType(BeanFactoryPostProcessor.class,true,true);  
              
            for (String ppName : postProcessorNames) {  
                // get the specified BeanFactoryPostProcessor  
                BeanFactoryPostProcessor beanProcessor=  
                abstractContext.getBean(ppName, BeanFactoryPostProcessor.class);  
                // check whether the beanFactoryPostProcessor is   
                // instance of the PropertyResourceConfigurer  
                // if it is yes then do the process otherwise continue  
                if(beanProcessor instanceof PropertyResourceConfigurer){  
                    PropertyResourceConfigurer propertyResourceConfigurer= (PropertyResourceConfigurer) beanProcessor;  
                      
                    // get the method mergeProperties   
                    // in class PropertiesLoaderSupport  
                    Method mergeProperties=PropertiesLoaderSupport.class.getDeclaredMethod("mergeProperties");  
                    // get the props  
                    mergeProperties.setAccessible(true);  
                    Properties props=(Properties) mergeProperties.  
                    invoke(propertyResourceConfigurer);  
                      
                    // get the method convertProperties   
                    // in class PropertyResourceConfigurer  
                    Method convertProperties=PropertyResourceConfigurer.class.getDeclaredMethod("convertProperties", Properties.class);  
                    // convert properties  
                    convertProperties.setAccessible(true);  
                    convertProperties.invoke(propertyResourceConfigurer, props);  
                    properties.putAll(props);  
                }  
            }  
        }catch(Exception e){  
            throw new RuntimeException(e);  
        }  
    }  
      
    public static String getProperty(String propertyName){  
        return properties.getProperty(propertyName);  
    }  
    public static void main(String[] args) throws Exception {  
        System.out.println(SpringPropertyResourceReader.getProperty("server.name"));  
    }  
}  

