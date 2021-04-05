package com.guaiwuxue.service;

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

}
