package com.example.spring.api.controller;

import com.example.spring.api.dto.UserSaveDto;
import com.example.spring.api.dto.UserDto;
import com.example.spring.api.service.UserService;
import com.example.spring.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        List<UserDto> users = userService.getUsers();
        return users;
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserSaveDto userSaveDto) {
        User user = userService.saveUser(userSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user.getId());

    }


}
