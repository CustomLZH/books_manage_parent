package com.guaiwuxue.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.guaiwuxue.dao.AdminDao;
import com.guaiwuxue.dao.PermissionDao;
import com.guaiwuxue.dao.RoleDao;
import com.guaiwuxue.entity.AdminRoles;
import com.guaiwuxue.entity.PageResult;
import com.guaiwuxue.entity.QueryPageBean;
import com.guaiwuxue.entity.RolePermissions;
import com.guaiwuxue.pojo.Admin;
import com.guaiwuxue.pojo.Permission;
import com.guaiwuxue.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @Author: Custom
 * @Date: 2020/7/25 11:03
 * @Version: 1.0
 */
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {



    @Autowired
    private AdminDao adminDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public AdminRoles findByUsername(String adminUsername) {
        // 获取用户基本信息
        AdminRoles adminRoles = adminDao.findByUsername(adminUsername);
        if (adminRoles == null) {
            return null;
        }
        // 获取与管理员相关的角色
        Set<RolePermissions> roles = roleDao.findByAdminId(adminRoles.getAdminId());

        // 对角色的权限进行封装
        for (RolePermissions role : roles) {
            Set<Permission> permissions = permissionDao.findByRoleId(role.getId());
            role.setPermissions(permissions);
        }
        // 对管理员的角色进行封装
        adminRoles.setRoles(roles);

        return adminRoles;
    }

    @Override
    public List<AdminRoles> findAll() {
        return adminDao.findAll();
    }

    @Override
    public Admin findByUsernameExcludePasswords(String adminUsername) {
        // 获取用户基本信息
        Admin admin = adminDao.findByUsername(adminUsername);
        admin.setAdminPassword(null);
        return admin;
    }

    
    @Override
    public void delete(Long admin) {
        this.adminDao.delete(admin);
        this.roleDao.deleteByAdminId(admin);
    }

    
    @Override
    public void createAdmin(AdminRoles adminRoles) {
        this.encoderPassword(adminRoles);
        this.adminDao.createAdmin(adminRoles);
        if (adminRoles.getRoles() != null && adminRoles.getRoles().size() > 0) {
            // 绑定角色
            roleDao.insertAllRole(adminRoles.getAdminId(), adminRoles.getRoles());
        }
    }

    /**
     * 密码加密
     * @param admin
     */
    public void encoderPassword(Admin admin) {
        admin.setAdminPassword(this.bCryptPasswordEncoder.encode(admin.getAdminPassword()));
    }

    /**
     * 获取盐值
     * @param len
     * @return
     */
    public String getSalt(int len) {
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb=new StringBuffer();
        for(int i = 0;i < len; i++){
            int number=random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 更新
     * @param adminRoles
     */
    
    @Override
    public void updateAdmin(AdminRoles adminRoles) {
        if (adminRoles.getAdminPassword() != null) {
            this.encoderPassword(adminRoles);
        }
        this.adminDao.updateAdmin(adminRoles);
        // 删除之前的角色
        roleDao.deleteByAdminId(adminRoles.getAdminId());
        if (adminRoles.getRoles() != null && adminRoles.getRoles().size() > 0) {
            // 绑定角色
            roleDao.insertAllRole(adminRoles.getAdminId(), adminRoles.getRoles());
        }
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
        Page<AdminRoles> page = adminDao.findPageByCondition("%" + requirement +"%");

        for (AdminRoles adminRoles : page) {
            adminRoles.setRoles(roleDao.findRoleIdsByAdminId(adminRoles.getAdminId()));
        }

        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void reset() {
        // TODO:实现第一次进入创建固定的管理员账号：admin 密码：admin

    }

    @Override
    public void deleteAll(List<Admin> multipleSelection) {
        adminDao.deleteAll(multipleSelection);
        roleDao.deleteByAdminIdAll(multipleSelection);
    }
}
