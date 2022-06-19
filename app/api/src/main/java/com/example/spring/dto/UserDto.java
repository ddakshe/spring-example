package com.example.spring.dto;

import com.example.spring.domain.Address;
import com.example.spring.domain.User;
import lombok.Getter;

@Getter
public class UserDto extends BaseResultDto{
    private final String name;
    private final Integer age;
    private final Address homeAddress;
    private final TeamDto team;

    public UserDto(User user) {
        super(user);
        name = user.getName();
        age = user.getAge();
        homeAddress = user.getHomeAddress();
        team = TeamDto.fromEntity(user.getTeam());
    }

}
