# enjoy_diy

> 采用spring boot方式开发，约定大于配置，抛弃spring mvc的大量繁琐xml配置

### 初始化

搭建好基础架子，提供一个初始化接口，提供一个接口的单元测试实例

### user controller -> service -> mapper

1. 采用restful风格，新建了user的一个接口，将入参到查库串联起来
2. 入参出参有特定的参数，不与数据库层pojo复用
3. 集成mybatis，查询数据库

### 统一异常处理机制

自定义异常，采用@ControllerAdvice   @ExceptionHandler拦截最终抛出的异常，
返回给前端统一的验证格式

### 添加swaggerUI

加入接口的swaggerui

### log4j2日志方式

采用xml方式，配置log4j2的日志

slf4j-log4j2的方式打印

含三种格式
1.CONSOLE
2.file
3.rollingFile

### 采用jar包方式运行

pom中war包方式改为jar包方式，打包和编译均采用maven方式

运行方式： `java -jar xxx.jar`

### 加入Thymeleaf方式

采用Thymeleaf模板渲染界面。
加入一个示例方法 index 界面


### 自定义注解

加入一个自定义注解，并将其使用方法做个实例

详见 test -> annotation包

### 事务处理

 新建一个插入数据库的接口，并执行一个入库事务操作必定会出错的情况，执行事务回滚

* Isolation  隔离级别

 DEFAULT：这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是：READ_COMMITTED。
 READ_UNCOMMITTED：该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。该级别不能防止脏读和不可重复读，因此很少使用该隔离级别。
 READ_COMMITTED：该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
 REPEATABLE_READ：该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。即使在多次查询之间有新增的数据满足该查询，这些新增的记录也会被忽略。该级别可以防止脏读和不可重复读。
 SERIALIZABLE：所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。

* Propagation  传播行为

 REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
 SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
 MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
 REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
 NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
 NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
 NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于REQUIRED。
 
 ### 集成redis
 
> 在spring boot环境下，开启缓存技术只需要三步
1. 依赖包
2. 填入相关配置
3. 配置类使用 @EnableCaching 注解

spring boot 2.0集成 redis，需要以下三步
1.引入依赖包
2.新建配置项
3.创建bean

