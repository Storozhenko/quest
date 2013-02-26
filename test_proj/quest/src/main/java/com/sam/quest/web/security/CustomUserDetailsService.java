package com.sam.quest.web.security;


import com.sam.quest.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private LoginService loginService;

    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        return loginService.checkUser(username);
    }

}