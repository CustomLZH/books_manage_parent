package com.guaiwuxue.service.impl;

import com.guaiwuxue.dao.UsersDao;
import com.guaiwuxue.pojo.Users;
import com.guaiwuxue.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/3 17:21
 * @Version: 1.0
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> findAllToBorrowInfoCreate() {
        return usersDao.findAllToBorrowInfoCreate();
    }
}
