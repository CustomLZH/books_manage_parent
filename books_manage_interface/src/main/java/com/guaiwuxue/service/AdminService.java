package com.guaiwuxue.service;

import com.guaiwuxue.entity.AdminRoles;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.Admin;

import java.util.List;

/**
 * 关于管理员的接口
 * @Author: Custom
 * @Date: 2020/7/25 11:01
 * @Version: 1.0
 */
public interface AdminService {
    /**
     * 按照用户名查找
     * @param adminUsername
     * @return
     */
    public AdminRoles findByUsername(String adminUsername);

    /**
     * 查找所有管理员
     * @return
     */
    public List<AdminRoles> findAll();


    /**
     * 按照用户名查找并排除密码
     * @param adminUsername
     * @return
     */
    public Admin findByUsernameExcludePasswords(String adminUsername);



    /**
     * 按照管理员id删除
     * @param admin
     */
    void delete(Long admin);

    /**
     * 创建管理员
     * @param adminRoles
     */
    void createAdmin(AdminRoles adminRoles);

    /**
     * 更新管理员
     *
     * @param adminRoles
     */
    void updateAdmin(AdminRoles adminRoles);

    /**
     * 分页
     * @param queryPageBean
     * @return
     */
    PageResult findPage(QueryPageBean queryPageBean);

    /**
     * 重置
     */
    void reset();
}
