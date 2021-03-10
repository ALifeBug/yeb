package com.huang.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.huang.server.pojo.Admin;
import com.huang.server.pojo.Menu;
import com.huang.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 获取所有操作员
     * @param id
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(Integer id, String keywords);

}
