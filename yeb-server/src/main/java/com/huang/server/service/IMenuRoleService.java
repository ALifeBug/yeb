package com.huang.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.server.pojo.MenuRole;
import com.huang.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);

}
