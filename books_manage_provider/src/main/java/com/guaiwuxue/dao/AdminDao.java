package com.guaiwuxue.dao;

import com.guaiwuxue.pojo.Admin;

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
}
