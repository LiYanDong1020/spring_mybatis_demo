package com.qianfeng.dto;

public class SearchUserInfoDTO {

    String userName;
    String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SearchUserInfoDTO{" +
                "username='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
