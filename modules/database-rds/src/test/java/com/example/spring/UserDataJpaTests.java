package com.example.spring;


import com.example.spring.database.domain.Team;
import com.example.spring.database.domain.User;
import com.example.spring.database.repository.TeamRepository;
import com.example.spring.database.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserDataJpaTests extends BaseDataJpaTests  {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;

    @BeforeEach
    @Transactional
    void setUp() {
        Team team = Team.builder().name("개발팀").build();
        teamRepository.save(team);

        User user = User.builder().name("kennen").age(37).team(team).build();
        userRepository.save(user);
    }

    @Test
    void testSize() {
        assertEquals(userRepository.count(), 1L);
    }

    @Test
    void findAll() {
        List<User> all = userRepository.findAll();
        System.out.println(all);
    }

}

