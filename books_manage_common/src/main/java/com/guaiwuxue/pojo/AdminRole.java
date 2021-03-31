package com.guaiwuxue.pojo;

import java.util.Date;

/**
 * 用户与角色
 * @Author: liuzhaohong
 * @Date: 2021/3/31 22:10
 * @Version: 1.0
 */
public class AdminRole {
    /**
     * 用户id
     */
    private Long adminId;
    /**
     * 角色id
     */
    private Long roleId;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 创建时间
     */
    private Date createDate;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
