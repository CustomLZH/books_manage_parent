package com.guaiwuxue.service;

import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.pojo.Admin;

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
    public Admin findByUsername(String adminUsername);


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
     * @param admin
     */
    void createAdmin(Admin admin);

    /**
     * 更新管理员
     *
     * @param admin
     */
    void updateAdmin(Admin admin);

    PageResult findPage(QueryPageBean queryPageBean);
}
