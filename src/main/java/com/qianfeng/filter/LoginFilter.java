package com.qianfeng.filter;


import com.qianfeng.pojo.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements HandlerInterceptor {
    //前置方法
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //获取session
        HttpSession session = httpServletRequest.getSession();
        UserInfo userinfo = (UserInfo)session.getAttribute("userInfo");
        if(userinfo==null){
            //httpServletRequest.getRequestDispatcher().forward();
            String requestURI = httpServletRequest.getRequestURI();
            if(requestURI.equals("/test")||requestURI.equals("/registerUserInfo")
                    ||requestURI.equals("/login.html")||requestURI.equals("/reg.html")){
                return true;
            }
        }else{
                return true;
        }
        return false;
    }
    //执行方法
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    //后置方法
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
