package com.guaiwuxue.pojo;



import java.io.Serializable;

/**
 * 书籍类型实体类
 * @Author: Custom
 * @Date: 2020/7/10 22:49
 * @Version: 1.0
 */
public class BookType implements Serializable {
    /**
     * 类型编码
     */
    private String typeId;
    /**
     * 类型名称
     */
    private String typeName;

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
}
