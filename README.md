## 项目介绍
SpringBoot 天猫商城，基于前后端分离思想， 由于该商城高并发的特点，后端框架使用了方便维护的 SpringMVC、SpringBoot 框架，前端框架则选择了主流的 BootStrap、Vue.js，JQuery 三大前端框架。

## 后端技术栈
SpringBoot+MySQL+JPA+Redis+Shiro+Elasticsearch+Axios

## 特点
使用 Hibernate (JPA)进行数据持久化，使用 JPA 的 Page 类实现分页。

商品搜索场景引入 Elasticsearch，满足大规模数据查询时的高性能和实时性。

基于 Shiro 实现注册、登录、退出，使用MD5(加盐) 加密，保证了安全性。

全站数据通过 Redis 进行了缓存处理，查询速度优化到毫秒级。


## 使用介绍
往数据库里导入表结构和数据

把Releases的图片资源解压到项目Web资源的对应路径里

IDEA打开项目等待项目依赖下载，然后运行
