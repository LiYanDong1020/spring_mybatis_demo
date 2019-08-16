package com.qianfeng.pojo;

import java.util.List;

public class RoleInfo {
    int roleId;
    String roleName;
    String shortName;

    List<MenuInfo> menuInfos;
    List<UserInfo> userInfoList;

    public int getRoleId() {
        return roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public String getShortName() {
        return shortName;
    }

    public List<MenuInfo> getMenuInfos() {
        return menuInfos;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    @Override
    public String toString() {
        return "RoleInfo{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", menuInfos=" + menuInfos +
                ", userInfoList=" + userInfoList +
                '}';
    }
}
