package com.mszlu.blog.admin.service;

import com.mszlu.blog.admin.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;

@Component

public class SecurityUserService implements UserDetailsService {

    @Autowired
    private AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //当登录的时候将username传递到这里
        //通过username查询admin表，如果存在，密码
        //不存在，返回null 认证失败
        Admin admin = this.adminService.findAdminByUserName(username);
        if(admin == null){
            //登录失败
            return null;
        }
        UserDetails userDetails = new User(username,admin.getPassword(),new ArrayList<>());
        return userDetails;
    }
}
