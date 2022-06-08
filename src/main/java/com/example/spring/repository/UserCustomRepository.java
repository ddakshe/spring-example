package com.example.spring.repository;

import com.example.spring.domain.dto.UserDto;

import java.util.List;

public interface UserCustomRepository {

    List<UserDto> getUsers();
}
