package com.lucky.service.impl;

import com.lucky.dao.mapper.UserInfoMapper;
import com.lucky.exception.BaseException;
import com.lucky.model.output.UserGetByIdOutput;
import com.lucky.pojo.UserInfo;
import com.lucky.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 600006
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoMapper userMapper;


    @Override
    public UserGetByIdOutput getUserById(Long userId) throws BaseException{
        UserGetByIdOutput userGetByIdOutput = new UserGetByIdOutput();
        UserInfo userInfo = userMapper.selectUserById(userId);
        if (userInfo == null) {
            throw new BaseException("userInfo信息为空");
        }
        BeanUtils.copyProperties(userInfo, userGetByIdOutput, UserGetByIdOutput.class);
        return userGetByIdOutput;
    }

}
