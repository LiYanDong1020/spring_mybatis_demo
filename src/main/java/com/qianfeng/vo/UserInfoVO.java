package com.qianfeng.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class UserInfoVO implements Serializable {
    @Length(min = 8,max = 20, message = "用户名不合法")
    String userName;
    @Length(min = 8,max = 20, message = "密码名不合法")
    String password;
    @NotBlank(message = "用户名不能为空或空字符串")
    String accountName;
    @Email(message = "邮箱格式不正确")
    String email;
    @Pattern(regexp="^1[3-9]\\d{9}$",message = "手机号码不合法")
    String mobile;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "UserInfoVO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", accountName='" + accountName + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
