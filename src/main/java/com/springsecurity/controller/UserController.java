package com.springsecurity.controller;

import com.springsecurity.entity.Users;
import com.springsecurity.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UsersService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users users){
        return service.addUser(users);
    }
}
