package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData1Day extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1956685768358894246L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 86400000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData1Hour.class;
	}


}
