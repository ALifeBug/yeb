package com.huang.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.huang.server.mapper.EmployeeMapper;
import com.huang.server.mapper.MailLogMapper;
import com.huang.server.pojo.*;
import com.huang.server.service.IEmployeeService;
import com.huang.server.utils.AddStringUtils;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author huang
 * @since 2021-03-03
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MailLogMapper mailLogMapper;

    @Override
    public RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope) {
        Page<Employee> page = new Page<>(currentPage,size);
        IPage<Employee> employeeByPage = employeeMapper.getEmployeeByPage(page, employee, beginDateScope);
        RespPageBean respPageBean = new RespPageBean(employeeByPage.getTotal(),employeeByPage.getRecords());
        return respPageBean;
    }

    @Override
    public RespBean addEmp(Employee employee) {
        //处理合同期限，保留两位小数
        LocalDate beginContract = employee.getBeginContract();
        LocalDate endContract = employee.getEndContract();
        long days = beginContract.until(endContract, ChronoUnit.DAYS);
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(days/365.00)));
        if(1==employeeMapper.insert(employee)){

            //插入完成后会返回ID
            Employee emp = employeeMapper.getEmployee(employee.getId()).get(0);

            //数据库记录发送的消息
            //String msgId = UUID.randomUUID().toString();
            String msgId = "123456";
            MailLog mailLog = new MailLog();
            mailLog.setMsgId(msgId);
            mailLog.setEid(employee.getId());
            mailLog.setStatus(0);
            mailLog.setRouteKey(MailConstants.MAIL_ROUTING_KEY_NAME);
            mailLog.setExchange(MailConstants.MAIL_EXCHANGE_NAME);
            mailLog.setCount(0);
            mailLog.setTryTime(LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT));
            mailLog.setCreateTime(LocalDateTime.now());
            mailLog.setUpdateTime(LocalDateTime.now());
            mailLogMapper.insert(mailLog);

            //发送rabbitmq消息
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME,MailConstants.MAIL_ROUTING_KEY_NAME,emp,new CorrelationData(msgId));
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @Override
    public RespBean getMaxWorkID() {
        RespBean respBean = new RespBean();
        String wordID = AddStringUtils.addOne(employeeMapper.selectMaxWorkId());
        respBean.setObj(wordID);
        respBean.setCode(200);
        return respBean;
    }

    @Override
    public List<Employee> getEmployee(Integer id) {
        return employeeMapper.getEmployee(id);
    }

    @Override
    public RespPageBean getEmployeeWithSalary(Integer currentPage, Integer size) {
        Page<Employee> page = new Page<>(currentPage,size);
        IPage<Employee> employeeIPage = employeeMapper.getEmployeeWithSalary(page);
        RespPageBean respPageBean = new RespPageBean(employeeIPage.getTotal(),employeeIPage.getRecords());
        return respPageBean;
    }
}
