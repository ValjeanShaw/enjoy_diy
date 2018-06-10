package com.lucky.service.impl;


import com.alibaba.fastjson.JSON;
import com.lucky.dao.mapper.UserInfoMapper;
import com.lucky.exception.BaseException;
import com.lucky.model.input.UserAddInput;
import com.lucky.model.output.UserGetByIdOutput;
import com.lucky.pojo.UserInfo;
import com.lucky.service.UserService;
import com.lucky.utils.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 600006
 * @version 1.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userMapper;

    //初始密码
    private static final String initPass = "123456";


    @Override
    public UserGetByIdOutput getUserById(Long userId) throws BaseException {
        UserGetByIdOutput userGetByIdOutput = new UserGetByIdOutput();
        UserInfo userInfo = userMapper.selectUserById(userId);
        if (userInfo == null) {
            throw new BaseException("userInfo信息为空");
        }
        BeanUtils.copyProperties(userInfo, userGetByIdOutput, UserGetByIdOutput.class);
        return userGetByIdOutput;
    }

    /**
     * 添加用户信息
     *
     * @param input
     * @return
     * @throws BaseException
     */
    @Override
    public Boolean addUserInfo(UserAddInput input) throws BaseException {
        UserInfo userInfo = BeanUtil.beanCopy(input, UserInfo.class);
        log.info("addUserInfo方法中userInfo：{}", JSON.toJSONString(userInfo));
        userInfo.setPassword(initPass);
        userInfo.setUpdateTime(System.currentTimeMillis());
        userMapper.addUserInfo(userInfo);
        return true;
    }


    /**
     * 为了测试事务而设置的方法  默认RuntimeException的异常回滚
     *
     * Isolation  隔离级别
     * DEFAULT：这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是：READ_COMMITTED。
     READ_UNCOMMITTED：该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。该级别不能防止脏读和不可重复读，因此很少使用该隔离级别。
     READ_COMMITTED：该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
     REPEATABLE_READ：该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。即使在多次查询之间有新增的数据满足该查询，这些新增的记录也会被忽略。该级别可以防止脏读和不可重复读。
     SERIALIZABLE：所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。但是这将严重影响程序的性能。通常情况下也不会用到该级别。
     *
     *Propagation  传播行为
     *
     *
     * REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
     SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
     MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
     REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
     NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
     NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
     NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于REQUIRED。
     *
     * @param input
     * @return
     * @throws BaseException
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public Boolean addUserInfoForRollBack(UserAddInput input) throws BaseException {
        UserInfo userInfo = BeanUtil.beanCopy(input, UserInfo.class);
        log.info("addUserInfo方法中addUserInfoForRollBack：{}", JSON.toJSONString(userInfo));
        userInfo.setPassword(initPass);
        userInfo.setUpdateTime(System.currentTimeMillis());
        userMapper.addUserInfo(userInfo);

        UserInfo userInfo_copy = BeanUtil.beanCopy(input, UserInfo.class);
        log.info("addUserInfo方法中addUserInfoForRollBack：{}", JSON.toJSONString(userInfo));
        //为了尝试回滚而设置的值
        userInfo_copy.setMobile("123456789023456789");
        userMapper.addUserInfo(userInfo_copy);
        return true;
    }
}
