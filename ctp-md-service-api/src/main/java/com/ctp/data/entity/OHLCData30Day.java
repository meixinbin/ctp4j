package com.ctp.data.entity;

import com.ctp.util.TimeDateUtils;

public class OHLCData30Day extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6222498002411660469L;

	@Override
	public long[] timePeriod(long now) {
		return TimeDateUtils.timePeriod(now, 30*24*60*60*1000);
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData1Hour.class;
	}


}
