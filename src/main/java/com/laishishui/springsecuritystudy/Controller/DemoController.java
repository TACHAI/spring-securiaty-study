package com.laishishui.springsecuritystudy.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by tachai on 2019-11-01 16:29
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@RestController
//@RequestMapping("")
public class DemoController {

    @RequestMapping("/")
    public String home(){
        return "hello spring boot";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
