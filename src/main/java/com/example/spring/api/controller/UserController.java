package com.example.spring.api.controller;

import com.example.spring.api.dto.SaveUserDto;
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
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody SaveUserDto saveUserDto) {
        User user = userService.saveUser(saveUserDto.toEntity());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user.getId());

    }


}
