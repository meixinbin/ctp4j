package com.itqy8.sequence.service;

import com.itqy8.framework.response.Response;


public interface SequenceService {

	/**
	 * 生成序列号
	 */
	public Response<Long> generate(String key);
	
	/**
	 * 生成序列号
	 * @param key
	 * @param increment
	 * @return
	 */
	public Response<Long> generate(String key,int increment);
	
	
	
}
