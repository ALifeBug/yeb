package com.huang.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.server.pojo.AdminRole;
import com.huang.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 更新操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);

}
