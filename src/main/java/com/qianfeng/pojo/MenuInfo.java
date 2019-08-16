package com.qianfeng.pojo;

import java.util.List;

public class MenuInfo {

    int mid;
    String menuName;
    String menuIcon;
    String mentUrl;
    int parentid;
    List<MenuInfo> chileMenuList;
    List<UserInfo> userInfoList;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getMentUrl() {
        return mentUrl;
    }

    public void setMentUrl(String mentUrl) {
        this.mentUrl = mentUrl;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public List<MenuInfo> getChileMenuList() {
        return chileMenuList;
    }

    public void setChileMenuList(List<MenuInfo> chileMenuList) {
        this.chileMenuList = chileMenuList;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "mid=" + mid +
                ", menuName='" + menuName + '\'' +
                ", menuIcon='" + menuIcon + '\'' +
                ", mentUrl='" + mentUrl + '\'' +
                ", parentid=" + parentid +
                ", chileMenuList=" + chileMenuList +
                ", userInfoList=" + userInfoList +
                '}';
    }
}
