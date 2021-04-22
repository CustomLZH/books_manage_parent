package com.guaiwuxue.entity;

import com.guaiwuxue.pojo.Permission;
import com.guaiwuxue.pojo.Role;

import java.util.Objects;
import java.util.Set;

/**
 * @Author: LiuZhaoHong
 * @Date: 2021/4/21 9:36
 * @Version: 1.0
 */
public class RolePermissions extends Role {

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

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
