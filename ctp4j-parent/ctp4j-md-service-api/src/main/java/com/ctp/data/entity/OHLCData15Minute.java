package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData15Minute extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3991443134628432421L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 15*60*1000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData5Minute.class;
	}


	
}
