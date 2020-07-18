package com.guaiwuxue.service;

/**
 * @Author: Custom
 * @Date: 2020/7/11 18:04
 * @Version: 1.0
 */

import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.Books;

import java.util.List;

/**
 * 关于图书的接口
 */
public interface BooksService {

    /**
     * 查询所有的书籍
     * @return
     */
    public List<Books> findAll();

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult findPage(QueryPageBean queryPageBean);

    /**
     * 更新书籍借阅数量
     * @param bookId
     * @param borrowNum
     */
    void updateBorrowNumById(int bookId, int borrowNum);
}
