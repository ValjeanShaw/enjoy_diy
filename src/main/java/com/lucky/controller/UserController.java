package com.lucky.controller;

import com.lucky.exception.BaseException;
import com.lucky.model.input.UserAddInput;
import com.lucky.model.output.UserGetByIdOutput;
import com.lucky.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@Api(tags = "user", description = "用户管理")
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="根据id查询用户", notes="根据url的id来查询user信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public UserGetByIdOutput getUserById(@PathVariable Long id) throws Exception{
        log.info("getUserById 入参：{}",id);
        try{
            return userService.getUserById(id);
        }catch (Exception e){
            throw new BaseException(e.getMessage());
        }
    }


    @ApiOperation(value="添加用户信息", notes="添加用户信息  restful的post方法")
    @RequestMapping(value="/", method= RequestMethod.POST)
    public void addUserInfo(@ModelAttribute UserAddInput input) throws Exception{
        log.info("addUserInfo 入参： {}",input);
        try{
            userService.addUserInfo(input);
        }catch (Exception e){
            throw new BaseException(e.getMessage());
        }
    }


    @ApiOperation(value="添加用户信息", notes="添加用户信息  restful的post方法")
    @RequestMapping(value="/{id}", method= RequestMethod.POST)
    public void addUserInfo(@ModelAttribute UserAddInput input,@PathVariable(value = "id") Long id) throws Exception{
        log.info("addUserInfo 入参： {}",input);
        try{
            userService.addUserInfoForRollBack(input);
        }catch (Exception e){
            throw new BaseException(e.getMessage());
        }
    }

}
