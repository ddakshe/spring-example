package com.example.spring.repository;

import com.example.spring.domain.dto.UserDto;
import com.querydsl.core.types.Projections;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.spring.domain.QUser.user;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements UserCustomRepository {

    @Override
    public List<UserDto> getUsers() {
        return queryFactory
                .select(Projections.constructor(UserDto.class,
                        user.name, user.age, user.team.name.as("teamName")))
                .from(user)
                .join(user.team)
                .fetch();
    }
}
