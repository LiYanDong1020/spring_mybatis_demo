package com.qianfeng.service.impl;

import com.qianfeng.dao.RoleInfoMapper;
import com.qianfeng.dto.UserRoleDTO;
import com.qianfeng.service.RoleInfoService;
import com.qianfeng.vo.RoleInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    RoleInfoMapper roleInfoMapper;


    public List<RoleInfoVO> listRoleByUserId(int userId) {
        return this.roleInfoMapper.listRoleByUserId(userId);
    }
    @Transactional
    public boolean addUserRole(UserRoleDTO userRoleDTO){
        return  this.roleInfoMapper.addUserRole(userRoleDTO)>0;
    }
    @Transactional
    public boolean removeUserRole(UserRoleDTO userRoleDTO){
        return  this.roleInfoMapper.removeUserRole(userRoleDTO)>0;
    }
}