package com.ctp.trader.dto;

import java.io.Serializable;

public class TraderData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2085183701832481500L;

	/**
	 * 最近买开时间
	 */
	private long latestBK;
	
	/**
	 * 最近一次卖开时间
	 */
	private long latestSK;
	
	/**
	 * 最近买平时间
	 */
	private long latestBP;
	
	/**
	 * 最近一次卖平时间
	 */
	private long latestSP;

	public long getLatestBK() {
		return latestBK;
	}

	public void setLatestBK(long latestBK) {
		this.latestBK = latestBK;
	}

	public long getLatestSK() {
		return latestSK;
	}

	public void setLatestSK(long latestSK) {
		this.latestSK = latestSK;
	}

	public long getLatestBP() {
		return latestBP;
	}

	public void setLatestBP(long latestBP) {
		this.latestBP = latestBP;
	}

	public long getLatestSP() {
		return latestSP;
	}

	public void setLatestSP(long latestSP) {
		this.latestSP = latestSP;
	}
	

}