package com.huang.service.impl;

import com.huang.pojo.Role;
import com.huang.mapper.RoleMapper;
import com.huang.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-03-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
