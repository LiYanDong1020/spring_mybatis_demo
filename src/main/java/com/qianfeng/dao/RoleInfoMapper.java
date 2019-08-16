package com.qianfeng.dao;

import com.qianfeng.dto.UserRoleDTO;
import com.qianfeng.pojo.RoleInfo;
import com.qianfeng.vo.RoleInfoVO;

import java.util.List;

public interface RoleInfoMapper {

    public List<RoleInfo> getAllUserInfo();

    public List<RoleInfoVO> listRoleByUserId(int userId);

    public int addUserRole(UserRoleDTO userRoleDTO);

    public int removeUserRole(UserRoleDTO userRoleDTO);

}
