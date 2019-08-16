package com.qianfeng.controller;

import com.qianfeng.dto.UserRoleDTO;
import com.qianfeng.service.MenuInfoService;
import com.qianfeng.service.RoleInfoService;
import com.qianfeng.vo.MenuInfoVO;
import com.qianfeng.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2019/8/1.
 */
@RestController
public class RoleInfoController {

    @Autowired
    RoleInfoService roleInfoService;
    @Autowired
    MenuInfoService menuInfoService;

    @RequestMapping("listRoleByUserId")
    public Object listRoleByUserId(@RequestParam int userId){
        return this.roleInfoService.listRoleByUserId(userId);
    }

    @RequestMapping("insertUserRole")
    public Object insertUserRole(@RequestBody UserRoleDTO userRoleDTO){
        System.out.println(userRoleDTO);
        return roleInfoService.addUserRole(userRoleDTO);
    }

    @RequestMapping("removeUserRole")
    public Object removeUserRole(@RequestBody UserRoleDTO userRoleDTO){
        System.out.println(userRoleDTO);
        return roleInfoService.removeUserRole(userRoleDTO);
    }

    @RequestMapping("listMenuByRoleId")
    public Object listMenuByRoleId(@RequestParam int roleId) {
        return menuInfoService.listMenuByRoleId(roleId);
    }
}
