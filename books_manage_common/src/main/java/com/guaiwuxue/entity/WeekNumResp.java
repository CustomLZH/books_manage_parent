package com.guaiwuxue.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/3 23:37
 * @Version: 1.0
 */
public class WeekNumResp implements Comparable {
    /**
     * 借阅日期
     */
    private Date date;
    /**
     * 借阅数量
     */
    private Integer num;

    /**
     * 星期编号
     */
    private Integer week;

    /**
     * 星期名称
     */
    private String weekName;


    public WeekNumResp() {
    }

    public WeekNumResp(Date date) {
        this.date = date;
    }

    public WeekNumResp(Date date, Integer num) {
        this.date = date;
        this.num = num;
    }

    public WeekNumResp(Date date, Integer num, Integer week, String weekName) {
        this.date = date;
        this.num = num;
        this.week = week;
        this.weekName = weekName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public String getWeekName() {
        return weekName;
    }

    public void setWeekName(String weekName) {
        this.weekName = weekName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeekNumResp)) return false;

        WeekNumResp that = (WeekNumResp) o;

        boolean equals = this.week.equals(that.week);
        if (equals) {
            ((WeekNumResp)o).num = this.num;
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return new SimpleDateFormat("yyyy-MM-dd").format(getDate()).hashCode();
    }


    @Override
    public int compareTo(Object o) {
        WeekNumResp that = (WeekNumResp) o;
        int i = this.week.compareTo(that.week);
        if (0 == i) {
            ((WeekNumResp)o).num = this.num;
        }
        return i;
    }
}
