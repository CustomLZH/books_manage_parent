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

    /**
     * 查询书籍详细信息
     * @param bookId
     * @return
     */
    Books findBookInfo(int bookId);

    /**
     * 创建书籍
     * @param books
     */
    void insertBook(Books books);

    /**
     * 根据书籍id删除书籍
     * @param bookId
     */
    void deleteBookByBookId(int bookId);

    /**
     * 根据书籍id更新书籍
     * @param books
     */
    void updateBookByBookId(Books books);

    /**
     * 根据书籍id更新书籍库存
     * @param books
     */
    void updateBookRepertoryByBookId(Books books);

    /**
     * 分页查询详细数据
     * @param queryPageBean
     * @return
     */
    PageResult findPageInfo(QueryPageBean queryPageBean, String orderBy);

    /**
     * 查找所有书籍部分信息
     * @return
     */
    List<Books> findAllToBorrowInfoCreate();
}
