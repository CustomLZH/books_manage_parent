package com.guaiwuxue.controller;

import com.guaiwuxue.constant.MessageConstant;
import com.guaiwuxue.constant.RolePermissionConstant;
import com.guaiwuxue.entity.*;
import com.guaiwuxue.pojo.Permission;
import com.guaiwuxue.pojo.Role;
import com.guaiwuxue.service.PermissionService;
import com.guaiwuxue.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * 角色
 *
 * @Author: LiuZhaoHong
 * @Date: 2021/4/20 18:53
 * @Version: 1.0
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("findAll")
    public Result<Set<Role>> findAll() {
        try {
            return new Result<>(true,MessageConstant.ROLE_FIND_ALL_SUCCESS, roleService.findAll());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, MessageConstant.ROLE_FIND_ALL_FAIL);
        }
    }

    /**
     * 分页查询
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        return roleService.findPage(queryPageBean);
    }

    /**
     * 查询所有权限
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.LOGIN + "')")
    @RequestMapping("findAllPermission")
    public Result<Set<Permission>> findAllPermission() {
        try {
            return new Result<>(true,MessageConstant.ROLE_FIND_ALL_SUCCESS, permissionService.findAllPermission());
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false, MessageConstant.ROLE_FIND_ALL_FAIL);
        }
    }


    /**
     * 根据角色id删除
     * @param id
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.DELETE_ROLE + "')")
    @RequestMapping("/delete")
    public Result<Void> delete(Long id){
        try{
            roleService.delete(id);
            return new Result<>(true, MessageConstant.DELETE_ROLE_SUCCESS);
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>(false,MessageConstant.DELETE_ROLE_FAIL);
        }
    }


    /**
     * 添加管理员
     * @param RolePermissions
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.ROLE_CREATE + "')")
    @RequestMapping("/createRole")
    public Result<Void> createUsers(@RequestBody RolePermissions RolePermissions) {
        if (RolePermissions == null || RolePermissions.getName() == null) {
            return new Result<>(false, "请检查是否填写数据");
        }
        if (roleService.findByName(RolePermissions.getName()) != null) {
            return new Result<>(false, "角色名已使用");
        }
        try {
            roleService.createRole(RolePermissions);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.CREATE_ADMIN_FAIL);
        }
        return new Result<>(true,MessageConstant.CREATE_ADMIN_SUCCESS);
    }

    /**
     * 更新管理员
     * @param RolePermissions
     * @return
     */
    @PreAuthorize("hasAuthority('" + RolePermissionConstant.ROLE_UPDATE + "')")
    @RequestMapping("/updateRole")
    public Result<Void> updateBorrowInfo(@RequestBody RolePermissions RolePermissions) {
        if (RolePermissions == null || RolePermissions.getName() == null)
            return new Result<>(false, "请检查是否填写数据");
        try {
            roleService.updateRole(RolePermissions);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(false,MessageConstant.UPDATE_ADMIN_FAIL);
        }
        return new Result<>(true,MessageConstant.UPDATE_ADMIN_SUCCESS);
    }


}
