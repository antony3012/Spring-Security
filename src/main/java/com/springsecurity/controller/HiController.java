package com.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @GetMapping("/hi")
    public String sayHi(HttpServletRequest request){
        return "Welcome to Spring Security From Hi Controller! "+request.getSession().getId();
    }

}
