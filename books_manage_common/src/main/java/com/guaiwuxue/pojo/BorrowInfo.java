package com.guaiwuxue.pojo;

import java.util.Date;

/**
 * 借阅信息实体类
 * @Author: Custom
 * @Date: 2020/7/10 22:58
 * @Version: 1.0
 */
public class BorrowInfo {

    /**
     * 借阅id
     */
    private Long borrowInfoId;

    /**
     * 图书编号
     */
    private Long bookId;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 借阅日期
     */
    private Date borrowDate;
    /**
     * 归还日期
     */
    private Date returnDate;
    /**
     * 是否归还
     */
    private Boolean restore;
    /**
     * 是否续借
     */
    private Boolean renew;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 创建时间
     */
    private Date createDate;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getBorrowInfoId() {
        return borrowInfoId;
    }

    public void setBorrowInfoId(Long borrowInfoId) {
        this.borrowInfoId = borrowInfoId;
    }



    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean getRestore() {
        return restore;
    }

    public void setRestore(Boolean restore) {
        this.restore = restore;
    }

    public Boolean getRenew() {
        return renew;
    }

    public void setRenew(Boolean renew) {
        this.renew = renew;
    }
}
