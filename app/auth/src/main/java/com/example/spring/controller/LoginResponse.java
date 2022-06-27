package com.example.spring.controller;

import com.example.spring.jwt.JwtTokenInfo;
import lombok.Getter;


@Getter
public class LoginResponse {
    private final String tokenType = "Bearer";
    private final JwtTokenInfo accessToken;
    private final JwtTokenInfo refreshToken;

    public LoginResponse(JwtTokenInfo accessToken, JwtTokenInfo refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
