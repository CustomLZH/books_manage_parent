package com.guaiwuxue.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guaiwuxue.dao.BooksDao;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.Books;
import com.guaiwuxue.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 关于图书接口的实现类
 * @Author: Custom
 * @Date: 2020/7/11 18:08
 * @Version: 1.0
 */
@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksDao booksDao;

    @Override
    public List<Books> findAll() {
        return booksDao.findAll();
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //页码
        Integer currentPage = queryPageBean.getCurrentPage();
        //每页记录数
        Integer pageSize = queryPageBean.getPageSize();
        //查询条件
        String requirement = queryPageBean.getRequirement();
        //做判断,以防万一当前页面和每页显示的数量为负数
        if (currentPage==null||currentPage<1){
            currentPage = 1;
        }
        //保证页码正常
        if (pageSize==null||pageSize<1){
            pageSize=8;
        }
        //保证每页显示记录正常
        if (requirement==null||"".equals(requirement.trim())){
            requirement="";
        }else {
            //保证分页后回到第一页
            currentPage = 1;
        }

        PageHelper.startPage(currentPage,pageSize);
        Page<Books> page = booksDao.findPageByCondition("%" + requirement +"%");

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void updateBorrowNumById(int bookId, int borrowNum) {
        int borrowNumOld = booksDao.findBorrowNumById(bookId);
        int bookNum = booksDao.findBookNumById(bookId);
        if (borrowNum+borrowNumOld>bookNum){
            throw new RuntimeException("库存不足");
        }
        booksDao.updateBorrowNumById(bookId,borrowNum+borrowNumOld);
    }

    @Override
    public Books findBookInfo(int bookId) {
        return booksDao.findBookInfoByBookId(bookId);
    }

    @Override
    public void insertBook(Books books) {
        booksDao.insertBook(books);
    }

    @Override
    public void deleteBookByBookId(int bookId) {
        booksDao.deleteBookByBookId(bookId);
    }

    @Override
    public void updateBookByBookId(Books books) {
        booksDao.updateBookByBookId(books);
    }
    @Override
    public void updateBookRepertoryByBookId(Books books) {
        Books booksRepertory = new Books();
        booksRepertory.setBookId(books.getBookId());
        booksRepertory.setBookNum(books.getBookNum());
        booksRepertory.setBorrowNum(books.getBorrowNum());
        booksDao.updateBookByBookId(booksRepertory);
    }

    @Override
    public PageResult findPageInfo(QueryPageBean queryPageBean, String orderBy) {
        //页码
        Integer currentPage = queryPageBean.getCurrentPage();
        //每页记录数
        Integer pageSize = queryPageBean.getPageSize();
        //查询条件
        String requirement = queryPageBean.getRequirement();
        //做判断,以防万一当前页面和每页显示的数量为负数
        if (currentPage==null||currentPage<1){
            currentPage = 1;
        }
        //保证页码正常
        if (pageSize==null||pageSize<1){
            pageSize=8;
        }
        //保证每页显示记录正常
        if (requirement==null||"".equals(requirement.trim())){
            requirement="";
        }else {
            //保证分页后回到第一页
            currentPage = 1;
        }
        // 按order排序
        PageHelper.startPage(currentPage,pageSize,orderBy);
        Page<Map<String,Object>> page = booksDao.findPageInfo("%" + requirement +"%");

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public List<Books> findAllToBorrowInfoCreate() {
        return booksDao.findAllToBorrowInfoCreate();
    }
}
