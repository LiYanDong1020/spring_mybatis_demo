package com.qianfeng.controller;

import com.qianfeng.dto.SearchUserInfoDTO;
import com.qianfeng.pojo.MenuInfo;
import com.qianfeng.pojo.UserInfo;
import com.qianfeng.service.UserInfoService;
import com.qianfeng.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("test")
    @ResponseBody
    public boolean test(@RequestBody UserInfo userInfo, HttpSession httpSession) {
        UserInfo userInfo1 = userInfoService.loginCheck(userInfo);
        if (userInfo1 != null) {
            httpSession.setAttribute("userInfo", userInfo1);
            List<MenuInfo> menuInfoList = userInfoService.userLoginInit(userInfo);
            httpSession.setAttribute("menuInfoList", menuInfoList);
        } else {

        }

        return userInfo1 != null;
    }

    @RequestMapping("registerUserInfo")
    @ResponseBody
    public Object registerUserInfo(@RequestBody UserInfo userInfo) {
        boolean register = userInfoService.register(userInfo);
        return register;
    }

    @RequestMapping(value = "listAllUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public List<UserInfo> listAllUserInfo(@RequestBody SearchUserInfoDTO searchUserInfoDTO) {
        List<UserInfo> allUserInfo = userInfoService.getAllUserInfo(searchUserInfoDTO);
        return allUserInfo;
    }

    @RequestMapping("removeUserById")
    @ResponseBody
    public Object removeUserById(@RequestParam int userId) {
        return this.userInfoService.removeUserById(userId);
    }

    @RequestMapping("getUserInfoById")
    @ResponseBody
    public Object getUserInfoById(@RequestParam int userId) {
        return this.userInfoService.getUserInfoById(userId);
    }

    @RequestMapping("editUserInfoById")
    @ResponseBody
    public boolean editUserInfoById(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo);
        return this.userInfoService.editUserInfoById(userInfo);
    }

    @RequestMapping("/call/{checkWicket}-{checkNum}")
    @ResponseBody
    public Object call(@PathVariable("checkWicket") String checkWicket, @PathVariable("checkNum") String checkNum) {
        System.out.println(checkWicket + ":" + checkNum);
        return checkWicket + ":" + checkNum;
    }

    @RequestMapping("getCookieValue")
    @ResponseBody
    public Object getCookieValue(@CookieValue(value = "name") String name) {
        System.out.println(name);
        return name;
    }

    @RequestMapping("getHeader")
    @ResponseBody
    public Object getHeader(@RequestHeader(value = "Content-length") String host) {
        System.out.println(host);
        return host;
    }

    @RequestMapping("valadation")
    @ResponseBody
    public Object valadation(@Valid @RequestBody UserInfoVO userInfoVO, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            for (FieldError error : errorList) {
                System.out.println(error);
                modelMap.put(error.getObjectName(), error.toString());
            }
            return "验证失败";
        }
        return "验证成功";
    }

    @RequestMapping("test/paramEncode")
    @ResponseBody
    public Object paramEncode(String username) {
        System.out.println(username);
        return username;
    }

}