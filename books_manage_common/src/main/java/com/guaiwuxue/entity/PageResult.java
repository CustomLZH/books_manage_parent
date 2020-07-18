package com.guaiwuxue.entity;



import java.io.Serializable;
import java.util.List;

/**
 * 分页结果返回
 * @Author: Custom
 * @Date: 2020/7/12 9:40
 * @Version: 1.0
 */
public class PageResult implements Serializable {
    /**
     * 总记录数
     */
    private Long total;
    /**
     * 当前页结果
     */
    private List rows;

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
