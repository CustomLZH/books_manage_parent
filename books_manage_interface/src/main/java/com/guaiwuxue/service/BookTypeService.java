package com.guaiwuxue.service;

import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.BookType;

import java.util.List;
import java.util.TreeSet;

/**
 * @Author: Custom
 * @Date: 2020/7/17 21:04
 * @Version: 1.0
 */
public interface BookTypeService {
    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    public PageResult findPage(QueryPageBean queryPageBean);

    /**
     * 根据类型编号删除
     * @param typeId
     * @return
     */
    public int delete(String typeId);

    /**
     * 创建书籍类型
     * @param bookType
     * @return
     */
    boolean createBookType(BookType bookType);

    /**
     * 根据书籍类型ID查询书籍类型名称
     * @param typeId
     * @return
     */
    BookType findBookTypeByTypeId(String typeId);

    /**
     * 更新书籍类型
     * @param bookType
     */
    void updateBookType(BookType bookType);

    /**
     * 查询全部书籍类型
     * @return
     */
    TreeSet<BookType> findBookTypeAll();

    /**
     * 根据类型集合删除
     * @param multipleSelection
     * @return
     */
    int deleteAll(List<BookType> multipleSelection);
}
