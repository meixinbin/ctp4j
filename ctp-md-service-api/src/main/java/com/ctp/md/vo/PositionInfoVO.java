package com.ctp.md.vo;

import java.io.Serializable;

public class PositionInfoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4552262512811172437L;

	/**
	 * 昨天买开
	 */
	private int YDBK;
	
	/**
	 * 昨天卖开
	 */
	private int YDSK;
	
	/**
	 * 今天买开
	 */
	private int BK;
	
	/**
	 * 今天卖开
	 */
	private int SK;

	public int getYDBK() {
		return YDBK;
	}

	public void setYDBK(int yDBK) {
		YDBK = yDBK;
	}

	public int getYDSK() {
		return YDSK;
	}

	public void setYDSK(int yDSK) {
		YDSK = yDSK;
	}

	public int getBK() {
		return BK;
	}

	public void setBK(int bK) {
		BK = bK;
	}

	public int getSK() {
		return SK;
	}

	public void setSK(int sK) {
		SK = sK;
	}
}


