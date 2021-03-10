package com.huang.mail;

import com.huang.server.pojo.MailConstants;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SpringBootWebSecurityConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//因为引入了yeb-server依赖，所以自动加载数据库的配置类，需要去掉，否则报url找不到的异常
public class MailApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailApplication.class,args);
    }

    @Bean
    public Queue queue(){
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }
}
