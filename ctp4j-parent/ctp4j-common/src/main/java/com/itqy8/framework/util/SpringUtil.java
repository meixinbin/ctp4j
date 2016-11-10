/* ============================================================
 * http://www.itqy8.com
 * ============================================================
 * Copyright 2012 www.itqy8.com , meixinbin.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============================================================ */
package com.itqy8.framework.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author <a href="http://www.itqy8.com">meixinbin</a> 2014-10-9 下午11:17:38
 * @since 2.0
 * @version $Id: SpringUtil.java 2244 2014-10-25 06:17:34Z meixinbin $
 */
@Component
public class SpringUtil implements ApplicationContextAware{
	private static ApplicationContext applicationContext;
	 public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	  SpringUtil.applicationContext = applicationContext;
	 }
	 public static ApplicationContext getApplicationContext() {
	  return applicationContext;
	 }
	 /**
	  * 根据Bean名称获取实例
	  * @param name
	  * Bean注册名称
	  * @return bean实例
	  * @throws BeansException
	  */
	 public static Object getBean(String name) throws BeansException {
	  return applicationContext.getBean(name);
	 }
}
