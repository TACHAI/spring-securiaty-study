package com.laishishui.springsecuritystudy;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Create by tachai on 2019-11-01 16:01
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // 权限配置
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/").permitAll()   //主路径配置权限访问（所有的都可以访问）
                .anyRequest().authenticated() // 所有的请求要验证
                .and()
                .logout().permitAll() // 所有都可以登出
                .and()
                .formLogin(); // 表单登录

        httpSecurity.csrf().disable();
    }
}
