package com.ctp.data.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OHLCData1Month extends OHLCDataItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7302096008483781795L;


	@Override
	public long[] timePeriod(long now) {
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(new Date(System.currentTimeMillis()));
		 Calendar calendar2 = (Calendar) calendar.clone();
		 calendar2.add(Calendar.MONTH, 1);  
		 calendar2.set(Calendar.DAY_OF_MONTH, 1);
		 calendar2.set(Calendar.HOUR_OF_DAY,0);
		 calendar2.set(Calendar.MINUTE, 0);
		 calendar2.set(Calendar.SECOND, 0);
		 calendar2.set(Calendar.MILLISECOND, 0);
		 
		 calendar.set(Calendar.DAY_OF_MONTH, 1);
		 calendar.set(Calendar.HOUR_OF_DAY,0);
		 calendar.set(Calendar.MINUTE, 0);
		 calendar.set(Calendar.SECOND, 0);
		 calendar.set(Calendar.MILLISECOND, 0);
		 long[] tp = new long[2];
		 tp[0]=calendar.getTimeInMillis();
		 tp[1]=calendar2.getTimeInMillis();
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
	     calendar2.add(Calendar.MONTH, 1);
	     calendar2.set(Calendar.DAY_OF_MONTH, 1);
	     calendar2.set(Calendar.HOUR_OF_DAY,0);
	     calendar2.set(Calendar.MINUTE, 0);
	     calendar2.set(Calendar.SECOND, 0);
	     calendar2.set(Calendar.MILLISECOND, 0);
	     
	     calendar.set(Calendar.DAY_OF_MONTH, 1);
	     calendar.set(Calendar.HOUR_OF_DAY,0);
	     calendar.set(Calendar.MINUTE, 0);
	     calendar.set(Calendar.SECOND, 0);
	     calendar.set(Calendar.MILLISECOND, 0);
	     System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(calendar.getTime()));
	     System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(calendar2.getTime().getTime()));
	}
}
