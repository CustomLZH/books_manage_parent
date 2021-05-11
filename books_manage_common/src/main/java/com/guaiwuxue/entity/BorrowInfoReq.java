package com.guaiwuxue.entity;

import com.guaiwuxue.pojo.BorrowInfo;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/1 15:11
 * @Version: 1.0
 */
public class BorrowInfoReq extends BorrowInfo {

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String bookWriter;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户联系电话
     */
    private String userPhone;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
