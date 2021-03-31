package com.guaiwuxue.dao;

import com.guaiwuxue.pojo.Role;

import java.util.Set;

/**
 * @Author: Custom
 * @Date: 2020/7/25 11:34
 * @Version: 1.0
 */
public interface RoleDao {
    /**
     * 根据管理员id查询相关角色
     * @param adminId
     * @return
     */
    public Set<Role> findByAdminId(Long adminId);
}
