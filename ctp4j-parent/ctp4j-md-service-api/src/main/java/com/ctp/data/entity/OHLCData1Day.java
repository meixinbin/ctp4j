package com.ctp.data.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class OHLCData1Day extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1956685768358894246L;

	@Override
	public long[] timePeriod(long now) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(now);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			calendar.set(Calendar.HOUR_OF_DAY, 21);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			
			long end = new SimpleDateFormat("yyyyMMdd HH:mm:ss:SSS").parse(new SimpleDateFormat("yyyyMMdd").format(new Date(now))+" 15:00:00:0").getTime();
			long[] time = {calendar.getTimeInMillis(),end};
			return time;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData30Minute.class;
	}
	
	public static void main(String[] args) {
		OHLCData1Day d = new OHLCData1Day();
		long[] aaa = d.timePeriod(System.currentTimeMillis());
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(1477530060000L)));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(new Date(aaa[1])));
	}
}
