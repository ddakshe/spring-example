package com.example.spring.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.spring.api.repository.UserRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTests extends BaseTests {
    @Autowired
    private UserRepository userRepository;

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
}

