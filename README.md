# 云E办后端

## 项目介绍

云E办是一款前后端分离的办公后台管理系统。包括职位管理、职称管理、部门管理等常用功能。本项目是后端系统。仅用于个人学习使用。

## 主要功能

- 登录，预置了admin用户和密码

  [![6GWkt0.md.png](https://s3.ax1x.com/2021/03/10/6GWkt0.md.png)](https://imgtu.com/i/6GWkt0)

- 用户管理：使用系统的用户，主要是查看、禁用启用

  [![6GWVpT.md.png](https://s3.ax1x.com/2021/03/10/6GWVpT.md.png)](https://imgtu.com/i/6GWVpT)

- 职位管理

  [![6GWG9K.md.png](https://s3.ax1x.com/2021/03/10/6GWG9K.md.png)](https://imgtu.com/i/6GWG9K)

- 职称管理

  [![6GWKB9.md.png](https://s3.ax1x.com/2021/03/10/6GWKB9.md.png)](https://imgtu.com/i/6GWKB9)

- 部门管理

  [![6GWlA1.md.png](https://s3.ax1x.com/2021/03/10/6GWlA1.md.png)](https://imgtu.com/i/6GWlA1)

- 员工管理

  [![6GW1tx.md.png](https://s3.ax1x.com/2021/03/10/6GW1tx.md.png)](https://imgtu.com/i/6GW1tx)

- 工资账套管理(开发中...)

- 在线聊天(开发中...)

- 其他功能

## 技术使用

- 后台框架：SpringBoot、MybatisPlus
- 权限控制：SpringSecurity、Jwt
- 数据库:Mysql、Redis
- 文档工具:Swagger-UI
- 日志：Slf4J
- 项目构建：Maven
- 消息队列：RabbitMQ
- ...

### 前端

- Vue
- Vuex
- VueRouter
- ElementUI
- Axios
- ...

## 项目结构

- **yeb-generator**为代码生成模块，使用mybatis-plus一键生成mapper、service、controller等主要功能文件
- **yeb-server**为项目主体，包含了大部分管理功能
- **yeb-mail**为邮件发送模块，用于在添加新员工时发送邮件提示
- **yeb-web**为前端项目，点此查看：<https://github.com/ALifeBug/yeb-web>

