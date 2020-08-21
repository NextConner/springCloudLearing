# springCloudLearing
## 学习SpringCloud 微服务的实践项目
### 项目背景
### 项目环境
### 项目结构
### 踩坑
### 相关项目
---
### 项目背景 
- 分布式系统和微服务几乎是所有web系统架构演进的重要形态,一个完整的分布式系统涵盖的面非常广泛：服务调度,资源调度,流量调度,数据调度,容错处理,自动化运维等.这之中的任意一个方面单独拎出来也是包含了许多复杂内容的,由此可想构建一个高度健壮的分布式系统相当具有难度.
- 抱着不想掉队的想法,从《SpringCloud 入门实战进阶》书中学习关于SpringCloud 微服务框架的和系统构建的相关知识,扩展自身技能.
## 项目环境
- SpringBoot 2.3.3 RELEASE 
- JDK 1.8.1
- 其他依赖 : spring-boot-starter-web,spring-cloud-starter-netflix-eureka-server,spring-boot-starter-securit
## 项目结构
- eureka : eureka-server,注册中心
- eureka-cluster1 : rureka-server,注册中心的集群节点
- eurekaclient : 服务提供者,之后会作为直接关联DB的服务存在
- consumer : 服务消费者,借助 RestTemplate 消费 eurekaclient 提供的服务
//TODO 
