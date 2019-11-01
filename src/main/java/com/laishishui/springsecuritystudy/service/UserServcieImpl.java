package com.laishishui.springsecuritystudy.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Create by tachai on 2019-11-01 17:07
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Service
public class UserServcieImpl implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
