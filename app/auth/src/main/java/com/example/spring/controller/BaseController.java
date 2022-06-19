package com.example.spring.controller;

import com.example.spring.SpringUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {

    protected SpringUserDetails userDetails(){
        return ((SpringUserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails());
    }
}
