package com.qianfeng.dao;

import com.qianfeng.dto.SearchUserInfoDTO;
import com.qianfeng.pojo.MenuInfo;
import com.qianfeng.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {

    public List<UserInfo> listAll(SearchUserInfoDTO searchUserInfoDTO);

     //public List<UserInfo> listAll();

    //boolean deleteUserById(int id);

    public UserInfo loginCheck(UserInfo userInfo);

    public int register(UserInfo userInfo);

    public int removeUserById(int userId);

    public UserInfo getUserInfoById(int userId);

    public int editUserInfoById(UserInfo userInfo);

    public List<MenuInfo> userLoginInit(UserInfo userInfo);
}

