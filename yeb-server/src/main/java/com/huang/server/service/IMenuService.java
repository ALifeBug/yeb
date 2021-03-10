package com.huang.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据用户ID查询菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色获取菜单列表
     * @return
     */
    List<Menu> getMenusWithRole();

    /**
     * 查询所有菜单
     * @return
     */
    List<Menu> getAllMenus();
}
