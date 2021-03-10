package com.huang.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.server.mapper.SalaryMapper;
import com.huang.server.pojo.Salary;
import com.huang.server.service.ISalaryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryMapper, Salary> implements ISalaryService {

}
