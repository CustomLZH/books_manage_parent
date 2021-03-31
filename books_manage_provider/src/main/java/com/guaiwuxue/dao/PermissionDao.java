package com.guaiwuxue.dao;

import com.guaiwuxue.pojo.Permission;

import java.util.Set;

/**
 * @Author: Custom
 * @Date: 2020/7/25 11:49
 * @Version: 1.0
 */
public interface PermissionDao {
    /**
     * 根据角色id查询相关权限
     * @param id
     * @return
     */
    public Set<Permission> findByRoleId(Long id);
}
