package com.guaiwuxue.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/3 23:54
 * @Version: 1.0
 */
public class DateUtil {

    public static Date getThisWeekMondayDate() {
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE,cal.getFirstDayOfWeek() - dayWeek);
        return cal.getTime();
    }

    public static List<Date> getThisWeekDays() {
        Date thisWeekMondayDate = DateUtil.getThisWeekMondayDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(thisWeekMondayDate);
        List<Date> dates = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            dates.add(cal.getTime());
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        return dates;
    }


}
