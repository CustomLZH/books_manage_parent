package com.guaiwuxue.dao;

import com.github.pagehelper.Page;
import com.guaiwuxue.entity.AdminRoles;
import com.guaiwuxue.pojo.Admin;
import com.guaiwuxue.pojo.Users;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Custom
 * @Date: 2020/7/25 11:05
 * @Version: 1.0
 */
public interface AdminDao {
    /**
     * 根据用户名称查询
     * @param adminUsername
     * @return
     */
    public Admin findByUsername(String adminUsername);

    /**
     * 根据管理员id删除
     * @param admin
     */
    void delete(Long admin);

    /**
     * 创建管理员
     *
     * @param adminRoles
     */
    void createAdmin(AdminRoles adminRoles);

    /**
     * 更新管理员
     * @param admin
     */
    void updateAdmin(Admin admin);

    /**
     * 分页查询
     *
     * @param requirement
     * @return
     */
    Page<AdminRoles> findPageByCondition(@Param("requirement") String requirement);
}
