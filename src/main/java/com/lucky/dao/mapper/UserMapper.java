package com.lucky.dao.mapper;

import com.lucky.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author 600006
 * @version 1.0
 */
@Mapper
@Component
public interface UserMapper {

    /**
     * 根据id查询用户信息
     * @param userId
     */
    public UserInfo selectUserById(Long userId);
}
