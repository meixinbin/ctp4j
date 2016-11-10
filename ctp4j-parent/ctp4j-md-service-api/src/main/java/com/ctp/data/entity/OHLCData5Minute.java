package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData5Minute extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7946357888271004923L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 5*60*1000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData1Minute.class;
	}


	
}
