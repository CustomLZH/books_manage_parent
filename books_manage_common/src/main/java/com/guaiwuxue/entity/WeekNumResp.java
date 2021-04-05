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

    public WeekNumResp() {
    }

    public WeekNumResp(Date date) {
        this.date = date;
    }

    public WeekNumResp(Date date, Integer num) {
        this.date = date;
        this.num = num;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeekNumResp)) return false;

        WeekNumResp that = (WeekNumResp) o;

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        boolean equals = sf.format(getDate()).equals(sf.format(that.getDate()));
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
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        int i = sf.format(this.date).compareTo(sf.format(((WeekNumResp) o).date));
        if (0 == i) {
            ((WeekNumResp)o).num = this.num;
        }
        return i;
    }
}
