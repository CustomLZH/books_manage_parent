package com.guaiwuxue.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/3 23:37
 * @Version: 1.0
 */
public class WeekAllNumResp implements Comparable {

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 类别
     */
    private String stack;

    /**
     * 数据
     */
    private TreeSet<WeekNumResp> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public TreeSet<WeekNumResp> getData() {
        return data;
    }

    public void setData(TreeSet<WeekNumResp> data) {
        this.data = data;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
