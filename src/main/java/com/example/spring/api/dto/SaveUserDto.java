package com.example.spring.api.dto;


import com.example.spring.domain.User;
import lombok.Data;


@Data
public class SaveUserDto {
    private String name;
    private String family;
    private Boolean korean;
    private Integer age;

    public User toEntity() {
        return User.builder().name(name).age(age).build();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setKorean(Boolean korean) {
        this.korean = korean;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
