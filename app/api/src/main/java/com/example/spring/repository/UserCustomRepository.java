package com.example.spring.repository;

import com.example.spring.dto.UserDto;

import java.util.List;

public interface UserCustomRepository {

    List<UserDto> getUsers();
}
