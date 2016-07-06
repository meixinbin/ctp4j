package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData5Day extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5590125175458528816L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 5*24*60*60*1000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData1Day.class;
	}


}
