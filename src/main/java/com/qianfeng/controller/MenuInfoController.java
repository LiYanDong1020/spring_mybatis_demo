package com.qianfeng.controller;

import com.qianfeng.dto.ModifyRoleMenuDTO;
import com.qianfeng.service.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DELL on 2019/8/2.
 */
@RestController
@RequestMapping("/menuinfo")
public class MenuInfoController {

    @Autowired
    MenuInfoService menuInfoService;

    @RequestMapping("/listMenuByRoleId")
    public Object listMenuByRoleId(@RequestParam int roleId){
        return menuInfoService.listMenuByRoleId(roleId);
    }

    @RequestMapping("/modifyRoleMenu")
    public Object modifyRoleMenu(@RequestBody ModifyRoleMenuDTO modifyRoleMenuDTO){
        System.out.println(modifyRoleMenuDTO);
        return menuInfoService.updateRoleMenu(modifyRoleMenuDTO);
//        return menuInfoService.listMenuByRoleId(roleId);
    }
}
