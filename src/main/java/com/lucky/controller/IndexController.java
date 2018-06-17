package com.lucky.controller;

import com.lucky.config.TestFreedom;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author 600006
 * @version 1.0
 */
@Controller
@RequestMapping("/index")
@EnableConfigurationProperties(TestFreedom.class)
public class IndexController {

    @Resource
    private TestFreedom testFreedom;

    @Value("${freedom.name}")
    private String name;

    @Value("${freedom.email}")
    private String email;

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "127.0.0.1");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

    /**
     * 1. 直接获取参数方式
     * @return
     */
    @RequestMapping("/getProfile")
    @ResponseBody
    public String getProfile(){
        return "自定义config方式1  name:"+name+"email:"+email;
    }

    /**
     * 2. javabean  方式
     * @return
     */
    @RequestMapping("/getProfileByJavaBean")
    @ResponseBody
    public String getProfileByJavaBean(){
        return "自定义config方式2   name:"+testFreedom.getName()+"email:"+testFreedom.getEmail();
    }
}
