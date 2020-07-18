package com.guaiwuxue.pojo;

/**
 * 管理员实体类
 * @Author: Custom
 * @Date: 2020/7/10 22:37
 * @Version: 1.0
 */
public class Admin {

    /**
     * 管理员id
     */
    private Integer adminId;
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

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
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
}
