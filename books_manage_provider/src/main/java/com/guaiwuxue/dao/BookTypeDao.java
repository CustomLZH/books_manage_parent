package com.guaiwuxue.dao;

import com.github.pagehelper.Page;
import com.guaiwuxue.pojo.BookType;

import java.util.TreeSet;

/**
 * @Author: Custom
 * @Date: 2020/7/17 21:10
 * @Version: 1.0
 */
public interface BookTypeDao {
    /**
     * 根据条件分页查询
     * @param requirement
     * @return
     */
    public Page<BookType> findPageByCondition(String requirement);

    /**
     * 根据类型ID删除
     * @param typeId
     */
    public void deleteBytypeId(String typeId);

    /**
     * 添加
     * @param bookType
     */
    void createBookType(BookType bookType);

    /**
     * 根据类型ID查找类型名称
     * @param typeId
     * @return
     */
    public BookType findTypeNameByTypeId(String typeId);

    /**
     * 更新书籍类型
     * @param bookType
     */
    public void updateByTypeId(BookType bookType);

    TreeSet<BookType> findBookTypeAll();
}
