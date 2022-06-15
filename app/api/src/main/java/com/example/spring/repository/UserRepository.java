package com.example.spring.repository;

import com.example.spring.database.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("APIUserRepository")
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

}
