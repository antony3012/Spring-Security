package com.springsecurity.service;

import com.springsecurity.entity.Users;
import com.springsecurity.repository.MyUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private MyUserRepo myUserRepo;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users addUser(Users users){
        users.setPassword(encoder.encode(users.getPassword()));
        return myUserRepo.save(users);
    }
}
