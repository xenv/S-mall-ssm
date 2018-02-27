# 小小商城系统  - SSM版

练手JavaWEB项目，本版本为SSM版（完整版）。本项目实现了通用 Mapper，免写 SQL，全自动处理关联查询。通过拦截器实现了方法级粒度的鉴权，通过AOP实现了参数校验。通过合理配置 MyBatis Generator 和自定义插件，灵活隔离手写代码和自动生成代码。实现了 BaseService 类对 Service 层进行抽象。

---------------------------

**演示**：[http://small.ડ.com/][1]  
可自行注册账号，或使用后台查看权限账号 demo 密码 demo （后台入口登陆后显示）  

兄弟项目：  
[SSH版（实现了SSM版95%功能）][3]  
[Servlet版（实现了SSM版85%功能）][2]  

----------------------------

本项目的亮点：

 * 功能齐全，页面丰富，实现了小商城的大部分功能
 * 前端仿天猫2017页面，基于原生 CSS（前台）、Bootstrap（后台）、Jquery、Bootstrap Js 构建
 * 本项目为 Maven 项目，后端使用 Spring 4 + SpringMVC 4 + Mybatis 3.4 + aspectj 1.8
 * 实现了一个**通用mapper**，免写 SQL，可进行单表和多表关联查询，自动插入一对多/多对一对象（注解配置关联对象，结合 MyBatis Generator ）
 * 实现了一个 BaseService 类，集成了多条件的查询和增改删操作，普通 Service 只需写少量代码即可
 * 完全隔离 MyBatis Generator 生成代码和额外手写代码，以支持可持续化部署，实现了多个MyBatis Generator插件，全部采用软删除
 * 通过拦截器和自定义注解实现了方法级粒度的用户鉴权，不同用户组权限完全隔离
 * 通过 参数注解 进行方法级数据校验，无需额外配置校验类 （通过 AOP 切面实现）
 * 统一的错误处理
  
功能： 

 - [x] 首页、分类页、搜索页、产品页
 - [x] 购物车页面、下单页、支付页及支付成功页
 - [x] 我的订单页、确认收货及成功页、评价页
 - [x] 登陆页、注册页
 - [x] 全部数据库的后台可视化管理
 - [x] 网站SEO设置、图片路径设置

------------------
 
 安装使用：
 
  1. 若使用IDE打开，需按 Maven 文件安装依赖
  2. 若在Tomcat中部署，Maven文件中已经配置好直接在线部署，使用 maven tomcat7:deploy 可直接在线部署 （需先配置好Tomcat）
  3. 导入数据库small.sql，在 \src\main\resources\jdbc.properties 中配置数据库
  4. 默认后台地址 /admin ，账户密码为 admin 123456 ，新建用户在前台注册，需要后台权限需要在数据库的User表的group_列中将该用户的用户组设置为 superAdmin
  5. JDK >= 1.8、数据库 Mysql


  [1]: http://small.ડ.com
  [2]: https://github.com/xenv/S-mall-servlet
  [3]: https://github.com/xenv/S-mall-ssh