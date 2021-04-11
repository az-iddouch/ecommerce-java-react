package com.vash.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vash.security.aop.LogTracer;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    @LogTracer
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // add logic to fetch user from db
        return new User("test", "test", new ArrayList<>());
    }
}


