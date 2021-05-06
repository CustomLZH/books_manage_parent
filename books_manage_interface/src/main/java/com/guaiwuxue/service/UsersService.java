package com.guaiwuxue.service;

import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.Users;

import java.util.List;

/**
 * 用户接口
 * @Author: liuzhaohong
 * @Date: 2021/4/3 17:20
 * @Version: 1.0
 */
public interface UsersService {


    List<Users> findAllToBorrowInfoCreate();

    PageResult findPage(QueryPageBean queryPageBean);

    void delete(Long userId);

    void createUsers(Users users);

    void updateUsers(Users users);

    void deleteAll(List<Users> multipleSelection);
}
