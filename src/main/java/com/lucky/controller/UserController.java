package com.lucky.controller;

import com.lucky.exception.BaseException;
import com.lucky.model.output.UserGetByIdOutput;
import com.lucky.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "user", description = "用户管理")
@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value="根据id查询用户", notes="根据url的id来查询user信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    })
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public UserGetByIdOutput getUserById(@PathVariable Long id) throws Exception{
        try{
            return userService.getUserById(id);
        }catch (Exception e){
            throw new BaseException(e.getMessage());
        }
    }
}
