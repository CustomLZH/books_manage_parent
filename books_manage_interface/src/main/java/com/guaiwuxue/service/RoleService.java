package com.guaiwuxue.service;

import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.RolePermissions;
import com.guaiwuxue.pojo.Role;

import java.util.Set;

/**
 * @Author: Custom
 * @Date: 2020/7/25 11:27
 * @Version: 1.0
 */
public interface RoleService {

    /**
     * 查询所有角色
     * @return
     */
    public Set<Role> findAll();

    /**
     * 查询指定用户的角色
     * @param adminId
     * @return
     */
    public Set<RolePermissions> findByAdminId(Long adminId);

    /**
     * 分页
     * @param queryPageBean
     * @return
     */
    PageResult findPage(QueryPageBean queryPageBean);


    /**
     * 删除角色
     * @param id
     */
    void delete(Long id);

    /**
     * 根据角色名查询角色
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
}
