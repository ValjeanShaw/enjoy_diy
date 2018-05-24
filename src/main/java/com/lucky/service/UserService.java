package com.lucky.service;

import com.lucky.model.output.UserGetByIdOutput;

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
    public UserGetByIdOutput getUserById(Long userId);
}
