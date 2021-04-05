package com.guaiwuxue.controller;

import com.guaiwuxue.entity.Result;
import com.guaiwuxue.pojo.Books;
import com.guaiwuxue.pojo.Users;
import com.guaiwuxue.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liuzhaohong
 * @Date: 2021/4/3 17:17
 * @Version: 1.0
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 获取所有图书部分信息
     * @return
     */
    @RequestMapping("/findAllToBorrowInfoCreate")
    public Result<List<Users>> findAllToBorrowInfoCreate(){
        // 1. 调用service接口
        try {
            List<Users> usersList = usersService.findAllToBorrowInfoCreate();
            return new Result<>(true,"获取成功",usersList);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,"获取失败");
        }
    }
}
