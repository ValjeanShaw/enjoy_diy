# enjoy_diy

## 初始化

搭建好基础架子，提供一个初始化接口，提供一个接口的单元测试实例

## user controller -> service -> mapper

1. 采用restful风格，新建了user的一个接口，将入参到查库串联起来
2. 入参出参有特定的参数，不与数据库层pojo复用
3. 集成mybatis，查询数据库

### 统一异常处理机制

自定义异常，采用@ControllerAdvice   @ExceptionHandler拦截最终抛出的异常，
返回给前端统一的验证格式