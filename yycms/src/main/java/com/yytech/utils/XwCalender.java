package com.yytech.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
* @description :一些公用的、处理日期与时间戳的工具函数
* @author：wangxianwei
* @date : 20171003
* */
public class XwCalender {
    public static long nowShortTs()
    {
        Calendar cal = Calendar.getInstance();
        long todayTs = cal.getTimeInMillis()/1000;
        return todayTs;
    }

    public static long nowLongTs()
    {
        Calendar cal = Calendar.getInstance();
        long todayTs = cal.getTimeInMillis();
        return todayTs;
    }
    // 获取今天日历的结束日期,转化为long型
    public static long todayEndShortTs() {
        Calendar todayCal = Calendar.getInstance();
        todayCal.set(Calendar.HOUR_OF_DAY, 23);
        todayCal.set(Calendar.MINUTE, 59);
        todayCal.set(Calendar.SECOND, 59);
        todayCal.set(Calendar.MILLISECOND, 999);
        long todayTs = todayCal.getTimeInMillis() / 1000;
        return todayTs;
    }
    public static String calendarToTodayStr(Calendar cal)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String calStr = sf.format(cal.getTime());
        return calStr;
    }

    public static String calendarToThisMonthStr(Calendar cal)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
        String calStr = sf.format(cal.getTime());
        return calStr;

    }

    public static long dateStrToLongTs2(String str)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        Date dt = null;
        long ts = 0;
        try {
            dt = sf.parse(str);
            ts = dt.getTime();
        } catch (ParseException e) {
            ;
        }
        return ts;
    }
    public static Calendar dateStrToCalendar(String str)
    {
        Calendar cal = Calendar.getInstance();
        boolean bOk = false;
        Timestamp ts = null;
        try{
            ts = Timestamp.valueOf(str+" 00:00:00");
            bOk = true;
        } catch ( Exception e) {
            ;
        }finally{
            ;
        }
        if(bOk == true){
            cal.setTimeInMillis(ts.getTime());
            return cal;
        }
        return null;
    }

    public static Calendar strToCalendar(String str)
    {
        Calendar cal = Calendar.getInstance();
        boolean bOk = false;
        Timestamp ts = null;
        try{
            ts = Timestamp.valueOf(str);
            bOk = true;
        } catch ( Exception e) {
            ;
        }finally{
            ;
        }
        if(bOk == true){
            cal.setTimeInMillis(ts.getTime());
            return cal;
        }
        return null;
    }

    public static Calendar timestampToCalendar(Timestamp ts)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(ts.getTime());
        return cal;
    }

    public static String  timestampToStr(Timestamp ts)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(ts);
    }

    public static String  calendarToStr(Calendar cal)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String calStr = sf.format(cal.getTime());
        return calStr;
    }

    public static String calendarToStr2(Calendar cal)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
        String calStr = sf.format(cal.getTime());
        return calStr;
    }

    public static String  calendarToDateStr(Calendar cal)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String calStr = sf.format(cal.getTime());
        return calStr;
    }

    public static String  calendarToDateStr1(Calendar cal)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        String calStr = sf.format(cal.getTime());
        return calStr;
    }

    public static Timestamp calendarToTimestamp(Calendar cal)
    {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String calStr = sf.format(cal.getTime());
        return Timestamp.valueOf(calStr);
    }

    public static Timestamp longToTimestamp(long ts)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(ts);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String calStr = sf.format(cal.getTime());
        return Timestamp.valueOf(calStr);
    }

    public static String longToStr(long ts) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(ts);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(cal.getTime());
    }

    public static Calendar longToCalendar(long ts)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(ts);
        return cal;
    }
}
