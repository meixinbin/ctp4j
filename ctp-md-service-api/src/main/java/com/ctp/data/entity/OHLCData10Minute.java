package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData10Minute extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6939599474050315478L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 600000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData5Minute.class;
	}


	
}
