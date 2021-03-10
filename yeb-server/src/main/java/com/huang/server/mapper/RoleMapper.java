package com.huang.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.server.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(Integer adminId);

}
