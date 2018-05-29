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