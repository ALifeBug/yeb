package com.huang.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.server.pojo.MenuRole;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    Integer insertRecord(Integer rid, Integer[] mids);
}
