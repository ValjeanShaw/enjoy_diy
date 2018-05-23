package com.lucky.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 600006
 * @version 1.0
 */
@RestController
@RequestMapping({"/init","/initHello"})
public class InitController {

    @RequestMapping("/hello")
    public String init(){
        return "init finish";
    }
}
