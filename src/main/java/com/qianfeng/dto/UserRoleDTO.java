package com.qianfeng.dto;

public class UserRoleDTO {

    int roleId;
    int userId;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "InsertUserRoleDTO{" +
                "roleId=" + roleId +
                ", userId=" + userId +
                '}';
    }
}
