# spring-study

## 项目必读
1. 强烈继承BaseModel  
2. 强烈建议熟悉工具类：
   1. DateUtil
   2. ObjectUtil（提醒：不允许出现任何空指针，不能用==判断对象相等）
   3. StringUtil（提醒：不允许出现任何空指针，不能用==判断对象相等）

## 项目说明
项目主要功能简介：
1. 全局统一异常处理
2. api版本控制
3. 通用service、通用Mapper
4. 服务注册发现
   1. spring-cloud-eureka-client 服务提供者
   2. spring-cloud-eureka-server 注册服务
   3. spring-cloud-feign-client 服务消费者
5. common模块设计

## 项目成长日志

### 2019.03.20 增加
1. 全局统一异常处理
2. api版本控制
