package com.guaiwuxue.pojo;



import java.io.Serializable;
import java.util.Date;


/**
 * 书籍实体类
 * @Author: Custom
 * @Date: 2020/7/10 23:15
 * @Version: 1.0
 */
public class Books implements Serializable {
    /**
     * 图书编号
     */
    private Integer bookId;
    /**
     * 类别编号
     */
    private String typeId;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 作者
     */
    private String bookWriter;
    /**
     * 出版社
     */
    private String bookCompany;
    /**
     *
     */
    private Date bookDate;
    /**
     * 简介
     */
    private String bookBrief;
    /**
     * 拥有数量
     */
    private Integer bookNum;
    /**
     * 借阅数量
     */
    private Integer borrowNum;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

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

    public String getBookCompany() {
        return bookCompany;
    }

    public void setBookCompany(String bookCompany) {
        this.bookCompany = bookCompany;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public String getBookBrief() {
        return bookBrief;
    }

    public void setBookBrief(String bookBrief) {
        this.bookBrief = bookBrief;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }
}
