package com.guaiwuxue.dao;

import com.guaiwuxue.pojo.Permission;
import org.apache.ibatis.annotations.Param;

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


    /**
     * 绑定权限
     * @param id
     * @param permissions
     */
    void insertAllPermission(@Param("id") Long id, @Param("permissions") Set<Permission> permissions);


    /**
     * 删除角色对应的权限
     * @param id
     */
    void deleteByRoleId(Long id);


    /**
     * 查询所有权限
     * @return
     */
    Set<Permission> findAllPermission();


    /**
     * 根据角色id查询相关权限
     * @param roleId
     * @return
     */
    public Set<Permission> findPermissionByRoleId(Long roleId);

}
