package com.qianfeng.service;

import com.qianfeng.dto.SearchUserInfoDTO;
import com.qianfeng.dto.UserRoleDTO;
import com.qianfeng.pojo.MenuInfo;
import com.qianfeng.pojo.UserInfo;

import java.util.List;
import java.util.Map;

public interface UserInfoService  {

    //public List<UserInfo> listAll2();

      public UserInfo loginCheck(UserInfo userInfo);

      public boolean register(UserInfo userInfo);

      public List<UserInfo> getAllUserInfo(SearchUserInfoDTO searchUserInfoDTO);

      public boolean removeUserById(int userId);

      public UserInfo getUserInfoById(int userId);

      public boolean editUserInfoById(UserInfo userInfo);

      public List<MenuInfo> userLoginInit(UserInfo userInfo);


}
