package com.guaiwuxue.service.impl;

import com.guaiwuxue.dao.PermissionDao;
import com.guaiwuxue.pojo.Permission;
import com.guaiwuxue.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @Author: LiuZhaoHong
 * @Date: 2021/4/21 10:37
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true)
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;


    @Override
    public Set<Permission> findAllPermission() {
        return permissionDao.findAllPermission();
    }



}
