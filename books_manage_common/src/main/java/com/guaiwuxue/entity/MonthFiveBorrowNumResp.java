package com.guaiwuxue.entity;

import java.io.Serializable;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/2 9:13
 * @Version: 1.0
 */
public class MonthFiveBorrowNumResp implements Serializable {

    /**
     * 书籍id
     */
    private Long bookId;

    /**
     * 书籍名称
     */
    private String bookName;

    /**
     * 数量
     */
    private Integer count;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
