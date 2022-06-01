package com.example.spring.api.dto;


import com.example.spring.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class SaveUserDto {
    private String name;
    private Integer age;

    public User toEntity() {
        return User.builder().name(name).age(age).build();
    }
}
