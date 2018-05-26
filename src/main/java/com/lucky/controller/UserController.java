package com.lucky.controller;

import com.lucky.exception.BaseException;
import com.lucky.model.output.UserGetByIdOutput;
import com.lucky.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 600006
 * @version 1.0
 *
 * 用户接口
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public UserGetByIdOutput getUserById(@PathVariable Long id) throws Exception{
        try{
            return userService.getUserById(id);
        }catch (Exception e){
            throw new BaseException(e.getMessage());
        }
    }
}
