package com.example.spring.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
    private String name;
    private Integer age;
    private String teamName;
}
