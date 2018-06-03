package com.lucky.service;

import com.lucky.exception.BaseException;
import com.lucky.model.input.UserAddInput;
import com.lucky.model.output.UserGetByIdOutput;
import com.lucky.pojo.UserInfo;

/**
 * @author 600006
 * @version 1.0
 */
public interface UserService {

    /**
     * 通过userId 查询用户
     * @param userId
     * @return
     */
    public UserGetByIdOutput getUserById(Long userId) throws BaseException;

    public Boolean addUserInfo(UserAddInput input) throws BaseException;

    public Boolean addUserInfoForRollBack(UserAddInput input) throws BaseException;


}
