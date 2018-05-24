# enjoy_diy

## 初始化

搭建好基础架子，提供一个初始化接口，提供一个接口的单元测试实例

## user controller -> service -> mapper

1. 采用restful风格，新建了user的一个接口，将入参到查库串联起来
2. 入参出参有特定的参数，不与数据库层pojo复用
3. 集成mybatis，查询数据库