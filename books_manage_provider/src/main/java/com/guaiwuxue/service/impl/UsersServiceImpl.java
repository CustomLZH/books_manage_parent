package com.guaiwuxue.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guaiwuxue.dao.UsersDao;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.Books;
import com.guaiwuxue.pojo.Users;
import com.guaiwuxue.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/3 17:21
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true)
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> findAllToBorrowInfoCreate() {
        return usersDao.findAllToBorrowInfoCreate();
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
        if (currentPage==null || currentPage<1){
            currentPage = 1;
        }
        //保证页码正常
        if (pageSize==null || pageSize<1){
            pageSize = 8;
        }
        //保证每页显示记录正常
        if (requirement==null || "".equals(requirement.trim())){
            requirement = "";
        }else {
            //保证分页后回到第一页
            currentPage = 1;
        }

        PageHelper.startPage(currentPage,pageSize);
        Page<Users> page = usersDao.findPageByCondition("%" + requirement +"%");

        return new PageResult(page.getTotal(),page.getResult());
    }

    
    @Override
    public void delete(Long userId) {
        usersDao.delete(userId);
    }

    
    @Override
    public void createUsers(Users users) {
        usersDao.createUsers(users);
    }

    
    @Override
    public void updateUsers(Users users) {
        usersDao.updateUsers(users);
    }

    @Override
    public void deleteAll(List<Users> multipleSelection) {
        usersDao.deleteAll(multipleSelection);
    }
}
