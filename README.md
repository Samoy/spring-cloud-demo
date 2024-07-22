# Spring Cloud Demo
学习Spring Cloud的Demo

## 依赖版本
* Java 17 +
* Maven 3.9 +
* MySQL 8 +
* Spring Boot 3.2.0
* Spring Cloud 2022.0.0
* Spring Cloud Alibaba 2022.0.0-RC2

## Spring Cloud Alibaba 组件
* [Nacos](https://nacos.io/): 服务注册与发现
* [Sentinel](https://sentinelguard.io/): 流量控制
* [Seata](https://seata.apache.org/): 分布式事务
* [RocketMQ](https://rocketmq.apache.org/): 消息队列

## 主要功能
* **服务限流降级**：默认支持 Webservlet、Webflux、Openfeign、RestTemplate、spring Cloud Gateway、Dubbo 和 RocketMQ 限流降级功能的接入，可以在运行时通过控制台实时修改限流降级规则，还支持查看限流降级 Metrics 监控。
* **服务注册与发现**：适配 Spring Cloud 服务注册与发现标准，默认集成对应 Spring Cloud 版本所支持的负载均衡组件的适配。
* **分布式配置管理**：支持分布式系统中的外部化配置，配置更改时自动刷新。
* **消息驱动能力**：基于 Spring Cloud Stream 为微服务应用构建消息驱动能力。
* **分布式事务**：使用 `@GlobalTransactional` 注解，高效并且对业务零侵入地解决分布式事务问题。

