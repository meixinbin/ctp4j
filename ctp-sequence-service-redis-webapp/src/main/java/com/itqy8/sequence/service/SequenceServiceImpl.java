package com.itqy8.sequence.service;


import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.itqy8.framework.response.Response;
import com.itqy8.framework.util.SpringUtil;
import com.itqy8.sequence.service.SequenceService;

public class SequenceServiceImpl implements SequenceService{

	private JedisConnectionFactory jedisConnectionFactory;
	
	@Override
	public Response<Long> generate(String key) {
		Response<Long> response = new Response<Long>();
		JedisConnection jedisConnection = jedisConnectionFactory.getConnection();
		long id = jedisConnection.incr(key.getBytes());
		jedisConnection.close();
		response.setResult(id);
		return response;
		
	}

	@Override
	public Response<Long> generate(String key, int increment) {
		Response<Long> response = new Response<Long>();
		JedisConnectionFactory jedisConnectionFactory = (JedisConnectionFactory) SpringUtil.getBean("jedisConnectionFactory");
		JedisConnection jedisConnection = jedisConnectionFactory.getConnection();
		long id = jedisConnection.incrBy(key.getBytes(), increment);
		jedisConnection.close();
		response.setResult(id);
		return response;
	}

	public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		this.jedisConnectionFactory = jedisConnectionFactory;
	}

}
