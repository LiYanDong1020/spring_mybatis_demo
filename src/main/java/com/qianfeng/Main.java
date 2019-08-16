package com.qianfeng;

import com.qianfeng.pojo.UserInfo;
import com.qianfeng.service.UserInfoService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DELL on 2019/7/29.
 */
public class Main {

       /* @Test
        public void register(){
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
            UserInfoService bean = context.getBean(UserInfoService.class);
            Map<String,String> map = new HashMap<String, String>();
            map.put("username","李彦东");
            map.put("password","123456");
            UserInfo userInfo = bean.register(map);
            if (userInfo!=null){
                System.out.println("登录成功"+userInfo);
            }else {
                System.out.println("用户名密码不正确");
            }
        }
        @Test
        public void adduser(){
            ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
            UserInfoService bean = context.getBean(UserInfoService.class);
            Map<String,String> map = new HashMap<String, String>();
            map.put("username","张三");
            map.put("password","123456");
            boolean b = bean.adduser(map);
            if(b){
                System.out.println("ok,注册成功");
            }else{
                System.out.println("fk,注册失败");
            }
        }



        *//*List<UserInfo> userInfos = bean.listAll2();
        System.out.println(userInfos);*//*
        *//*boolean b = bean.deleteUserById(2);
        System.out.println(b);*/
    }

