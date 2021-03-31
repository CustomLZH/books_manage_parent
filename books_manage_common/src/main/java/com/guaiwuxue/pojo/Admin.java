package com.guaiwuxue.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 管理员实体类
 * @Author: Custom
 * @Date: 2020/7/10 22:37
 * @Version: 1.0
 */
public class Admin implements Serializable {

    /**
     * 管理员id
     */
    private Long adminId;
    /**
     * 管理员用户名
     */
    private String adminUsername;
    /**
     * 管理员密码
     */
    private String adminPassword;
    /**
     * 管理员等级
     */
    private Integer adminGrade;
    /**
     * 管理员状态
     */
    private Integer adminState;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 拥有的角色
     */
    private Set<Role> roles = new HashSet<>();

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

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public Integer getAdminGrade() {
        return adminGrade;
    }

    public void setAdminGrade(Integer adminGrade) {
        this.adminGrade = adminGrade;
    }

    public Integer getAdminState() {
        return adminState;
    }

    public void setAdminState(Integer adminState) {
        this.adminState = adminState;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
