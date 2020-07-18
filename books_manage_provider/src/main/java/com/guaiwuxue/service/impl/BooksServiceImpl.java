package com.guaiwuxue.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guaiwuxue.dao.BooksDao;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.Books;
import com.guaiwuxue.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        if (pageSize==null||pageSize<1){
            pageSize=10;
        }
        if (requirement==null||"".equals(requirement.trim())){
            requirement="";
        }

        PageHelper.startPage(currentPage,pageSize);
        Page<Books> page = booksDao.findPageByCondition("%" + requirement +"%");

        PageResult pageResult = new PageResult(page.getTotal(),page.getResult());
        return pageResult;
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
}
