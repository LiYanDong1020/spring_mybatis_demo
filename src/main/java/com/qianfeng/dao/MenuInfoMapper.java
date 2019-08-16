package com.qianfeng.dao;

import com.qianfeng.dto.ModifyRoleMenuDTO;
import com.qianfeng.pojo.MenuInfo;
import com.qianfeng.pojo.RoleMenu;
import com.qianfeng.pojo.UserInfo;
import com.qianfeng.vo.MenuInfoVO;

import java.util.List;

public interface MenuInfoMapper {


    public List<MenuInfo> listParentMenu();

    public List<MenuInfoVO> listMenuByRoleId(int roleId);

    public int editUserInfoById(UserInfo userInfo);

    public int removeRoleMenuByMenuId(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public List<RoleMenu> listRoleMenuByRoleId(ModifyRoleMenuDTO modifyRoleMenuDTO);

    public int addRoleMenuByRoleId(ModifyRoleMenuDTO modifyRoleMenuDTO);
}
