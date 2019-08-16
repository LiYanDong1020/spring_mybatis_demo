package com.qianfeng.service.impl;

import com.qianfeng.dao.UserInfoMapper;
import com.qianfeng.dto.SearchUserInfoDTO;
import com.qianfeng.pojo.MenuInfo;
import com.qianfeng.pojo.UserInfo;
import com.qianfeng.service.UserInfoService;
import com.qianfeng.toolkit.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;


    public UserInfo loginCheck(UserInfo userInfo) {
        String pwd = Md5.encondPassword(userInfo.getPassword());
        userInfo.setPassword(pwd);
        UserInfo userInfo1 = userInfoMapper.loginCheck(userInfo);
        return userInfo1;
    }

    public boolean register(UserInfo userInfo) {
        String pwd = Md5.encondPassword(userInfo.getPassword());
        userInfo.setPassword(pwd);
        int register = userInfoMapper.register(userInfo);
        return register>0;

    }

    public List<UserInfo> getAllUserInfo(SearchUserInfoDTO searchUserInfoDTO) {
        List<UserInfo> allUserInfo = userInfoMapper.listAll(searchUserInfoDTO);
        return allUserInfo;

    }

    public boolean removeUserById(int userId) {
        return this.userInfoMapper.removeUserById(userId)>0;
    }

    public UserInfo getUserInfoById(int userId) {
        return this.userInfoMapper.getUserInfoById(userId);
    }

    public boolean editUserInfoById(UserInfo userInfo){
        return this.userInfoMapper.editUserInfoById(userInfo)>0;
    }

    public List<MenuInfo> userLoginInit(UserInfo userInfo) {
        return this.userInfoMapper.userLoginInit(userInfo);
    }
}