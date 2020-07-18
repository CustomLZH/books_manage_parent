package com.guaiwuxue.dao;

import com.github.pagehelper.Page;
import com.guaiwuxue.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Custom
 * @Date: 2020/7/11 23:28
 * @Version: 1.0
 */
public interface BooksDao {

    /**
     * 查询所有书籍
     * @return
     */
    public List<Books> findAll();

    /**
     * 分页查询，可带条件
     * @param requirement
     * @return
     */
    public Page<Books> findPageByCondition(String requirement);

    /**
     * 根据id更新借阅数量
     * @param bookId
     * @param borrowNum
     * @return
     */
    public int updateBorrowNumById(@Param("bookId") int bookId, @Param("borrowNum") int borrowNum);

    /**
     * 根据id查询借阅数量
     * @param bookId
     * @return
     */
    public int findBorrowNumById(int bookId);

    /**
     * 根据id查询拥有数量
     * @param bookId
     * @return
     */
    public int findBookNumById(int bookId);

    /**
     * 查找按类型ID计数
     * @param typeId
     * @return
     */
    public int findCountByTypeId(String typeId);
}
