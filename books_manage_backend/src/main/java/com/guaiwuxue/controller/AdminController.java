package com.guaiwuxue.controller;

import com.guaiwuxue.constant.MessageConstant;
import com.guaiwuxue.constant.RolePermissionConstant;
import com.guaiwuxue.entity.AdminRoles;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.Result;
import com.guaiwuxue.pojo.Admin;
import com.guaiwuxue.pojo.Users;
import com.guaiwuxue.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Custom
 * @Date: 2020/7/11 14:39
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * 分页查询
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return adminService.findPage(queryPageBean);
    }
    /**
     * 获得当前登录用户的用户名排除密码
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("/getAdminExcludePasswords")
    public Result<Admin> getAdminExcludePasswords(){
        //当Spring security完成认证后，会将当前用户信息保存到框架提供的上下文对象
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user != null){
            return new Result<>(true, MessageConstant.GET_ADMIN_SUCCESS, adminService.findByUsernameExcludePasswords(user.getUsername()));
        }
        return new Result<>(false, MessageConstant.GET_ADMIN_FAIL);
    }

    /**
     * 根据管理员id删除
     * @param adminId
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.ADMIN_DELETE + "')")
    @RequestMapping("/delete")
    public Result<Void> delete(Long adminId){
        try{
            adminService.delete(adminId);
            return new Result<>(true, MessageConstant.DELETE_ADMIN_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,MessageConstant.DELETE_ADMIN_FAIL);
        }
    }

    /**
     * 添加管理员
     * @param adminRoles
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.ADMIN_CREATE + "')")
    @RequestMapping("/createAdmin")
    public Result<Void> createUsers(@RequestBody AdminRoles adminRoles) {
        if (adminRoles == null || adminRoles.getAdminUsername() == null || adminRoles.getAdminPassword() == null) {
            return new Result<>(false, "请检查是否填写数据");
        }
        if (adminService.findByUsername(adminRoles.getAdminUsername()) != null) {
            return new Result<>(false, "用户名已使用");
        }
        try {
            adminService.createAdmin(adminRoles);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.CREATE_ADMIN_FAIL);
        }
        return new Result<>(true,MessageConstant.CREATE_ADMIN_SUCCESS);
    }

    /**
     * 更新管理员
     * @param adminRoles
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.ADMIN_UPDATE + "')")
    @RequestMapping("/updateAdmin")
    public Result<Void> updateBorrowInfo(@RequestBody AdminRoles adminRoles) {
        if (adminRoles == null || adminRoles.getAdminUsername() == null)
            return new Result<>(false, "请检查是否填写数据");
        try {
            adminService.updateAdmin(adminRoles);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.UPDATE_ADMIN_FAIL);
        }
        return new Result<>(true,MessageConstant.UPDATE_ADMIN_SUCCESS);
    }

}
