package com.example.spring.controller;

import com.example.spring.jwt.JwtUserDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BaseController {

    protected JwtUserDetails userDetails() {
        return ((JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails());
    }
}
