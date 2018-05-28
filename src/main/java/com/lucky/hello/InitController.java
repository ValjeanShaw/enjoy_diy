package com.lucky.hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 600006
 * @version 1.0
 */
@Api(tags = "测试接口", description = "")
@Controller
@RequestMapping({"/init","/initHello"})
public class InitController {

    @ApiOperation(value="hello world接口", notes="")
    @RequestMapping("/hello")
    @ResponseBody
    public String init(){
        return "init finish";
    }

}
