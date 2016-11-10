package com.ctp.util;

import java.util.Calendar;


public class TimeDateUtils {
	
	/**
	 * 根据指定的时间区间获取开始和结束的毫秒数
	 * 
	 * @param timePeriodMillis
	 * @return
	 * @author meixinbin 2016-5-30 下午4:32:23
	 */
	public static long[] timePeriod(long now,int timePeriodMillis){
		long passMillis = now%timePeriodMillis;
		long start = now-passMillis;
		long end = start+timePeriodMillis;
		long[] res = new long[2];
		res[0]=start;
		res[1]=end;
		return res;
	}
	
	
	/**
	 * 季度开始时间
	 * @param time
	 * @return
	 * @author meixinbin 2016-6-6 下午5:57:47
	 */
	public static long getCurrentQuarterStartTime(long time) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 4);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			return c.getTimeInMillis();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	/**
     * 当前季度的结束时间，即2012-03-31 23:59:59
     * 
     * @return
     */
    public  static long getCurrentQuarterEndTime(long time) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        int currentMonth = c.get(Calendar.MONTH) + 1;
        try {
            if (currentMonth >= 1 && currentMonth <= 3) {
                c.set(Calendar.MONTH, 2);
                c.set(Calendar.DATE, 31);
            } else if (currentMonth >= 4 && currentMonth <= 6) {
                c.set(Calendar.MONTH, 5);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 7 && currentMonth <= 9) {
                c.set(Calendar.MONTH, 8);
                c.set(Calendar.DATE, 30);
            } else if (currentMonth >= 10 && currentMonth <= 12) {
                c.set(Calendar.MONTH, 11);
                c.set(Calendar.DATE, 31);
            }
            c.set(Calendar.HOUR_OF_DAY, 0);
			c.set(Calendar.MINUTE, 0);
			c.set(Calendar.SECOND, 0);
			c.set(Calendar.MILLISECOND, 0);
			return c.getTimeInMillis();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
