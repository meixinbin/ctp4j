package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData1Minute extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7060694407744274705L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 60000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData30MS.class;
	}


	
}
