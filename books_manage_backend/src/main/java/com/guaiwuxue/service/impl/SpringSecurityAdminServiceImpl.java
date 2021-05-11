package com.guaiwuxue.service.impl;

import com.guaiwuxue.entity.AdminRoles;
import com.guaiwuxue.entity.RolePermissions;
import com.guaiwuxue.pojo.Permission;
import com.guaiwuxue.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 用户登陆权限验证
 * @Author: Custom
 * @Date: 2020/7/24 18:21
 * @Version: 1.0
 */
@Component
public class SpringSecurityAdminServiceImpl implements UserDetailsService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AdminService adminService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AdminRoles adminUsername = adminService.findByUsername(username);
        List<AdminRoles> adminRoles = adminService.findAll();

        if (adminRoles == null) {
            // 创建一个默认的管理员并赋予全部权限

        }

        // 是否存在该管理员
        if (adminUsername == null){
            return null;
        }

        // 获取该管理员具备的角色
        Set<RolePermissions> roles = adminUsername.getRoles();

        List<GrantedAuthority> list = new ArrayList<>();

        // 添加角色权限
        for (RolePermissions role : roles) {
            list.add(new SimpleGrantedAuthority(role.getKeyWord()));
            // 添加角色具备的权限
            Set<Permission> permissions = role.getPermissions();
            for (Permission permission : permissions) {
                list.add(new SimpleGrantedAuthority(permission.getKeyWord()));
            }
        }

        /*
            username：用户名
            password：用户真实密码
            list：角色和权限集合
         */
        User securityUser = new User(username,adminUsername.getAdminPassword(),list);

        return securityUser;
    }
}
