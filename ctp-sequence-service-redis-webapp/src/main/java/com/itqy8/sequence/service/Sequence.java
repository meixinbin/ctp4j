package com.itqy8.sequence.service;

import java.io.Serializable;

/**
 * 序列号实体类
 * @author meixinbin
 *
 */
public class Sequence implements Serializable{

	private static final long serialVersionUID = -3455576601526465095L;

	public static final String NAME = "name";
	
	/**序列名称*/
	private String name;
	
	/**当前值*/
	private long current_value;
	
	/**步值*/
	private int increment = 1;

	public String getName() {
		return name;
	}

	public long getCurrent_value() {
		return current_value;
	}

	public int getIncrement() {
		return increment;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrent_value(long current_value) {
		this.current_value = current_value;
	}

	public void setIncrement(int increment) {
		this.increment = increment;
	}
}
