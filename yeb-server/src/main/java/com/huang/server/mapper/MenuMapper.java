package com.huang.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户id查询菜单列表
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);

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
