package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ByeController {

    @GetMapping("/bye")
    public String sayBye(){
        return "Welcome to Spring Security From Bye Controller!";
    }

}
