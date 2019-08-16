package com.qianfeng.service;

import com.qianfeng.dto.ModifyRoleMenuDTO;
import com.qianfeng.vo.MenuInfoVO;

import java.util.List;

/**
 * Created by DELL on 2019/8/2.
 */
public interface MenuInfoService {

    public List<MenuInfoVO> listMenuByRoleId(int roleId);

    public boolean updateRoleMenu(ModifyRoleMenuDTO modifyRoleMenuDTO);
}
