package com.standard.library.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间转换
 */

public class DateUtils {
    public static long convertDateToTimestamp(String datetime) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = null;
            try {
                date = format.parse(datetime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return date.getTime();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String convertLongToTime(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date(time);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String convertLongToDateTime(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date date = new Date(time);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String convertLongToDateTimeSecond(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(time);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String publishInfoDate(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date date = new Date(time);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static Date nextMonthFirstDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }

    public static String convertToDate(long time, Date date) {
        try {
            String str = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
            if (date == null) {
                Date newDate = new Date(time);
                str = sdf.format(newDate);
            } else {
                str = sdf.format(date);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    public static String convertLongToStrDate(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(time);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }

    }

    /**
     * 使用java正则表达式去掉多余的.与0
     *
     * @param s
     * @return
     */
    public static String subZeroAndDot(String s) {
        if (s.indexOf(".") > 0) {
            s = s.replaceAll("0+?$", "");//去掉多余的0
            s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
        }
        return s;
    }

    public static String convertLongToDate(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            Date date = new Date(time);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 判断给定字符串时间是否为今日
     *
     * @param timeDate
     * @return boolean
     */
    public static boolean isToday(String timeDate) {
        boolean b = false;
        Date today = new Date();
        String nowDate = dateFormater2.get().format(today);
        if (nowDate.equals(timeDate)) {
            b = true;
        }
        return b;
    }

    public static String convertInfoDate(long date) {
        long nowDate = System.currentTimeMillis();

        long mins = (nowDate - date) / (60 * 1000);
        long hour = mins / 60;
        if (hour > 24) {
            return convertLongToDateTimeSecond(date);
        } else if (hour > 1) {
            if (convertLongToStrDate(date).equals(convertLongToStrDate(nowDate))) {
                return hour + "小时前";
            } else {
                return convertLongToStrDate(date);
            }
        } else {
            return mins + "分钟前";
        }
    }

    private static ThreadLocal<SimpleDateFormat> dateFormater2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

    /**
     * 小时分钟
     *
     * @param time
     * @return
     */
    public static String convertLongToHourAndSecond(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
            Date date = new Date(time);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String convertStorageToDate(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm");
            Date date = new Date(time);
            String str = sdf.format(date);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getDayAndHours(long time) {
        long day = time / (365 * 24 * 60 * 60);
        long second = time / 1000;
        long hour = second / 60 / 60;
        long minute = (second - hour * 60 * 60) / 60;

        return day + "天" + hour + "小时" + minute + "分";
    }
}
