package com.huang.server.config.component;

import com.huang.server.pojo.Admin;
import com.huang.server.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IAdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = adminService.getAdminByUserName(username);
        if(admin != null){
            admin.setRoles(adminService.getRoles(admin.getId()));
            return admin;
        }
        return admin;
    }
}
