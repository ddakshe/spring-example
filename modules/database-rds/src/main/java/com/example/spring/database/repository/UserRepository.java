package com.example.spring.database.repository;

import com.example.spring.database.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.data.jpa.repository.JpaRepository;


//@ConditionalOnMissingBean
public interface UserRepository extends JpaRepository<User, Long> {

}
