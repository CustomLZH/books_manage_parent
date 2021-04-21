package com.guaiwuxue.entity;

import com.guaiwuxue.pojo.Permission;

import java.util.Set;

/**
 * @Author: LiuZhaoHong
 * @Date: 2021/4/21 9:36
 * @Version: 1.0
 */
public class RolePermissions extends Permission {

    /**
     * 权限
     */
    private Set<Permission> permissions;

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }
}
