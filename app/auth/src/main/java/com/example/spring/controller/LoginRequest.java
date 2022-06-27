package com.example.spring.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LoginRequest {
    @Email
    private String id;
    @Size(min = 8, max = 20)
    private String pw;
}
