package com.guaiwuxue.dao;

import com.github.pagehelper.Page;
import com.guaiwuxue.entity.RolePermissions;
import com.guaiwuxue.pojo.Admin;
import com.guaiwuxue.pojo.Permission;
import com.guaiwuxue.pojo.Role;
import com.guaiwuxue.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;
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
    public Set<RolePermissions> findByAdminId(Long adminId);
    /**
     * 根据管理员id查询相关角色
     * @param adminId
     * @return
     */
    public Set<RolePermissions> findRoleIdsByAdminId(Long adminId);

    /**
     * 查询所有角色
     * @return
     */
    public Set<Role> findAll();

    /**
     * 插入多条管理员与角色数据
     * @param adminId
     * @param roles
     */
    public void insertAllRole(@Param("adminId") long adminId, @Param("roles") Set<RolePermissions> roles);

    /**
     * 删除该管理员的所有权限
     * @param admin
     */
    void deleteByAdminId(Long admin);

    /**
     * 分页
     * @param requirement
     * @return
     */
    Page<RolePermissions> findPageByCondition(@Param("requirement") String requirement);

    /**
     * 删除角色
     * @param id
     */
    void delete(Long id);

    /**
     * 根据用户名查询角色
     * @param name
     * @return
     */
    Role findByName(String name);

    /**
     * 创建角色
     * @param rolePermissions
     */
    void createRole(RolePermissions rolePermissions);


    /**
     * 更新角色
     * @param rolePermissions
     */
    void updateRole(RolePermissions rolePermissions);

    /**
     * 根据管理员id删除角色绑定
     * @param multipleSelection
     */
    void deleteByAdminIdAll(@Param("multipleSelection") List<Admin> multipleSelection);

}
