package com.huang.server.utils;

import com.huang.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

public class AdminUtils {

    /**
     * 获取当前登录操作员
     * @return
     */
    public static Admin getCurrentAdmin(){
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
