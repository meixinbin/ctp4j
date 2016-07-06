package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData20Day extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2632421393190527259L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 20*24*60*60*1000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData10Day.class;
	}


}
