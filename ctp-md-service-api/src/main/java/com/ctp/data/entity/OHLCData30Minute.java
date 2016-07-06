package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData30Minute extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4556374932412311558L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 30*60*1000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData15Minute.class;
	}


	
}
