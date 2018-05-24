package com.lucky.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.lucky.dao.mapper.UserMapper;
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
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;


    @Override
    public UserGetByIdOutput getUserById(Long userId) {
        UserGetByIdOutput userGetByIdOutput = new UserGetByIdOutput();
        UserInfo userInfo = userMapper.selectUserById(userId);
        BeanUtils.copyProperties(userInfo,userGetByIdOutput,UserGetByIdOutput.class);
        return userGetByIdOutput;
    }

}
