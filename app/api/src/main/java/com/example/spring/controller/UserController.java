package com.example.spring.controller;

import com.example.spring.domain.User;
import com.example.spring.dto.UserDto;
import com.example.spring.dto.UserSaveDto;
import com.example.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_USER")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserSaveDto userSaveDto) {
        User user = userService.saveUser(userSaveDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user.getId());

    }


}
