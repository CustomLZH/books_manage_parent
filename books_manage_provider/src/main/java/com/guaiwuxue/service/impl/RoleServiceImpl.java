package com.guaiwuxue.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guaiwuxue.dao.PermissionDao;
import com.guaiwuxue.dao.RoleDao;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.RolePermissions;
import com.guaiwuxue.pojo.Role;
import com.guaiwuxue.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @Author: LiuZhaoHong
 * @Date: 2021/4/20 18:16
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Set<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Set<RolePermissions> findByAdminId(Long adminId) {
        return roleDao.findByAdminId(adminId);
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //页码
        Integer currentPage = queryPageBean.getCurrentPage();
        //每页记录数
        Integer pageSize = queryPageBean.getPageSize();
        //查询条件
        String requirement = queryPageBean.getRequirement();
        //做判断,以防万一当前页面和每页显示的数量为负数
        if (currentPage==null || currentPage<1){
            currentPage = 1;
        }
        //保证页码正常
        if (pageSize==null || pageSize<1){
            pageSize = 8;
        }
        //保证每页显示记录正常
        if (requirement==null || "".equals(requirement.trim())){
            requirement = "";
        }else {
            //保证分页后回到第一页
            currentPage = 1;
        }

        PageHelper.startPage(currentPage,pageSize);
        Page<RolePermissions> page = roleDao.findPageByCondition("%" + requirement +"%");

        for (RolePermissions rolePermissions : page) {
            rolePermissions.setPermissions(permissionDao.findPermissionByRoleId(rolePermissions.getId()));
        }

        return new PageResult(page.getTotal(),page.getResult());
    }

    
    @Override
    public void delete(Long id) {
        this.roleDao.delete(id);
        // 删除角色对应的权限
        this.permissionDao.deleteByRoleId(id);
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }

    
    @Override
    public void createRole(RolePermissions rolePermissions) {
        roleDao.createRole(rolePermissions);
        if (rolePermissions.getPermissions() != null && rolePermissions.getPermissions().size() > 0) {
            permissionDao.insertAllPermission(rolePermissions.getId(), rolePermissions.getPermissions());
        }
    }

    
    @Override
    public void updateRole(RolePermissions rolePermissions) {
        this.roleDao.updateRole(rolePermissions);
        // 删除之前的角色
        permissionDao.deleteByRoleId(rolePermissions.getId());
        if (rolePermissions.getPermissions() != null && rolePermissions.getPermissions().size() > 0) {
            // 绑定角色
            permissionDao.insertAllPermission(rolePermissions.getId(), rolePermissions.getPermissions());
        }
    }


}
