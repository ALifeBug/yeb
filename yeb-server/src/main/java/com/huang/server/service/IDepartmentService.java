package com.huang.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.server.pojo.Department;
import com.huang.server.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();

    /**
     * 添加部门
     * @param dep
     * @return
     */
    RespBean addDep(Department dep);

    /**
     * 删除部门
     * @param id
     * @return
     */
    RespBean deleteDep(Integer id);
}
