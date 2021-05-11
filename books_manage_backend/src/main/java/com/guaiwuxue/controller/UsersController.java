package com.guaiwuxue.controller;

import com.guaiwuxue.constant.MessageConstant;
import com.guaiwuxue.constant.RolePermissionConstant;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.Result;
import com.guaiwuxue.pojo.Users;
import com.guaiwuxue.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
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
     * 分页查询
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return usersService.findPage(queryPageBean);
    }

    /**
     * 添加用户
     * @param users
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.CREATE_USERS + "')")
    @RequestMapping("/createUsers")
    public Result<Void> createUsers(@RequestBody Users users) {
        if (users == null || users.getUserName() == null || users.getUserPhone() == null || users.getBorrowNum() == null)
            return new Result<>(false, "请检查是否填写数据");
        try {
            usersService.createUsers(users);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.CREATE_USERS_FAIL);
        }
        return new Result<>(true,MessageConstant.CREATE_USERS_SUCCESS);
    }


    /**
     * 更新用户
     * @param users
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.UPDATE_USERS + "')")
    @RequestMapping("/updateUsers")
    public Result<Void> updateUsers(@RequestBody Users users) {
        if (users == null || users.getUserName() == null || users.getUserPhone() == null || users.getBorrowNum() == null)
            return new Result<>(false, "请检查是否填写数据");
        try {
            usersService.updateUsers(users);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.UPDATE_USERS_FAIL);
        }
        return new Result<>(true,MessageConstant.UPDATE_USERS_SUCCESS);
    }

    /**
     * 获取所有图书部分信息
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
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
    /**
     * 根据用户id删除
     * @param userId
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.DELETE_USERS + "')")
    @RequestMapping("/delete")
    public Result<Void> delete(Long userId){
        try{
            usersService.delete(userId);
            return new Result<>(true, MessageConstant.DELETE_USERS_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,MessageConstant.DELETE_USERS_FAIL);
        }
    }
    /**
     * 根据用户集合删除
     * @param multipleSelection
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.DELETE_USERS + "')")
    @RequestMapping("/deleteAll")
    public Result<Void> deleteAll(@RequestBody List<Users> multipleSelection){
        try{
            usersService.deleteAll(multipleSelection);
            return new Result<>(true, MessageConstant.DELETE_USERS_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,MessageConstant.DELETE_USERS_FAIL);
        }
    }
}
