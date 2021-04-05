package com.guaiwuxue.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 封装获取的条件
 * @Author: Custom
 * @Date: 2020/7/12 9:46
 * @Version: 1.0
 */
public class QueryPageBean implements Serializable {
    /**
     * 页码
     */
    private Integer currentPage;
    /**
     * 每页记录数
     */
    private Integer pageSize;
    /**
     * 查询条件
     */
    private String requirement;

    /**
     * 筛选条件
     */
    private List<String> screens;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public List<String> getScreens() {
        return screens;
    }

    public void setScreens(List<String> screens) {
        this.screens = screens;
    }
}
