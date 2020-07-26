package com.guaiwuxue.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.guaiwuxue.dao.AdminDao;
import com.guaiwuxue.dao.PermissionDao;
import com.guaiwuxue.dao.RoleDao;
import com.guaiwuxue.pojo.Admin;
import com.guaiwuxue.pojo.Permission;
import com.guaiwuxue.pojo.Role;
import com.guaiwuxue.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * @Author: Custom
 * @Date: 2020/7/25 11:03
 * @Version: 1.0
 */
@Service
public class AdminServiceImpl implements AdminService {



    @Autowired
    private AdminDao adminDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Admin findByUsername(String adminUsername) {
        // 获取用户基本信息
        Admin admin = adminDao.findByUsername(adminUsername);

        // 获取与管理员相关的角色
        Set<Role> roles = roleDao.findByAdminId(admin.getAdminId());

        // 对角色的权限进行封装
        for (Role role : roles) {
            Set<Permission> permissions = permissionDao.findByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        // 对管理员的角色进行封装
        admin.setRoles(roles);

        return admin;
    }
}
