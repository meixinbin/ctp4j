package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData10Day extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5523974308116252789L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 10*24*60*60*1000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData5Day.class;
	}


}
