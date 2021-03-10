package com.huang.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.huang.server.pojo.Employee;
import com.huang.server.pojo.RespBean;
import com.huang.server.pojo.RespPageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 获取所有员工
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    RespBean addEmp(Employee employee);

    /**
     * 最大工号
     * @return
     */
    RespBean getMaxWorkID();

    /**
     * 查询员工
     * @param id
     * @return
     */
    List<Employee> getEmployee(Integer id);

    /**
     * 获取所有员工账套
     * @param currentPage
     * @param size
     * @return
     */
    RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size);
}
