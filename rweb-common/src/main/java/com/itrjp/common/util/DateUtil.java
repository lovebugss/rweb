package com.itrjp.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期处理工具类
 *
 * @author renjp
 */
public class DateUtil {
    public static final String FORMAT_yyyy_MM = "yyyy-MM";

    public static final String FORMAT_yyyy_MM_dd = "yyyy-MM-dd";

    public static final String FORMAT_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_yyyyMMddHHmmssssss = "yyyyMMddHHmmssSSS";

    public static final int TODAY = 0;

    public static final int YESTERDAY = 1;

    public static final int LAST7DAYS = 2;

    public static final int THISMONTH = 3;

    public static final int LASTMONTH = 4;

    public static final int ALLTIME = 5;

    private static final TimeZone timeZone = TimeZone.getTimeZone("GMT+08:00");

    /**
     * <pre>
     * 指定当天日期的格式
     * <b>注意</b>
     * SimpleDateFormat("yyyy-MM-dd")的参数间隔符号可以随意设置的，
     * 如：
     * yyyy年MM月dd日 返回格式：2009年06月09日
     * yyyy-MM-dd 返回格式： 2009-06-09
     * yyyy-MM-dd HH:mm:ss
     *
     * <pre>
     * @param Format 指定的格式
     * @return
     */
    public static final String getCurrentDate(String Format) {
        return new SimpleDateFormat(Format).format(System.currentTimeMillis());
    }

    /**
     * 得到系统当前的日期
     *
     * @return
     */
    public static final int getCurrentDay() {
        return new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到当月的第一天
     *
     * @return YYYY-MM-DD
     */
    public static final String getCurrentFirstMonthDay1() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        int day = cal.getMinimum(Calendar.DAY_OF_MONTH);
        int month = getCurrentMonth();
        int year = getCurrentYear();
        return getDayDef2(year, month, day, "-");
    }

