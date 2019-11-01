package com.laishishui.springsecuritystudy;

import com.laishishui.springsecuritystudy.service.UserServcieImpl;
import com.laishishui.springsecuritystudy.util.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Create by tachai on 2019-11-01 16:01
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServcieImpl userServcie;

    // 配置用户名密码
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        // auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
        // auth.inMemoryAuthentication().withUser("demo").password("demo").roles("USER");


        auth.userDetailsService(userServcie).passwordEncoder(new MyPasswordEncoder());

        auth.jdbcAuthentication().usersByUsernameQuery("").authoritiesByUsernameQuery("").passwordEncoder(new MyPasswordEncoder());
    }


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

    @Override
    public void configure(WebSecurity webSecurity){
        webSecurity.ignoring().antMatchers("/js/**","/css/**","/images/**");
    }
}
