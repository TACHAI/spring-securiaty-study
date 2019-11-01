package com.laishishui.springsecuritystudy.Controller;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
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
//    @PreAuthorize("#id<10 or principal.username.equals(#username)")
    @PreAuthorize("hasRole('ROLE_ADMIN')or hasRole('ROLE_USER')")
    @PostAuthorize("hasRole('')")
    @RequestMapping("/hello")
    public String hello(Integer id,String username){
        return "hello world";
    }
}
