package com.lucky.utils;

import com.lucky.model.output.UserGetByIdOutput;
import com.lucky.pojo.UserInfo;
import org.springframework.beans.BeanUtils;

/**
 * @author 600006
 * @version 1.0
 */
public class BeanTest {
    public static void main(String args[]){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(123L);
        userInfo.setPassword("sdfsa");
        userInfo.setUpdateTime(45724398L);
        UserGetByIdOutput userGetByIdOutput = new UserGetByIdOutput();
        BeanUtils.copyProperties(userInfo,userGetByIdOutput,UserGetByIdOutput.class);
        System.out.println(userGetByIdOutput);
    }
}
