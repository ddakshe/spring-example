package com.example.spring.api.controller;

import com.example.spring.domain.User;
import com.example.spring.api.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController  {

    private final UserService userService;

    @GetMapping("hello")
    public String hello(){
        return "Hello";
    }

}
