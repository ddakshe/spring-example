package com.example.spring.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class JwtTokenInfo {
    private String token;
    private Date expiryDate;
}
