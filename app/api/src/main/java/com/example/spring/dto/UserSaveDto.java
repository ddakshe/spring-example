package com.example.spring.dto;

import com.example.spring.database.domain.Address;
import com.example.spring.database.domain.User;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
public class UserSaveDto {
    @NotBlank
    @Size(max = 32, min = 3)
    private String name;
    @NotNull
    private Integer age;

    @NotNull
    private Long teamId;

    @Valid
    private Address address;

    public User toEntity() {
        User.UserBuilder userBuilder = User.builder().name(name).age(age);
        if (address != null) {
            userBuilder.homeAddress(Address.builder().roadAddress(address.getRoadAddress()).zipNo(address.getZipNo()).city(address.getCity()).build());
        }
        return userBuilder.build();
    }
}
