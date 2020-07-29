package com.guaiwuxue.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guaiwuxue.dao.BookTypeDao;
import com.guaiwuxue.dao.BooksDao;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.BookType;
import com.guaiwuxue.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author: Custom
 * @Date: 2020/7/17 21:07
 * @Version: 1.0
 */
@Service
public class BookTypeServiceImpl implements BookTypeService {

    @Autowired
    private BookTypeDao bookTypeDao;
    @Autowired
    private BooksDao booksDao;

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //页码
        Integer currentPage = queryPageBean.getCurrentPage();
        //每页记录数
        Integer pageSize = queryPageBean.getPageSize();
        //查询条件
        String requirement = queryPageBean.getRequirement();

        //保证页码正常
        if (currentPage == null || currentPage < 1){
            currentPage = 1;
        }
        //保证每页显示记录正常
        if (pageSize == null || pageSize < 1){
            pageSize = 10;
        }
        //保证条件正常
        if (requirement == null || "".equals(requirement.trim())){
            requirement = "";
        }else {
            //保证分页后回到第一页
            currentPage = 1;
        }


        //初始化分页数据
        PageHelper.startPage(currentPage,pageSize);
        //调用查询，获得分页对象
        Page<BookType> page = bookTypeDao.findPageByCondition("%" + requirement + "%");
        //返回分页结果数据
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public int delete(String typeId) {

        //查询是否有书籍使用该类型编号
        int count = booksDao.findCountByTypeId(typeId);
        //进行判断
        if (count > 0){
            return count;
        }

        //删除该类型
        bookTypeDao.deleteBytypeId(typeId);
        return count;
    }

    @Override
    public boolean createBookType(BookType bookType) {
        //根据类型id查询书籍类型
        BookType bookType1 = bookTypeDao.findTypeNameByTypeId(bookType.getTypeId());
        //查询到则使用更新操作
        if (bookType1 != null){
            bookTypeDao.updateByTypeId(bookType);
            return false;
        }
        bookTypeDao.createBookType(bookType);
        return true;
    }

    @Override
    public BookType findBookTypeByTypeId(String typeId) {
        return bookTypeDao.findTypeNameByTypeId(typeId);
    }

    @Override
    public void updateBookType(BookType bookType) {
        bookTypeDao.updateByTypeId(bookType);
    }

    @Override
    public List<BookType> findBookTypeAll() {
        return bookTypeDao.findBookTypeAll();
    }
}
