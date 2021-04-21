package com.guaiwuxue.service;

import com.guaiwuxue.pojo.Permission;

import java.util.Set;

/**
 * @Author: LiuZhaoHong
 * @Date: 2021/4/21 10:36
 * @Version: 1.0
 */
public interface PermissionService {

    /**
     * 查询所有权限
     * @return
     */
    Set<Permission> findAllPermission();
}
