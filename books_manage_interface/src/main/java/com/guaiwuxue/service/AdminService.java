package com.guaiwuxue.service;

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
}
