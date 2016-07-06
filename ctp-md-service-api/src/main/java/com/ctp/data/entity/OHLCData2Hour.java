package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData2Hour extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4363248624689022682L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 7200000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData1Hour.class;
	}


}
