package com.springsecurity.service;

import com.springsecurity.entity.MyUserDetailsService;
import com.springsecurity.entity.Users;
import com.springsecurity.repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetails implements UserDetailsService {

    @Autowired
    private MyUserRepo myUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = myUserRepo.findByUsername(username);

        if (users == null) {
            System.out.println("user not found");
            throw new UsernameNotFoundException("user not found");
        }
        return new MyUserDetailsService(users);
    }
}
