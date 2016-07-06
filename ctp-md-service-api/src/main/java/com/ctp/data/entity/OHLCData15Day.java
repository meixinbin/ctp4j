package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData15Day extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2857703952128423223L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 15*24*60*60*1000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData5Day.class;
	}


}
