package com.laishishui.springsecuritystudy.util;

import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.provider.MD5;

import java.util.HashMap;

/**
 * Create by tachai on 2019-11-01 17:14
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class MyPasswordEncoder implements PasswordEncoder {


    @Override
    public String encode(CharSequence rawPassword) {
        // todo 研究下DelegatingPasswordEncoder 这个怎么用
        DelegatingPasswordEncoder encoder = new DelegatingPasswordEncoder("",new HashMap<>());
        return encoder.encode(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return false;
    }
}
