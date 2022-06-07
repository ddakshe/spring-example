package com.example.spring.domain;

import static com.example.spring.domain.QTeam.*;
import static com.example.spring.domain.QUser.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.spring.api.repository.UserRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


public class UserDataJpaTests extends BaseDataJpaTests {
    @Autowired
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @BeforeEach
    @Transactional
    void setUp() {
        User user = User.builder().name("kennen").age(37).build();
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
        JPAQueryFactory query = new JPAQueryFactory(entityManager);
        List<User> all = userRepository.findAll();
        List<Tuple> list = query.select(user.count(),
                        user.name,
                        user.age)
                .from(user)
                .where(user.team.name.eq("개발팀"))
                .fetch();

        System.out.println("list = " + list);
    }
}

