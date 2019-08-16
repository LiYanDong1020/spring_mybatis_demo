package com.qianfeng.toolkit;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5 {

    public static String encondPassword(String pwd){

        String str = DigestUtils.md5Hex(pwd);
        for(int i =0;i<10;i++){
            str = DigestUtils.md5Hex(str.substring(15));
        }
        System.out.println(str);
        return str;
    }
}
