package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData30MS extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6635231281164802517L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 30000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return null;
	}

}