    /**
     * 得到当月的第一天
     *
     * @return YYYYMMDD
     */
    public static final int getCurrentFirstMonthDay2() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        int day = cal.getMinimum(Calendar.DAY_OF_MONTH);
        int month = getCurrentMonth();
        int year = getCurrentYear();
        return getDayDef1(year, month, day);
    }

    /**
     * 得到本周的第一天,星期一
     *
     * @return yyyy-MM-dd
     */
    public static final String getCurrentFirstWeekDay(String format) {
        int week = getCurrentWeek();
        return week == 0 ? getGapDay(-6, format) : getGapDay(-(week - 1),
                format);
    }

    /**
     * 得到当前月有多少天
     *
     * @return
     */
    public static final int getCurrentLastMonthDay() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        return cal.getMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到本周的最后一天，星期日
     *
     * @return
     */
    public static final String getCurrentLastWeekDay(String Format) {
        int week = getCurrentWeek();
        return week == 0 ? getGapDay(0, Format) : getGapDay(7 - week, Format);
    }

    /**
     * 得到系统当前的月份
     *
     * @return
     */
    public static final int getCurrentMonth() {
        return new GregorianCalendar().get(Calendar.MONTH) + 1;
    }

    /**
     * 获得当前时间 年月日时分秒毫米的字符串
     */
    public static final String getCalendarStr() {
        Calendar x = Calendar.getInstance();
        String fname = x.get(Calendar.YEAR) + "" + (x.get(Calendar.MONTH) + 1)
                + "" + x.get(Calendar.DAY_OF_MONTH) + "" + x.get(Calendar.HOUR)
                + "" + x.get(Calendar.MINUTE) + "" + x.get(Calendar.SECOND)
                + "" + x.get(Calendar.MILLISECOND);
        return fname;
    }

    /**
     * 得到系统当前时间值，以毫秒为单位。
     *
     * @return
     */
    public static final long getCurrentMSEL() {
        return new GregorianCalendar().getTimeInMillis();
    }

    /**
     * 得到系统当前的星期几
     *
     * @return 返回值：0 代表星期日，1代表星期1，2代表星期2，以此类推
     */
    public static final int getCurrentWeek() {
        return new GregorianCalendar().get(Calendar.DAY_OF_WEEK) - 1;
    }


    /**
     * 得到系统当前的年
     *
     * @return
     */
    public static final int getCurrentYear() {
        return new GregorianCalendar().get(Calendar.YEAR);
    }

    /**
     * 将一个字符串的日期描述转换为java.util.Date对象
     *
     * @param strDate 字符串的日期描述
     * @param format  字符串的日期格式，比如:“yyyy-MM-dd HH:mm”
     * @return 字符串转换的日期对象java.util.Date
     */
    public static final Date getDate(String strDate, String format) {
        if (strDate == null || strDate.trim().equals("")) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        //formatter.setTimeZone(timeZone);
        Date date;
        try {
            date = formatter.parse(strDate);
        } catch (ParseException e) {
            date = null;
        }
        return date;
    }

    /**
     * 判断当前时间是否在小于指定时间
     *
     * @param strDate 日期格式yyyy-MM-dd或yyyy-MM-dd HH:mm:ss
     * @return 小于返回true
     */
    public static final boolean getIsLessNow(String strDate) {
        String format = strDate.length() > 10 ? FORMAT_yyyy_MM_dd_HH_mm_ss
                : FORMAT_yyyy_MM_dd;
        return getCurrentMSEL() < getMSELByFormat(strDate, format);
    }

    /**
     * 判断当前时间是否在小于指定时间
     *
     * @param date
     * @return 小于返回true
     */
    public static final boolean getIsLessNow(Date date) {
        return getCurrentMSEL() < date.getTime();
    }

    /**
     * 判断当前时间是否在小于指定时间
     *
     * @param dateL
     * @return 小于返回true
     */
    public static final boolean getIsLessNow(long dateL) {
        return getCurrentMSEL() < dateL;
    }

    /**
     * 指定格式转换时间date
     *
     * @param format
     * @param date
     * @return
     */
    public static final String getDatetime(String format, Date date) {
        if (date == null)
            return null;
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 传入Calendar对象，得到返回时间 YYYYMMDD
     *
     * @param cal
     * @return
     */
    public static final int getDayDef1(Calendar cal) {
        return getDayDef1(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal
                .get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 输入 年,月,日 返回时间 YYYYMMDD
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static final int getDayDef1(int year, int month, int day) {
        StringBuffer sb = new StringBuffer(8);
        sb.append(year);
        sb.append(month < 10 ? "0" + month : month);
        sb.append(day < 10 ? "0" + day : day);
        return new Integer(sb.toString()).intValue();
    }

    /**
     * 输入 年,月, 日 返回时间 YYYYMMDD
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static final int getDayDef1(String year, String month, String day) {
        StringBuffer sb = new StringBuffer(8);
        sb.append(year);
        sb.append(month.length() == 1 ? "0" + month : month);
        sb.append(day.length() == 1 ? "0" + day : day);
        return new Integer(sb.toString()).intValue();
    }

    /**
     * 传入Calendar对象，得到返回时间 YYYY-MM-DD
     *
     * @param cal
     * @return
     */
    public static final String getDayDef2(Calendar cal) {
        return getDayDef2(cal.get(Calendar.YEAR) + "", cal.get(Calendar.MONTH)
                + "", cal.get(Calendar.DAY_OF_MONTH) + "", "-");
    }

    /**
     * 输入 年, 月, 日 返回时间 YYYY-MM-DD
     *
     * @param year
     * @param month
     * @param day
     * @param str   年月日 之间的符号 如："-">>YYYY-MM-DD;"">>YYYYMMDD
     * @return
     */
    public static final String getDayDef2(int year, int month, int day,
                                          String str) {
        StringBuffer sb = new StringBuffer(8);
        sb.append(year + str);
        sb.append((month < 10 ? "0" + month : month) + str);
        sb.append(day < 10 ? "0" + day : day);
        return sb.toString();
    }

    /**
     * 输入 年, 月, 日 返回时间
     *
     * @param year
     * @param month
     * @param day
     * @param str   年月日 之间的符号 如："-">>YYYY-MM-DD;"">>YYYYMMDD
     * @return
     */
    public static final String getDayDef2(String year, String month,
                                          String day, String str) {
        StringBuffer sb = new StringBuffer(10);
        sb.append(year + str);
        sb.append((month.length() == 1 ? "0" + month : month) + str);
        sb.append(day.length() == 1 ? "0" + day : day);
        return sb.toString();
    }

    /**
     * 以当前时间加减天数的日期
     *
     * @param day 推移的天数(+-)
     * @return yyyy-MM-dd
     */
    public static final String getGapDay(int day, String Format) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        cal.add(GregorianCalendar.DAY_OF_MONTH, day);
        return new SimpleDateFormat(Format).format(cal.getTime());
    }

    /**
     * 以指定时间加减天数的日期
     *
     * @param day 推移的天数(+-)
     * @return yyyy-MM-dd
     */
    public static final Date getGapDay(int day, Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(GregorianCalendar.DAY_OF_MONTH, day);
        return cal.getTime();
    }

    /**
     * 计算时间差
     *
     * @param begin 开始时间
     * @param end   结束时间
     * @return hours + " 小时 " + minutes + " 分) " + seconds + " 秒";
     */
    public static final String getGapTime(Date begin, Date end) {
        long l1 = begin.getTime();
        long l2 = end.getTime();
        int difference = (int) (l2 - l1);
        difference = difference / 1000;
        int hours, minutes, seconds;
        hours = difference / 3600;
        difference = difference - (hours * 3600);
        minutes = difference / 60;
        difference = difference - (minutes * 60);
        seconds = difference;
        return hours + " 小时 " + minutes + " 分 " + seconds + " 秒";
    }

    /**
     * 将毫秒转换成所对应格式的日期
     *
     * @param msel   毫秒时间
     * @param Format 指定的格式， 如"yyyy-MM-dd"
     * @return 毫秒时间 所对应的格式的日期
     */
    public static final String getformatDate(long msel, String Format) {
        SimpleDateFormat formatter = new SimpleDateFormat(Format);
        formatter.setTimeZone(timeZone);
        return formatter.format(new Date(msel));
    }

    /**
     * 将指定的毫秒转换为YYYYMMDD的格式
     *
     * @param msel
     * @return
     */
    public static final int getformatMSEL(long msel) {
        return getDayDef1(getformatMSELtoCal(msel));
    }

    /**
     * 将指定的毫秒转换为Calendar对象
     *
     * @param msel
     * @return
     */
    public static final Calendar getformatMSELtoCal(long msel) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date(msel));
        return cal;
    }

    /**
     * 获得给定两个日期相差度天数
     *
     * @param date1 参数格式:2009-06-21
     * @param date2
     * @return
     */
    public static final long getGapDays(String date1, String date2) {
        String[] d1 = date1.split("-");
        String[] d2 = date2.split("-");

        Calendar c = Calendar.getInstance();

        c.set(Integer.parseInt(d1[0]), Integer.parseInt(d1[1]), Integer.parseInt(d1[2]), 0, 0, 0);
        long l1 = c.getTimeInMillis();

        c.set(Integer.parseInt(d2[0]), Integer.parseInt(d2[1]), Integer.parseInt(d2[2]), 0, 0, 0);
        long l2 = c.getTimeInMillis();

        return (Math.abs(l1 - l2) / (24 * 60 * 60 * 1000));
    }

    /**
     * 计算剩余时间,返回形式 xx年XX月xx日XX小时xx分xx秒
     *
     * @param beginL
     * @param endL
     * @return
     */
    public static String getGapTimes(long beginL, long endL) {
        long between = (endL - beginL) / 1000;// 除以1000是为了转换成秒
        StringBuffer sb = new StringBuffer();
        if (endL > beginL) {
            long day = between / (24 * 3600);
            long hour = between % (24 * 3600) / 3600;
            long minute = between % 3600 / 60;
            long second = between % 60;
            if (day > 0)
                sb.append(day + "天");
            if (hour > 0)
                sb.append(hour + "小时");
            if (minute > 0)
                sb.append(minute + "分");
            sb.append(second + "秒");
        } else {
            sb.append("");
        }
        return sb.toString();
    }

    /**
     * 给定一个年份判断该年份是否为闰年
     *
     * @param year
     * @return
     */
    public static final boolean getisLeapYear(int year) {
        return new GregorianCalendar().isLeapYear(year);
    }

    /**
     * 获得7天前yyyy-MM-dd
     *
     * @return
     */
    public static final String getLast7days(String format) {
        long msel[] = getTimeperiodMSEL(LAST7DAYS, new Date().getTime());
        Date date = new Date(msel[0]);
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获得上月月第一天
     *
     * @return
     */
    public static final String getLastMonth(String format) {
        long msel[] = getTimeperiodMSEL(LASTMONTH, new Date().getTime());
        Date date = new Date(msel[0]);
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获得指定日期的本月第一天yyyy-MM-dd
     *
     * @param format 指定格式
     * @return Date
     */
    public static final Date getLastMonth(String format, Date d) {
        long msel[] = getTimeperiodMSEL(LASTMONTH, d.getTime());
        return new Date(msel[0]);
    }

    /**
     * 将字符串型的时间转换为毫秒数
     *
     * @param strDate
     * @param format  指定格式
     * @return long
     */
    public static final long getMSELByFormat(String strDate, String format) {
        Date date = getDate(strDate, format);
        return date == null ? 0l : date.getTime();
    }

    /**
     * 得到系统的当前时间 YYYYMMDD
     *
     * @return
     */
    public static final int getThisday1() {
        StringBuffer sb = new StringBuffer(8);
        sb.append(getCurrentYear());
        int iMonth = getCurrentMonth();
        sb.append(iMonth < 10 ? "0" + iMonth : iMonth);
        int iDay = getCurrentDay();
        sb.append(iDay < 10 ? "0" + iDay : iDay);
        return new Integer(sb.toString()).intValue();
    }

    /**
     * 得到系统的当前时间 YYYY-MM-DD
     *
     * @param str 年月日 之间的符号 如："-">>YYYY-MM-DD；"">>YYYYMMDD
     * @return
     */
    public static final String getThisday2(String str) {
        StringBuffer sb = new StringBuffer(10);
        sb.append(getCurrentYear() + str);
        int iMonth = getCurrentMonth();
        sb.append((iMonth < 10 ? "0" + iMonth : iMonth) + str);
        int iDay = getCurrentDay();
        sb.append(iDay < 10 ? "0" + iDay : iDay);
        return sb.toString();
    }

    /**
     * 获得本月第一天yyyy-MM-dd
     *
     * @param format 指定格式
     * @return String
     */
    public static final String getThisMonth(String format) {
        long msel[] = getTimeperiodMSEL(THISMONTH, new Date().getTime());
        Date date = new Date(msel[0]);
        return new SimpleDateFormat(format).format(date);
    }


    /**
     * 指定的年，月，日转成毫秒数
     *
     * @param year
     * @param month
     * @param day
     * @return 毫秒数
     */
    public static final long getTimeperiodMSEL(int year, int month, int day) {
        Calendar cal = new GregorianCalendar();
        cal.set(year, month, day, 0, 0, 0);
        return cal.getTime().getTime();
    }

    /**
     * 根据选择的时间区段，返回起始和终止的毫秒数
     *
     * @param timeperiodType
     * @param originalMSEL
     * @return
     */
    public static final long[] getTimeperiodMSEL(int timeperiodType,
                                                 long originalMSEL) {
        long[] timeperiodMSEL = new long[2];
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        timeperiodMSEL[0] = calendar.getTime().getTime();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        timeperiodMSEL[1] = calendar.getTime().getTime();

        if (timeperiodType == TODAY) { // 日期时段为“今天”

        } else if (timeperiodType == YESTERDAY) { // 日期时段为“昨天”
            timeperiodMSEL[0] = timeperiodMSEL[0] - (24 * 60 * 60 * 1000);
            timeperiodMSEL[1] = timeperiodMSEL[1] - (24 * 60 * 60 * 1000);
        } else if (timeperiodType == LAST7DAYS) { // 日期时段为“前 7 天”
            timeperiodMSEL[0] = timeperiodMSEL[0] - (7 * 24 * 60 * 60 * 1000);
            timeperiodMSEL[1] = timeperiodMSEL[1] - (24 * 60 * 60 * 1000);
        } else if (timeperiodType == THISMONTH) { // 日期时段为“本月”
            calendar.set(calendar.get(Calendar.YEAR), calendar
                    .get(Calendar.MONTH), calendar
                    .getActualMinimum(Calendar.DAY_OF_MONTH), 0, 0, 0);
            timeperiodMSEL[0] = calendar.getTime().getTime();
            calendar.set(calendar.get(Calendar.YEAR), calendar
                    .get(Calendar.MONTH), calendar
                    .getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
            timeperiodMSEL[1] = calendar.getTime().getTime();
        } else if (timeperiodType == LASTMONTH) { // 日期时段为“上月”
            calendar.set(calendar.get(Calendar.YEAR), calendar
                    .get(Calendar.MONTH) - 1, 1, 0, 0, 0);
            timeperiodMSEL[0] = calendar.getTime().getTime();
            calendar.set(calendar.get(Calendar.YEAR), calendar
                    .get(Calendar.MONTH), calendar
                    .getActualMaximum(Calendar.DAY_OF_MONTH), 23, 59, 59);
            timeperiodMSEL[1] = calendar.getTime().getTime();
        } else if (timeperiodType == ALLTIME) { // 所有时间
            timeperiodMSEL[0] = originalMSEL;
            timeperiodMSEL[1] = System.currentTimeMillis();
        }
        return timeperiodMSEL;
    }

    /**
     * 给出任意一个date得到该天是星期几
     *
     * @param date
     * @return 返回值：0 代表星期日，1代表星期1，2代表星期2，以此类推
     */
    public static final int getWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 获得昨天
     *
     * @param format 指定格式
     * @return
     */
    public static final String getYesterday(String format) {
        long msel[] = getTimeperiodMSEL(YESTERDAY, new Date().getTime());
        Date date = new Date(msel[0]);
        return new SimpleDateFormat(format).format(date);

    }

    /**
     * 根据生日获取当前年龄
     *
     * @param birthDay
     * @return
     * @throws Exception
     */
    public static final String getAge(Date birthDay) {
        if (birthDay == null) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            return "0";
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //monthNow==monthBirth 
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            } else {
                //monthNow>monthBirth 
                age--;
            }
        }

        return age + "";
    }


}
