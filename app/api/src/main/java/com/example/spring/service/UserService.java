package com.example.spring.service;

import com.example.spring.database.domain.Team;
import com.example.spring.database.domain.User;
import com.example.spring.repository.TeamRepository;
import com.example.spring.dto.UserDto;
import com.example.spring.dto.UserSaveDto;
import com.example.spring.exception.ErrorCode;
import com.example.spring.exception.ResourceNotFoundException;
import com.example.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final TeamRepository teamRepository;

    public List<UserDto> getUsers() {
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
