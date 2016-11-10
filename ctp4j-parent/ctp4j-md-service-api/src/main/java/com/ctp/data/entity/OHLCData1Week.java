package com.ctp.data.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OHLCData1Week extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6711008691029622225L;

	@Override
	public long[] timePeriod(long now) {
		Calendar calendar = Calendar.getInstance();
		 calendar.setTime(new Date(System.currentTimeMillis()));
		 Calendar calendar2 = (Calendar) calendar.clone();
		 int weekday = calendar2.get(Calendar.DAY_OF_WEEK);
		 calendar2.add(Calendar.DATE, 8 - weekday);
		 calendar2.set(Calendar.HOUR_OF_DAY,23);
		 calendar2.set(Calendar.MINUTE, 59);
		 calendar2.set(Calendar.SECOND, 59);
		 calendar2.set(Calendar.MILLISECOND, 999);
		 
		 calendar.set(Calendar.DAY_OF_WEEK,  Calendar.MONDAY);
		 calendar.set(Calendar.HOUR_OF_DAY,0);
		 calendar.set(Calendar.MINUTE, 0);
		 calendar.set(Calendar.SECOND, 0);
		 calendar.set(Calendar.MILLISECOND, 0);
		 long[] tp = new long[2];
		 tp[0]=calendar.getTimeInMillis();
		 tp[1]=calendar2.getTimeInMillis()-1;
		return tp;
	}

	@Override
	public <T> Class<? extends OHLCDataItem> getSubClass() {
		return OHLCData1Day.class;
	}
	
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		 calendar.setTime(new Date(System.currentTimeMillis()));
		 Calendar calendar2 = (Calendar) calendar.clone();
		 int weekday = calendar2.get(Calendar.DAY_OF_WEEK);
		 calendar2.add(Calendar.DATE, 8 - weekday);
		 calendar2.set(Calendar.HOUR_OF_DAY,23);
		 calendar2.set(Calendar.MINUTE, 59);
		 calendar2.set(Calendar.SECOND, 59);
		 calendar2.set(Calendar.MILLISECOND, 999);
		 
		 calendar.set(Calendar.DAY_OF_WEEK,  Calendar.MONDAY);
		 calendar.set(Calendar.HOUR_OF_DAY,0);
		 calendar.set(Calendar.MINUTE, 0);
		 calendar.set(Calendar.SECOND, 0);
		 calendar.set(Calendar.MILLISECOND, 0);
	     System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(calendar.getTime()));
	     System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(calendar2.getTime().getTime()));
	}

}
