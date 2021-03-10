package com.huang.server.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.huang.server.pojo.Employee;
import com.huang.server.pojo.MailConstants;
import com.huang.server.pojo.MailLog;
import com.huang.server.service.IEmployeeEcService;
import com.huang.server.service.IEmployeeService;
import com.huang.server.service.IMailLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 邮件发送定时任务
 */
@Component
public class MailTask {

    @Autowired
    private IMailLogService mailLogService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    /*
    10s执行一次
     */
   // @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask(){
        List<MailLog> list = mailLogService.list(new QueryWrapper<MailLog>().eq("status", 0).lt("try_time", LocalDateTime.now()));
        list.forEach(mailLog -> {
            //重试次数大于3，更新状态为投递失败，不再重试
            if(3<=mailLog.getCount()){
                mailLogService.update(new UpdateWrapper<MailLog>().set("status",2).eq("msg_id",mailLog.getMsgId()));
            }
            mailLogService.update(new UpdateWrapper<MailLog>()
                    .set("count",mailLog.getCount()+1)
                    .set("update_time",LocalDateTime.now())
                    .set("try_time",LocalDateTime.now().plusMinutes(MailConstants.MSG_TIMEOUT)).eq("msg_id",mailLog.getMsgId()));
            //获取员工进行重发
            Employee employee = employeeService.getEmployee(mailLog.getEid()).get(0);
            //重发消息
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME,
                    MailConstants.MAIL_ROUTING_KEY_NAME,
                    employee,
                    new CorrelationData(mailLog.getMsgId()));
        });
    }


}
