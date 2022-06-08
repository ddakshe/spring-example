package com.example.spring.api.dto;

import com.example.spring.domain.Address;
import com.example.spring.domain.User;
import lombok.Getter;

@Getter
public class UserDto extends BaseResultDto{
    private final String name;
    private final Integer age;
    private final TeamDto team;
    private final Address homeAddress;
    public UserDto(User user) {
        super(user);
        name = user.getName();
        age = user.getAge();
        homeAddress = user.getHomeAddress();
        team = user.getTeam().toDto();
    }

}
