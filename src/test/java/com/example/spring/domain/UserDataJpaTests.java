package com.example.spring.domain;

import com.example.spring.domain.dto.UserDto;
import com.example.spring.repository.TeamRepository;
import com.example.spring.repository.UserRepository;
import com.querydsl.core.types.Projections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

import static com.example.spring.domain.QUser.user;
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

    @Test
    void searchByQuery() {

        List<UserDto> users  = query
                .select(Projections.constructor(UserDto.class,
                        user.name,
                        user.age,
                        user.team.name.as("teamName")))
                .from(user)
                .join(user.team)
                .where(user.team.name.eq("개발팀"))
                .fetch();

        System.out.println("list = " + users);
    }
}

