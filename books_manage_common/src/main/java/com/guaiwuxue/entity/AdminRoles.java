package com.guaiwuxue.entity;

import com.guaiwuxue.pojo.Admin;
import com.guaiwuxue.pojo.Role;

import java.util.Set;

/**
 * @Author: LiuZhaoHong
 * @Date: 2021/4/20 20:12
 * @Version: 1.0
 */
public class AdminRoles extends Admin {

    /**
     * 角色
     */
    Set<RolePermissions> roles;

    public Set<RolePermissions> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolePermissions> roles) {
        this.roles = roles;
    }
}
