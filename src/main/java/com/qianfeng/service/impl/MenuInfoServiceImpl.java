package com.qianfeng.service.impl;

import com.qianfeng.dao.MenuInfoMapper;
import com.qianfeng.dto.ModifyRoleMenuDTO;
import com.qianfeng.pojo.RoleMenu;
import com.qianfeng.service.MenuInfoService;
import com.qianfeng.vo.MenuInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by DELL on 2019/8/2.
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService{

    @Autowired
    MenuInfoMapper menuInfoMapper;

    public List<MenuInfoVO> listMenuByRoleId(int roleId) {
        return menuInfoMapper.listMenuByRoleId(roleId);
    }

    @Transactional
    public boolean updateRoleMenu(ModifyRoleMenuDTO modifyRoleMenuDTO) {
        boolean flag = false;
        int count1 = menuInfoMapper.removeRoleMenuByMenuId(modifyRoleMenuDTO);
        List<RoleMenu> roleMenus = menuInfoMapper.listRoleMenuByRoleId(modifyRoleMenuDTO);
        if(roleMenus.size()==0){
            return true;
        }
        HashMap<Integer,Integer> params = new HashMap<Integer, Integer>();

        for(int i=0;i<modifyRoleMenuDTO.getMenuIds().size();i++){
            params.put(modifyRoleMenuDTO.getMenuIds().get(i),modifyRoleMenuDTO.getRoleId());
        }

        for(int i=0;i<roleMenus.size();i++){
            params.remove(roleMenus.get(i).getMid());
        }

        List<Integer> menuIds = new ArrayList<Integer>(params.keySet());
        if(menuIds==null||menuIds.size()==0){
            return false;
        }
        modifyRoleMenuDTO.setMenuIds(menuIds);
        System.out.println("差值集合为"+modifyRoleMenuDTO.getMenuIds());
        //4将差集中的数据保存到数据库(3)
        int count2 = menuInfoMapper.addRoleMenuByRoleId(modifyRoleMenuDTO);
        //5.统一提交
        if(count1>0||count2>0){
            flag = true;
        }
        return flag;
    }

}
