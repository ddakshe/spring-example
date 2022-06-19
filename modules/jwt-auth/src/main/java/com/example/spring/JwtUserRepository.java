package com.example.spring;

import com.example.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String username);
}
