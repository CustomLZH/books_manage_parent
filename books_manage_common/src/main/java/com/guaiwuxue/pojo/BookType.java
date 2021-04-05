package com.guaiwuxue.pojo;



import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * 书籍类型实体类
 * @Author: Custom
 * @Date: 2020/7/10 22:49
 * @Version: 1.0
 */
public class BookType implements Serializable, Comparable {
    /**
     * 类型编码
     */
    private String typeId;
    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 更新时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    /**
     * 创建时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
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

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookType)) return false;

        BookType bookType = (BookType) o;

        if (getTypeId() != null ? !getTypeId().equals(bookType.getTypeId()) : bookType.getTypeId() != null)
            return false;
        return getTypeName() != null ? getTypeName().equals(bookType.getTypeName()) : bookType.getTypeName() == null;
    }

    @Override
    public int hashCode() {
        int result = getTypeId() != null ? getTypeId().hashCode() : 0;
        result = 31 * result + (getTypeName() != null ? getTypeName().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        return this.typeId.compareTo(((BookType) o).typeId);
    }
}
