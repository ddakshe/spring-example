package com.example.spring.api.service;

import com.example.spring.domain.dto.UserDto;
import com.example.spring.api.dto.UserSaveDto;
import com.example.spring.repository.TeamRepository;
import com.example.spring.repository.UserRepository;
import com.example.spring.config.exception.ErrorCode;
import com.example.spring.config.exception.ResourceNotFoundException;
import com.example.spring.domain.Team;
import com.example.spring.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;


    public List<UserDto> getUsers() {
//        return userRepository.findAll()
//                .stream().map(UserDto::new).collect(Collectors.toList());
        return userRepository.getUsers();
    }

    @Transactional
    public User saveUser(UserSaveDto userSaveDto) {
        if (!teamRepository.existsById(userSaveDto.getTeamId())) {
            throw new ResourceNotFoundException(ErrorCode.NOT_EXIST_TEAM, Team.class.getName(), userSaveDto.getTeamId());
        }

        User user = userSaveDto.toEntity();
        teamRepository.findById(userSaveDto.getTeamId())
                .ifPresent(user::setTeam);
        return userRepository.save(user);
    }
}
