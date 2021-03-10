package com.huang.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.server.utils.AdminUtils;
import com.huang.server.config.component.JwtTokenUtil;
import com.huang.server.mapper.AdminMapper;
import com.huang.server.mapper.AdminRoleMapper;
import com.huang.server.mapper.RoleMapper;
import com.huang.server.pojo.Admin;
import com.huang.server.pojo.AdminRole;
import com.huang.server.pojo.RespBean;
import com.huang.server.pojo.Role;
import com.huang.server.service.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private AdminRoleMapper adminRoleMapper;


    @Override
    public RespBean login(String username, String password, String code, HttpServletRequest request) {
        String captcha = (String) request.getSession().getAttribute("captcha");
        if(StringUtils.isEmpty(code)||!captcha.equalsIgnoreCase(code)){
            return RespBean.error("验证码输入错误，请重新输入");
        }
        //登录
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        log.info("password:"+password+"\n"+userDetails.getPassword());
        if(null==userDetails||!passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名或密码不正确");
        }
        if(!userDetails.isEnabled()){
            return RespBean.error("账户被禁用，请联系管理员!");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtTokenUtil.generatorToken(userDetails);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登录成功",tokenMap);
    }

    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",username));
    }

    @Override
    public List<Role> getRoles(Integer adminId) {
        return roleMapper.getRoles(adminId);
    }

    @Override
    public List<Admin> getAllAdmins(String keywords) {
        return adminMapper.getAllAdmins(AdminUtils.getCurrentAdmin().getId(),keywords);
    }

    @Override
    @Transactional
    public RespBean updateAdminRole(Integer adminId, Integer[] rids) {
        //先删除
        adminRoleMapper.delete(new QueryWrapper<AdminRole>().eq("admin_id",adminId));
        //再插入新的
        Integer result =  adminRoleMapper.addAdminRole(adminId,rids);
        if(rids.length == result){
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @Override
    public RespBean updateAdminPassword(String oldPass, String pass, Integer adminId) {
        Admin admin = adminMapper.selectById(adminId);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //判断旧密码是否正确
        if(encoder.matches(oldPass,admin.getPassword())){
            admin.setPassword(encoder.encode(pass));
            int result = adminMapper.updateById(admin);
            if(1==result){
                return RespBean.success("更新成功");
            }
        }
        return RespBean.error("更新失败");
    }

    @Override
    public RespBean updateAdminUserFace(String url, Integer id, Authentication authentication) {
        Admin admin = adminMapper.selectById(id);
        admin.setUserFace(url);
        int result = adminMapper.updateById(admin);
        if(1==result){
            Admin principal = (Admin) authentication.getPrincipal();
            principal.setUserFace(url);
            SecurityContextHolder.getContext()
                    .setAuthentication(new UsernamePasswordAuthenticationToken(admin,null,authentication.getAuthorities()));
            return RespBean.success("更新成功",url);
        }
        return RespBean.error("更新失败");
    }


}
