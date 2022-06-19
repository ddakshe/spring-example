package com.example.spring.controller;

import com.example.spring.SpringUserDetails;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("app/user")
public class AppController extends BaseController{

    @GetMapping("index")
    @Secured("ROLE_USER")
    public String users(){
        SpringUserDetails userDetails = userDetails();
        return "Hello "+ userDetails.getUsername();
    }
}
