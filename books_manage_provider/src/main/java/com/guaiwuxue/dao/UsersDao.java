package com.guaiwuxue.dao;

import com.guaiwuxue.pojo.Users;

import java.util.List;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/3 17:23
 * @Version: 1.0
 */
public interface UsersDao {

    /**
     * 查询全部用户部分信息
     * @return
     */
    List<Users> findAllToBorrowInfoCreate();

}
